# Concurrency and Multi-threading Architecture

## Quiz
#### Prepare answers to following questions
* What are differences between `wait` and `sleep` methods in Java?
* What is an atomic operation? What are atomic operations in Java?
* What is a `volatile` keyword in Java? How do you use it? How is it different from the synchronized method in Java?
* What is a race condition? How will you find and solve race condition?
* Why do we call `start()` method which in turns calls `run()` method, why not we directly call `run()` method?
* What is an immutable object? How does it help in writing a concurrent application?
* Which granularity size uses `java.util.Arrays` in its parallelSort set of methods to decide to parallelize or not?
* You have thread T1, T2, and T3. How will you ensure that thread T2 is run after T1 and thread T3 after T2?
* What is the advantage of the `Lock` interface over a synchronized block in Java? You need to implement a high-performance cache, which allows multiple readers, but how will you implement the single writer to keep the integrity?
* What is the difference between `CyclicBarrier` and `CountdownLatch` in Java?
* What is "Work Stealing" algorithm?

---
# 1.1 Object, thread and monitor.

*First of all, we should check `Object` class and what we can see there.*

1. *Native `notify()` method. Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this object, one of them is chosen to be awakened. The choice is arbitrary and occurs at the discretion of the implementation. A thread waits on an object's monitor by calling one of the wait methods.*
    ```
    public final native void notify();
    ```    
2. *Native `notifyAll()` method. Wakes up all threads that are waiting on this object's monitor. A thread waits on an object's monitor by calling one of the wait methods.*
    ```
    public final native void notifyAll();
    ```    
3. *Three versions of `wait()` method. Causes the current thread to wait until it is awakened, typically by being notified or interrupted.*  
    ```
        public final void wait() throws InterruptedException {
            wait(0L);
        }

        public final native void wait(long timeoutMillis) throws InterruptedException;

        public final void wait(long timeoutMillis, int nanos) throws InterruptedException {
            ...
        }
    ```

> More information is available here: [Class Object Java Oracle Docs](https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html).

*Firstly, we can use all of those method in a special block of code or can mention an additional keyword for some methods.*
```
...
    synchronized(LOCK) {
        LOCK.wait(); // LOCK is not held
    }
...
```

*Where `LOCK` is class Object (for example: Object LOCK = new Object()). 
The second one condition for the keyword `synchronized` is a way to use with case:*
```
...
    public int counter;

    public synchronized int getCounter() {
            return counter;
        }
...
```

*Where can we see a `sleep()` method? Of course, the Object class doesn't have this one. Just open `Thread` class and check this method:*  
```
public static native void sleep(long millis) throws InterruptedException
```
#### Description:   
**"Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds, subject to the precision and accuracy of system timers and schedulers. The thread does not lose ownership of any monitors..."**
> More information is available here: [Class Thread Java Oracle Docs](https://docs.oracle.com/javase/10/docs/api/java/lang/Thread.html). 
> [Sleep method](https://docs.oracle.com/javase/10/docs/api/java/lang/Thread.html#sleep(long))

#### Extra:
> Q: What the differed between `wait()` and `sleep()`?  
> A: `sleep()` is a method that is used to suspend the process for a few seconds or for the time we need. But in the case of the `wait()` method, the thread goes into a waiting state and will not return automatically until we call the `notify()` or `notifyAll()` function.

## Thread or Runnable?  
*There are two ways to create a new thread of execution. One is to declare a class to be a subclass of Thread. This subclass should override the run method of class Thread. An instance of the subclass can then be allocated and started. For example, a thread that computes primes larger than a stated value could be written as follows:*

```
 class PrimeThread extends Thread {
         long minPrime;
         PrimeThread(long minPrime) {
             this.minPrime = minPrime;
         }

         public void run() {
             // compute primes larger than minPrime
              . . .
         }
     }
```
*The following code would then create a thread and start it running:*
```
    PrimeThread p = new PrimeThread(143);
    p.start();
```
*The other way to create a thread is to declare a class that implements the Runnable interface. That class then implements the run method. An instance of the class can then be allocated, passed as an argument when creating Thread, and started. The same example in this other style looks like the following:*
```
  class PrimeRun implements Runnable {
         long minPrime;
         PrimeRun(long minPrime) {
             this.minPrime = minPrime;
         }

         public void run() {
             // compute primes larger than minPrime
              . . .
         }
     }
 
```
*The following code would then create a thread and start it running:*
```
    PrimeRun p = new PrimeRun(143);
    new Thread(p).start();
```

> More about Thread you can read here: [Oracle Thread](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#Thread%28%29)  
> Read more about [happens-before](https://docs.oracle.com/javase/specs/jls/se7/html/jls-17.html)

## 1.1 Practice part.
1. Create a new class and use wait(), notify(), notifyAll() methods with synchronized block.
2. Create a new class and use Thread.sleep() in method, in synchronized block.

---
# 2.1 Immutable object.`volatile` and `Atomic` variables.   

## Immutable classes  

*Why we need immutable classes? What about the main reason?*

**Immutable classes make concurrent programming easier. Immutable classes make sure that values are not changed in the middle of an operation without using synchronized blocks. By avoiding synchronization blocks, you avoid deadlocks. And since you are always working with an unchangeable consistent state, you avoid race conditions. In the following article, we will look at how to use immutable classes for concurrent programming in Java.**

*Simple example:*
```
public class User {

    private final String userName;
    private final String password;

    public ImmutableLogin(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
}
```

## Volatile variables
**In programming, an atomic action is one that effectively happens all at once. An atomic action cannot stop in the middle: it either happens completely, or it doesn't happen at all. No side effects of an atomic action are visible until the action is complete.**  

*In real case, we can see a code sample like this:*

```
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
```

**Atomic actions cannot be interleaved, so they can be used without fear of thread interference. However, this does not eliminate all need to synchronize atomic actions, because memory consistency errors are still possible. Using volatile variables reduces the risk of memory consistency errors, because any write to a volatile variable establishes a happens-before relationship with subsequent reads of that same variable. This means that changes to a volatile variable are always visible to other threads. What's more, it also means that when a thread reads a volatile variable, it sees not just the latest change to the volatile, but also the side effects of the code that led up the change.**

**Using simple atomic variable access is more efficient than accessing these variables through synchronized code, but requires more care by the programmer to avoid memory consistency errors. Whether the extra effort is worthwhile depends on the size and complexity of the application.**

> Read more about caches [Java volatile and caches](https://medium.com/@siddhusingh/volatile-visibility-in-jvm-3d2044da017c)  
> Docs [Java Oracle documentation about volatile](https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html)

## Atomics
*The AtomicInteger class protects an underlying int value by providing methods that perform atomic operations on the value. It shall not be used as a replacement for an Integer class.*
*The AtomicInteger class is part of the java.util.concurrent.atomic package since Java 1.5.*

*The creation of AtomicInteger is straight forward by calling a constructor. The AtomicInteger provides two methods to get and set the values of it’s instances.*
```
AtomicInteger atomicIntegerZero = new AtomicInteger();  //Initial value is 0
AtomicInteger atomicIntegerTen = new AtomicInteger(10); //Initial value is 10
int currentValue = atomicIntegerZero.get(); // 0
atomicInteger.set(1); // set 1
```

*In real life uses, we will need AtomicInteger in two cases:*

- As an atomic counter which is being used by multiple threads concurrently.
- In compare-and-swap operations to implement non-blocking algorithms.

*A compare and swap operation compares the contents of a memory location to a given value and, only if they are the same, modifies the contents of that memory location to a given new value. This is done as a single atomic operation. The atomicity guarantees that the new value is calculated based on up-to-date information; if the value had been updated by another thread in the meantime, the write would fail. To support compare and swap operations, this class provides a method which atomically sets the value to the given updated value if the current value == the expected value.*

*As discussed above, the primary use of AtomicInteger is when we are in multi-threaded context and we need to perform atomic operations on an int value without using synchronized keyword.Using the AtomicInteger is equally faster and more readable than performing the same using synchronization.*

> Original [Atomic integer on Java](https://howtodoinjava.com/java/multi-threading/atomicinteger-example/)


## 2.2 Practice part.
1. Create own immutable classes.
2. Create a class with a counter which has the `volatile` modification.
3. Create new class with AtomicInteger counter.

---
# 3.1 Locks, `DeadLock`, Semaphore.

## Deadlock 

*Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.*

- Classic example:  
 There're two threads and two resources.
 Thread 1 is locking `resource A` and try to get `resource B`, but Thread 2 is locking `resource B` and try to get `resource A`.


> More information about deadlock with example: [Oracle Documentation](https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html)

## Semaphore

**A counting semaphore. Conceptually, a semaphore maintains a set of permits. Each acquire() blocks if necessary until a permit is available, and then takes it. Each release() adds a permit, potentially releasing a blocking acquirer. However, no actual permit objects are used; the Semaphore just keeps a count of the number available and acts accordingly.**

> More information here: [Oracle documentation](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html)  
> Habr (Rus) Semaphore guideline: [link](https://habr.com/ru/post/277669/)

## BlockingQueue

**A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element.**

> More [Oracle Documentation](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html)


## 3.2 Practice task.
1. Solve [producer–consumer problem](https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem)
Using:
  1.1 Semaphore
  1.2 BlockingQueue
2. Write simplest code that will result in a deadlock.

---

## 4.1 Blurring for Clarity? (Join pool, ForkPool and etc)

**The fork/join framework is an implementation of the ExecutorService interface that helps you take advantage of multiple processors. It is designed for work that can be broken into smaller pieces recursively. The goal is to use all the available processing power to enhance the performance of your application.**

**As with any ExecutorService implementation, the fork/join framework distributes tasks to worker threads in a thread pool. The fork/join framework is distinct because it uses a work-stealing algorithm. Worker threads that run out of things to do can steal tasks from other threads that are still busy.**

**The center of the fork/join framework is the ForkJoinPool class, an extension of the AbstractExecutorService class. ForkJoinPool implements the core work-stealing algorithm and can execute ForkJoinTask processes.**

> See more: [Java SE Fork/Join tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html)

## 4.2 Practice part.
Execute `ForkBlur` example from [Java SE Fork/Join tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html)

---

## 5.1 RecursiveTask, RecursiveAction
**A recursive resultless ForkJoinTask. This class establishes conventions to parameterize resultless actions as Void ForkJoinTasks. Because null is the only valid value of type Void, methods such as join always return null upon completion.**

## 5.2 Practice task.
1. Give last example from [`RecursiveAction`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveAction.html) javadoc about calculation of sum of squares in `double[]` array.
2. Use double array of half-billion size `500_000_000` filled by random doubles.
3. Compare speed with direct linear calculation (you may use Stream API as well):

```
    double sum = 0;
    for (double v : ARRAY) {
        sum += v * v;
    }
```

---

## 6.1 Future & CompletableFuture

First of all, we should read about Future.

`A Future represents the result of an asynchronous computation. Methods are provided to check if the computation is complete, to wait for its completion, and to retrieve the result of the computation. The result can only be retrieved using method get when the computation has completed, blocking if necessary until it is ready. Cancellation is performed by the cancel method. Additional methods are provided to determine if the task completed normally or was cancelled. Once a computation has completed, the computation cannot be cancelled. If you would like to use a Future for the sake of cancellability but not provide a usable result, you can declare types of the form Future<?> and return null as a result of the underlying task.`

For example: 
```
 FutureTask<String> future =
   new FutureTask<String>(new Callable<String>() {
     public String call() {
       return searcher.search(target);
   }});
 executor.execute(future);
```

**A Future that may be explicitly completed (setting its value and status), and may be used as a CompletionStage, supporting dependent functions and actions that trigger upon its completion.
When two or more threads attempt to complete, completeExceptionally, or cancel a CompletableFuture, only one of them succeeds.**

> Read more here: [Oracle documentation](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)

## 6.2 Practice task.
1. Watch video from Alexey Zinovyev with practical examples about `CompletableFuture`: [Concurrency and Multi-Threading Architecture (Part 2/2)](https://videoportal.epam.com/video/LoBYr2a9)  
2. (Optional) Create some task with CompletableFuture with reading/writing (NIO).
---


## Practical task evaluation rules
* Deadlock simulation : 1 point
* Producer-consumer problem : 1 point
* FibonacciTask : 1 point
* Sum of double squares : 0.5 points
* Blurring for Clarity : 0.5 points
* CompletableFuture examples : 1 point

## References
1. [java.util.concurrent (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html)
1. [Java SE High Level Concurrency tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/highlevel.html)
1. [Java SE Fork/Join tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html)
1. [Concurrency Models](http://tutorials.jenkov.com/java-concurrency/concurrency-models.html)
1. [Java EE Concurrency and Multithreading](https://www.linkedin.com/comm/learning/java-ee-concurrency-and-multithreading)

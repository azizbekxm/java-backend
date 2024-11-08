Q: What does threads share between each other?
==================

1. process's resources
2. memory
3. program counters
4. local variables in stack

Correct: 1, 2

Q: Benefits of threads usage are  ...?
==================

1. Exploiting Multiple Processors
2. More Responsive User Interfaces
3. Prevents memory leaks
4. Simplified Handling of Asynchronous Events
5. Performance Hazards
6. Simplified development process

Correct: 1, 2, 4

Q: Does Thread.sleep(...) methods use CPU cycles to execute?
==================

1.	it uses, because sleep operation executed on JVM
2.	if the underlying OS supports blocking calls, then Thread.sleep(...)  will make the calling thread block, not using CPU cycles
3.	it uses, only in case of usage Windows OS
4.	it uses, only in case of usage Linux OS

Correct: 2

Q: A thread can be terminated for the next reasons:
==================

1. It dies a natural death because the run method exits normally
2. It dies abruptly because an uncaught exception terminates the run method.
3. It dies, because other thread locked it
4. It dies, because the method was synchronized

Correct: 1, 2

Q: What method does register thread in a thread scheduler?
==================

1. run();
2. start();
3. construct();
4. register();

Correct: 2

Q: What class or interface does keep the wait(), notify(), and notifyAll() methods implementations?
==================

1. Object
2. Runnable
3. Thread
4. Class
5. Semaphore

Correct: 1

Q: Which of the following statements about threads are correct?
==================

1. Each thread has its own address space in memory
2. To create a thread you may extend the Thread class
3. Threads allow an application to perform different tasks at the same time
4. Thread can be stopped by .stop() method and resumed by .resume() method

Correct: 2, 3

Q: What tools are able to detect deadlocks?
==================

1. jps
2. jstack
3. jconsole
4. VisualVM
5. It is impossible to detect deadlocks
6. jmeter
7. jstat

Correct: 2, 3, 4

Q: What methods does class AtomicInteger have?
==================

1. getAndSet
2. setAndGet
3. getAndIncrement
4. getAndDecrement
5. getAndAdd
6. getAndSubtract
7. addAndGet
8. addAndSet

Correct: 1, 3, 4, 5, 7

Q: Mark keywords that give you indirect control of the usage of the memory barrier
==================

1. try
2. volatile
3. static
4. synchronized
5. transient

Correct: 2, 4

Q: Why ConcurrentHashMap is faster than Hashtable?
==================

1. ConcurrentHashMap is written without synchronization
2. Hashtable uses single lock for whole data, CHM uses multiple locks
3. Hashtable uses multiple locks for reading, CHM don't use reading locks
4. Hashtable uses read-write lock for writing, CHM uses 4 locks for writing

Correct: 2

Q: Please mark all existing JMM rules
==================

1. Monitor lock rule
2. Thread execution rule
3. Associativity
4. Finally rule
5. Thread stop rule

Correct: 1


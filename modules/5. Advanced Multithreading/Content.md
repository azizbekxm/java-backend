**Recommended level:** 
=======================
- Senior / Lead

**Topics:** 
=======================
- Java Multithreading mechanics
- Thread pools
- ForkJoin, Atomics
- Reactive approach with CompletableFuture
- Akka

**Required time for the course:** 
=======================
Lectures: ~20h
Tasks: ~10h mandatory + ~8h optional

Courses: 
=======================

[Parallel and Concurrent Programming with Java 1](https://www.linkedin.com/learning/parallel-and-concurrent-programming-with-java-1/learn-parallel-programming-basics?u=2113185)

[Parallel and Concurrent Programming with Java 2](https://www.linkedin.com/learning/parallel-and-concurrent-programming-with-java-2/learn-parallel-programming-basics?u=2113185)

[Concurrent Object-Oriented Programming with Java and Android (2021)](https://www.youtube.com/watch?v=Hzg9pROCwyY&list=PLZ9NgFYEMxp4n3lpFG0LBnpKhwTkUc6_i)

[CS 891 (2020) Concurrent Object-Oriented Programming with Java and Android](https://www.youtube.com/playlist?list=PLZ9NgFYEMxp6IM0Cddzr_qjqfiGC2pq1a)


Code Examples / Workshop: 
=======================

[CF Tutorial](https://github.com/zaleslaw/Java-Concurrency-Tutorial/tree/master/src/main/java/Chapter_9_CompletableFuture) 2h 00m


[Akka Tutorial (Optional)](https://github.com/zaleslaw/Java-Concurrency-Tutorial/tree/master/src/main/java/Chapter_10_Akka) 3h 00m


Documentation: 
=======================

FJK: [Oracle Docs](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html) 1h 00m

FJK: [Oracle Paper](http://www.oracle.com/technetwork/articles/java/fork-join-422606.html)  1h 00m

[CompletableFuture for Asynchronous Programming in Java 8](https://community.oracle.com/docs/DOC-995305) 1h 00m

[Akka (Optional)](https://doc.akka.io/docs/akka/current/guide/introduction.html?language=java) 4h 00m

References (Optional): 
=======================

[Parallel Programming in Java](https://www.coursera.org/learn/parallel-programming-in-java)

[Concurrent Programming in Java](https://www.coursera.org/learn/concurrent-programming-in-java)

[Blog: Tomasz Nurkiewicz around Java and concurrency](https://www.nurkiewicz.com/search/label/CompletableFuture) 

[Actor Model from a Mathematic point of view](https://channel9.msdn.com/Shows/Going+Deep/Hewitt-Meijer-and-Szyperski-The-Actor-Model-everything-you-wanted-to-know-but-were-afraid-to-ask)

[java.util.concurrent (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html)

[Java SE High Level Concurrency tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/highlevel.html)

[Java SE Fork/Join tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html)

[Concurrency Models](http://tutorials.jenkov.com/java-concurrency/concurrency-models.html)

[producer–consumer problem](https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem)

[`RecursiveTask`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveTask.html)

[`RecursiveAction`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveAction.html)

Additional links to conference presentation or popular education videos: 
=======================

[Java Fork Join example](https://github.com/albertattard/java-fork-join-example)

[CS 891 (2018) Introduction to Parallel Java Programming. Videos 11-18](https://www.youtube.com/playlist?list=PLZ9NgFYEMxp5ZOxpx_RVkkktBMd0S5B6Q)

[Functional Programming with Streams in Java 9](https://learn.epam.com/detailsPage?id=eabad190-3950-4132-9911-e9474f5b98d3)

[Java Concurrency in practice 1st ed.](https://www.amazon.com/Java-Concurrency-Practice-CONCURRENCY-PRACT-ebook-dp-B004V9OA84/dp/B004V9OA84/ref=mt_other?_encoding=UTF8&me=&qid=)


Code example description
=======================
### Class hierarchy

```plantuml
ForkJoinTask <|-- CountedCompleter
RecursiveTask -up-|> ForkJoinTask
ForkJoinTask <|-- RecursiveAction
CountedCompleter -[hidden]> RecursiveTask
RecursiveTask -[hidden]> RecursiveAction

note right of RecursiveAction : Recursive resultless task

class ForkJoinPool {
  void execute(ForkJoinTask<?>)
  <T> T invoke(ForkJoinTask<T>)
}

ForkJoinPool -left-* ForkJoinTask
```

### Flow

```plantuml
skinparam componentStyle rectangle

component Fork as fork
[Task 1] as task_1
[Task 2] as task_2
[...] as task_dots
[Task N] as task_n
component Join as join

fork -down-> task_1
fork -down-> task_2
fork -down-> task_dots
fork -down-> task_n

task_1 -down-> join
task_2 -down-> join
task_dots -down-> join
task_n -down-> join
```

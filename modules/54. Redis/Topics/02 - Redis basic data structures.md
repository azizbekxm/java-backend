# Redis basic data structures

## Read following resources
1. [Time Complexity and Big O notation](https://en.wikipedia.org/wiki/Big_O_notation)

2. [Core Redis data types and theirs use cases](https://redis.io/docs/data-types/tutorial/)

3. [Redis University - Performance and Big O notation](https://www.youtube.com/watch?v=K5xvHzqc9Bk)

## Optional
1. Find different uses cases for Redis String data type.
2. Consider Redis [EXPIREAT](https://redis.io/commands/expireat/) and [SET](https://redis.io/commands/set/) commands. Why
the `SET` command support additional flags for key expiration, despite this introduce redundancy in Redis API?

## Summary
1. Redis provides you with a set of primitive and collection data types.
2. It's your responsibility to design your data model using this data types
3. As all requests from all clients are handled by single thread, you should not send commands, which will execute for long time and will block
other clients. Perform read a list of 1 millions elements with single command is not a good idea. It's important to consider time complexity of commands.

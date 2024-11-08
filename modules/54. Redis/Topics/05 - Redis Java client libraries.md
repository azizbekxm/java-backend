# Redis Java client libraries

## Read following resources

1. [Redis java libraries list](https://redis.io/docs/clients/#java)
2. [Jedis library](https://github.com/redis/jedis), (Jedis Quick Introduction)[https://www.baeldung.com/jedis-java-redis-client-library]
3. [Lettuce library](https://github.com/lettuce-io/lettuce-core)
4. [What is Pipelining](https://redis.io/docs/manual/pipelining/)
5. [Redis Pipelines vs Redis Script vs Redis Transaction](https://rafaeleyng.github.io/redis-pipelining-transactions-and-lua-scripts)

## Optional
1. Lettuce Redis Connection is thread safe, connection pool is considered to be [redundant](https://github.com/lettuce-io/lettuce-core/wiki/Connection-Pooling#is-connection-pooling-necessary) for the most cases. In Jedis,
Redis Connection is not thread safe, common [suggestion](https://www.baeldung.com/jedis-java-redis-client-library#Connection) is to use Jedis with Connection Pool. Why?

## Summary:
1. Redis client libraries are supported by community, there are lot of different libraries, most popular
are Jedis and Lettuce.
2. Jedis is the simplest one
3. Lettuce Redis driver focuses on the asynchronous invocation and integration with project reactor
4. Pipelining allows to send batch of commands and receive the result of their invocation as single request-response pair.
5. Pipelines are not atomic operations.

# Redis Transactions and Lua scripts

## Read following resources
1. [Optimistic lock](https://martinfowler.com/eaaCatalog/optimisticOfflineLock.html)
2. [Pessimistic lock](https://www.martinfowler.com/eaaCatalog/pessimisticOfflineLock.html)

3. [Transactions in Redis](https://redis.io/docs/manual/transactions/)
4. [Lua scripts in Redis](https://redis.io/docs/manual/programmability/eval-intro/)

## Optional
1. Which lock strategy is used in RDMS to handle concurrent data updates?
2. Read [Optimistic Locking in Hibernate](https://vladmihalcea.com/optimistic-locking-version-property-jpa-hibernate/) article.
Why does the optimistic locking can improve throughput in case of RDMS?
3. Why Redis has no pessimistic lock support?

## Summary:
1. Redis transactions are designed to use Optimistic Lock strategy.
2. It's your responsibility to acquire watches with `WATCH` command.
4. Usually, Lua script is better alternative to Redis transaction.
5. Wrapping multiple Redis commands into Lua script allows you to gain additional performance boost by reduce the number of
network round-trips between client and Redis Server.

# Redis cluster

## Read following resources
1. [Redis cluster 101](https://redis.io/docs/manual/scaling/#redis-cluster-101)
2. [Redis data sharding](https://redis.io/docs/manual/scaling/#redis-cluster-data-sharding)
3. [Redis cluster master-replica model](https://redis.io/docs/manual/scaling/#redis-cluster-master-replica-model)
4. [Redis cluster consistency guarantees](https://redis.io/docs/manual/scaling/#redis-cluster-consistency-guarantees)
5. [Redis WAIT Command](https://redis.io/commands/wait/)

## Optional
1. Try to consider Redis Cluster from [CAP Theorem](https://en.wikipedia.org/wiki/CAP_theorem) perspective. How does the usage of `WAIT` command
can affect Redis Cluster behavior in terms of Consistency - Availability - Partition tolerance.

## Summary:
1. Redis supports cluster mode
2. In case of master failure one of it replica nodes can be promoted to new master
3. Each master node is responsible for handling specific range of hash slots
4. Each key is mapped to exact one hash slot to determine which master node should execute command
5. It's possible to use *hash tags* Redis feature to enforce mapping of specific keys to single hash slot
6. Redis scripts, transactions and pipelines can be used only for keys which are mapped to the same hash slot
7. There is time gap between command application on the master node and change replication to replica node, but it's possible
to wait until replication of changes is finished by WAIT command.

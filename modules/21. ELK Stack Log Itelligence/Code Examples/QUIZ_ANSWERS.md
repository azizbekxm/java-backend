# ELK Stack Log Intelligence Module Quiz

## Quiz
#####  What is NoSQL?
    A NoSQL (originally referring to "non SQL" or "non relational")
    database provides a mechanism for storage and retrieval of data that is modeled in means other than the tabular 
    relations used in relational databases. 
    NoSQL databases are increasingly used in big data and real-time web applications. 
    NoSQL systems are also sometimes called "Not only SQL" to emphasize that they may support SQL-like query languages, 
    or sit alongside SQL database in a polyglot persistence architecture.
#####  What is Lucene?
    Apache LuceneTM is a high-performance, full-featured text search engine library written entirely in Java. 
    It is a technology suitable for nearly any application that requires full-text search, especially cross-platform.
#####  What is ElasticSearch?
    Elasticsearch is a distributed, RESTful search and analytics engine capable of solving a growing number of use cases.
    As the heart of the Elastic Stack, it centrally stores your data so you can discover 
    the expected and uncover the unexpected.
#####  What is Analysis?
    Analysis is the process of converting full text to terms. 
    Depending on which analyzer is used, these phrases: FOO BAR, Foo-Bar, foo,bar will probably all result in the terms 
    foo and bar. These terms are what is actually stored in the index. A full text query (not a term query) for FoO:bAR 
    will also be analyzed to the terms foo,bar and will thus match the terms stored in the index. It is this process of 
    analysis (both at index time and at search time) that allows Elasticsearch to perform full text queries.
#####  What is Cluster?
    A cluster consists of one or more nodes which share the same cluster name.
    Each cluster has a single master node which is chosen automatically by the cluster and which can be replaced if the 
    current master node fails.
#####  What is Document?
    A document is a JSON document which is stored in Elasticsearch. 
    It is like a row in a table in a relational database. 
    Each document is stored in an index and has a type and an id. 
    A document is a JSON object (also known in other languages as a hash / hashmap / associative array) which contains zero or more fields, or key-value pairs. 
    The original JSON document that is indexed will be stored in the _source field, which is returned by default when getting or searching for a document.
#####  What is Document ID?
    The ID of a document identifies a document. 
    The index/id of a document must be unique. If no ID is provided, then it will be auto-generated. 
#####  What is Document Field?
    A document contains a list of fields, or key-value pairs. The value can be a simple (scalar) value 
    (eg a string, integer, date), or a nested structure like an array or an object. 
    A field is similar to a column in a table in a relational database. 
    The mapping for each field has a field type (not to be confused with document type) which indicates the type of data
    that can be stored in that field, eg integer, string, object. The mapping also allows you to define 
    (amongst other things) how the value for a field should be analyzed.
#####  What is Filter?
    A filter is a non-scoring query, meaning that it does not score documents. 
    It is only concerned about answering the question - "Does this document match?". 
    The answer is always a simple, binary yes or no. 
    This kind of query is said to be made in a filter context, hence it is called a filter. 
    Filters are simple checks for set inclusion or exclusion. 
    In most cases, the goal of filtering is to reduce the number of documents that have to be examined.
#####  What is Index?
    An index is like a table in a relational database. 
    It has a mapping which contains a type, which contains the fields in the index. 
    An index is a logical namespace which maps to one or more primary shards and can have zero or more replica shards.
#####  What is Mapping?
    A mapping is like a schema definition in a relational database. Each index has a mapping, which defines a type, 
    plus a number of index-wide settings. A mapping can either be defined explicitly, or it will be generated 
    automatically when a document is indexed.
#####  What is Node?
    A node is a running instance of Elasticsearch which belongs to a cluster. 
    Multiple nodes can be started on a single server for testing purposes, but usually you should have one node per server. 
    At startup, a node will use unicast to discover an existing cluster with the same cluster name and will try to join 
    that cluster.
#####  What is Primary Shard?
    Each document is stored in a single primary shard. When you index a document, it is indexed first on the primary 
    shard, then on all replicas of the primary shard.
    By default, an index has 5 primary shards. 
    You can specify fewer or more primary shards to scale the number of documents that your index can handle. 
    You cannot change the number of primary shards in an index, once the index is created. 
#####  What is Query?
    A query is the basic component of a search. 
    A search can be defined by one or more queries which can be mixed and matched in endless combinations. 
    While filters are queries that only determine if a document matches, those queries that also calculate how well the 
    document matches are known as "scoring queries". 
    Those queries assign it a score, which is later used to sort matched documents. 
    Scoring queries take more resources than non scoring queries and their query results are not cacheable. 
    As a general rule, use query clauses for full-text search or for any condition that requires scoring, and use 
    filters for everything else.
#####  What is Replica Shard?
    Each primary shard can have zero or more replicas. A replica is a copy of the primary shard, and has two purposes:
    increase failover: a replica shard can be promoted to a primary shard if the primary fails
    increase performance: get and search requests can be handled by primary or replica shards. 
    By default, each primary shard has one replica, 
    but the number of replicas can be changed dynamically on an existing index. 
    A replica shard will never be started on the same node as its primary shard.
#####  What is Routing?
    When you index a document, it is stored on a single primary shard. 
    That shard is chosen by hashing the routing value. 
    By default, the routing value is derived from the ID of the document or, if the document has a specified parent 
    document, from the ID of the parent document 
    (to ensure that child and parent documents are stored on the same shard). 
    This value can be overridden by specifying a routing value at index time, or a routing field in the mapping.
#####  What is Shard?
    A shard is a single Lucene instance. It is a low-level “worker” unit which is managed automatically 
    by Elasticsearch. An index is a logical namespace which points to primary and replica shards. 
    Other than defining the number of primary and replica shards that an index should have, 
    you never need to refer to shards directly. Instead, your code should deal only with an index. 
    Elasticsearch distributes shards amongst all nodes in the cluster, 
    and can move shards automatically from one node to another in the case of node failure, or the addition of new nodes.
#####  What is Source Field?
    By default, the JSON document that you index will be stored in the _source 
    field and will be returned by all get and search requests. 
    This allows you access to the original object directly from search results, 
    rather than requiring a second step to retrieve the object from an ID.
#####  What is Term?
    A term is an exact value that is indexed in Elasticsearch. 
    The terms foo, Foo, FOO are NOT equivalent. 
    Terms (i.e. exact values) can be searched for using term queries.
#####  What is Text?
    Text (or full text) is ordinary unstructured text, such as this paragraph. 
    By default, text will be analyzed into terms, which is what is actually stored in the index. 
    Text fields need to be analyzed at index time in order to be searchable as full text, 
    and keywords in full text queries must be analyzed at search time to produce 
    (and search for) the same terms that were generated at index time.
#####  What is Type?
    A document is a JSON document which is stored in Elasticsearch. 
    It is like a row in a table in a relational database. 
    Each document is stored in an index and has a type and an id. 
    A document is a JSON object (also known in other languages as a hash / hashmap / associative array) which contains zero or more fields, or key-value pairs. 
    The original JSON document that is indexed will be stored in the _source field, which is returned by default when getting or searching for a document.

## References

[Glossary](https://www.elastic.co/guide/en/elasticsearch/reference/current/glossary.html)

[ElasticSearch Reference](https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html)
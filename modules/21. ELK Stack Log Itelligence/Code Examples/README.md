# ELK Stack Log Intelligence Practical Task Solution

Task description : [PRACTICAL_TASK.md](PRACTICAL_TASK.md)

### Prerequisites
| Artifact  | Version  | Location  |
|---|---|---|---|---|
| Java | 8.0.x | [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  |
| Docker CE  | 1.12.x  | [Docker CE](https://www.docker.com/community-edition)  |
| Maven | 3.6.x  | [Apache Maven](http://maven.apache.org/download.cgi)  |
| MongoDB | 4.0.x+  | [MongoDB](https://www.mongodb.com/download-center)  |
| MongoDB Compass | 1.16.x+  | [MongoDB Compass](https://www.mongodb.com/products/compass)  |
| ElasticSearch | 6.5.x+  | [ElasticSearch Download](https://www.elastic.co/downloads/elasticsearch)  |
| Filebeat | 6.5.x+  | [Filebeat Download](https://www.elastic.co/downloads/beats/filebeat)  |
| Logstash | 6.5.x+  | [Logstash Download](https://www.elastic.co/downloads/logstash)  |
| Kibana | 6.5.x+  | [Kibana Download](https://www.elastic.co/downloads/kibana)  |

## Install
Execute following command-line:
```
  cd <event-service>
  mvn clean install
```

## Usage
Execute following command-line:
```
java -jar event-service-rest\target\event-service-rest-8.0.0-SNAPSHOT.jar

java -jar event-service-rest\target\event-service-rest-8.0.0-SNAPSHOT.jar --server.port=8083 --logging.file=./logs.log

```

## Debug (port 8000)
```
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar event-service-rest\target\event-service-rest-8.0.0-SNAPSHOT.jar
```

## Swagger access
Navigate:
```
http://localhost:8080/swagger-ui.html
```

Note: clean cache and cookies in case if some issues related to access

## References
[Grok debugger](https://grokdebug.herokuapp.com/)

[ELK Stack Downloads](https://www.elastic.co/downloads)

[Glossary](https://www.elastic.co/guide/en/elasticsearch/reference/current/glossary.html)

[ElasticSearch Reference](https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html)

[Getting Started](https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started.html)

[Postman plugin](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)

[Document API](https://www.elastic.co/guide/en/elasticsearch/reference/current/docs.html)

[Search API](https://www.elastic.co/guide/en/elasticsearch/reference/current/search.html)

[QUERY DSL](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl.html)

[Aggregations](https://www.elastic.co/guide/en/elasticsearch/reference/current/search-aggregations.html)

[Java API](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/index.html)

[Rest Java API](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/index.html)

[BULK API](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/java-docs-bulk.html)

[Logstash ](https://www.elastic.co/guide/en/logstash/current/index.html)

[Logstash input plugins](https://www.elastic.co/guide/en/logstash/current/input-plugins.html)

[Logstash output plugins](https://www.elastic.co/guide/en/logstash/current/output-plugins.html)

[Logstash filters](https://www.elastic.co/guide/en/logstash/current/filter-plugins.html)

[Logstash KV filter](https://www.elastic.co/guide/en/logstash/current/plugins-filters-kv.html)

[Logstash mutate filter](https://www.elastic.co/guide/en/logstash/current/plugins-filters-mutate.html)

[Logstash Grok filter](https://www.elastic.co/guide/en/logstash/current/plugins-filters-grok.html)


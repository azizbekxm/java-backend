# Avro demo Spring boot application

This spring boot application demonstrates usages of schema registry. It consists of web 
controller, kafka sender and receiver.

The project contains avro schema files:
[user_v1.avsc](src%2Fmain%2Favro%2Fuser_v1.avsc) - original avro schema file 
[user_v2.avsc_](src%2Fmain%2Favro%2Fuser_v2.avsc_) - modified avto schema file(a property added)
Both the schemas refer the same ``com.epam.jmp.protocols.avro.example.User`` class so one of them 
needs to be renamed to be ignored by avro generator.

Please follow this sequence of steps:
1. Generate avro schema(see details below).
2. A message may be send using the ``/kafka/v1/users`` endpoint(see below). The message is 
sent to kafka and the schema is registered at the same time in schema registry. Then, the 
message is received by the Receiver.
3. The app should be stopped and the User class should be re-generated from user_v2.avsc file
   (please rename user_v1.avsc so it is not visible to generator and does not conflict). 
4. Start the app and use the same call. See that avro schema evolves to new version(wit new 
   property). The property appears in Receiver. 

## How to's

### How to generate Java files from schemas.
This command line can be used to generate class files. They are put into ``[example]
``(build/generated-main-avro-java/`` folder. 
```
gradlew generateAvroJava
```
### How to configure
The following environment variables are required to be set up before app run(Windows sample):
```
set KAFKA_HOST=...
set KAFKA_USER=...
set KAFKA_PASSWORD=...
set KAFKA_REGISTRY_HOST=...
set KAFKA_REGISTRY_USER=...
set KAFKA_REGISTRY_PASSWORD=...
```
Port of web server can be changed in application.yaml.

### How to run
This can be run by standard gradle command line:
```
gradlew bootRun
```
And this in case of debug needs:
```
gradlew bootRun --debugJvm
```
### How to send requests to ``/kafka/v1/users`` endpoint
The request can be send to POST http://localhost:9000/kafka/v1/users endpoint with this payload:
```json
{
	"name" : "John",
	"id" : 1,
	"favoriteColor" : "blue",
	"regret_color" : "red"
}
```
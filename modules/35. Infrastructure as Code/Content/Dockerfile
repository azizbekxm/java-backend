FROM openjdk:11-jre

ARG JAR_FILE=spring-petclinic/target/*.jar

RUN addgroup --system petclinic && adduser --system --group petclinic

USER petclinic:petclinic

COPY ${JAR_FILE} app.jar

CMD ["bash", "-c", "java -jar /app.jar"]

# CMD ["bash", "-c", "java -jar $JAVA_OPTS /app.jar"]

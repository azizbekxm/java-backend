FROM centos:7

MAINTAINER Siarhei Karpenka <Siarhei_Karpenka@epam.com>

USER root

# Repository update
RUN yum -y update && yum clean all

# Install necessary packages
RUN yum list available \*openjdk\*
RUN yum -y install java-11-openjdk

# Environment variables
ARG SERVICE_LOCATION=/apps/jmp/docker/event-service

# Creation of directory structure
RUN mkdir -p "$SERVICE_LOCATION"

WORKDIR $SERVICE_LOCATION

RUN cd $SERVICE_LOCATION

ADD event-service-rest $SERVICE_LOCATION

ENTRYPOINT ["java", "-jar", "event-service-rest-8.0.0-SNAPSHOT.jar"]
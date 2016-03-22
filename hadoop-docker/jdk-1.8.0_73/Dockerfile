FROM ubuntu:14.04

MAINTAINER thank

# install wget
RUN apt-get update \
 && apt-get install -y wget

# install jdk
RUN wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" -q -O - http://download.oracle.com/otn-pub/java/jdk/8u73-b02/jdk-8u73-linux-x64.tar.gz | tar xvfz - -C /opt/
ENV JAVA_HOME="/opt/jdk1.8.0_73"
ENV PATH="$JAVA_HOME/bin:$PATH"

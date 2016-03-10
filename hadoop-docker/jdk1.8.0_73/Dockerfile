FROM ubuntu:14.04

MAINTAINER thank

# install wget
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install wget

# install jdk
RUN wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" --directory-prefix="/tmp" http://download.oracle.com/otn-pub/java/jdk/8u73-b02/jdk-8u73-linux-x64.tar.gz
RUN tar xvfz /tmp/jdk-8u73-linux-x64.tar.gz -C /opt/
RUN rm /tmp/jdk-8u73-linux-x64.tar.gz
ENV JAVA_HOME /opt/jdk1.8.0_73
ENV PATH $JAVA_HOME/bin:$PATH


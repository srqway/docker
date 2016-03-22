FROM jdk:1.8.0_73

MAINTAINER thank

# install zookeeper
RUN wget -q -O - https://archive.apache.org/dist/zookeeper/zookeeper-3.4.5/zookeeper-3.4.5.tar.gz | tar xvfz - -C /opt/
ENV ZOOKEEPER_HOME /opt/zookeeper-3.4.5
ENV PATH $ZOOKEEPER_HOME/bin:$PATH
RUN echo '\
tickTime=2000\n\
dataDir=/var/lib/zookeeper/data\n\
dataLogDir=/var/lib/zookeeper/log\n\
clientPort=2181\n\
initLimit=5\n\
syncLimit=2\n\
server.1=zoo1:2888:3888\n\
server.2=zoo2:2888:3888\n\
server.3=zoo3:2888:3888\n\
' >> $ZOOKEEPER_HOME/conf/zoo.cfg

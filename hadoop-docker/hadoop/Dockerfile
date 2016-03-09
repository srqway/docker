FROM jdk

MAINTAINER thank

# install hadoop
RUN wget --directory-prefix="/tmp" ftp://ftp.twaren.net/Unix/Web/apache/hadoop/common/hadoop-2.6.4/hadoop-2.6.4.tar.gz
RUN tar xvfz /tmp/hadoop-2.6.4.tar.gz -C /opt/
RUN rm /tmp/hadoop-2.6.4.tar.gz
ENV HADOOP_HOME /opt/hadoop-2.6.4
ENV PATH $HADOOP_HOME/bin:$PATH
RUN rm $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '<?xml version="1.0" encoding="UTF-8"?>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '<configuration>'

RUN echo '</configuration>'
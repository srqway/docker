FROM jdk:1.8.0_73

MAINTAINER thank

# install hadoop
RUN wget --directory-prefix="/tmp" ftp://ftp.twaren.net/Unix/Web/apache/hadoop/common/hadoop-2.6.4/hadoop-2.6.4.tar.gz
RUN tar xvfz /tmp/hadoop-2.6.4.tar.gz -C /opt/
RUN rm /tmp/hadoop-2.6.4.tar.gz
ENV HADOOP_HOME /opt/hadoop-2.6.4
ENV PATH $HADOOP_HOME/bin:$PATH

# set core-site.xml
RUN rm $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '<?xml version="1.0" encoding="UTF-8"?>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '<configuration>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '		<name>fs.defaultFS</name>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '		<value>hdfs://master:9000</value>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/core-site.xml
RUN echo '</configuration>' >> $HADOOP_HOME/etc/hadoop/core-site.xml

# set hdfs-site.xml
RUN rm $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '<?xml version="1.0" encoding="UTF-8"?>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '<configuration>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<name>dfs.namenode.http-address</name>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<value>master1:50070</value>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<name>dfs.namenode.name.dir</name>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<value>file://tmp/dfs/name</value>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<name>dfs.namenode.secondary.http-address</name>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<value>master2:50090</value>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<name>dfs.namenode.checkpoint.dir</name>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<value>file://tmp/dfs/namesecondary</value>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<name>dfs.namenode.checkpoint.edits.dir</name>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<value>file://tmp/dfs/namesecondary</value>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<name>dfs.datanode.data.dir</name>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<value>file://tmp/dfs/data</value>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<name>dfs.blocksize</name>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<value>1m</value>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<name>dfs.replication</name>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '		<value>2</value>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '</configuration>' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml

# set mapred-site.xml
RUN echo '<?xml version="1.0"?>' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml
RUN echo '<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml
RUN echo '<configuration>' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml
RUN echo '	<property>' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml
RUN echo '		<name>mapreduce.framework.name</name>' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml
RUN echo '		<value>yarn</value>' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml
RUN echo '	</property>' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml
RUN echo '</configuration>' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml



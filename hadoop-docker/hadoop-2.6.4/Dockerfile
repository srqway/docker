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
RUN echo '\
<?xml version="1.0" encoding="UTF-8"?>\n\
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>\n\
<configuration>\n\
	<property>\n\
		<name>fs.defaultFS</name>\n\
		<value>hdfs://master:9000</value>\n\
	</property>\n\
</configuration>\n\
' >> $HADOOP_HOME/etc/hadoop/core-site.xml

# set hdfs-site.xml
RUN rm $HADOOP_HOME/etc/hadoop/hdfs-site.xml
RUN echo '\
<?xml version="1.0" encoding="UTF-8"?>\n\
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>\n\
<configuration>\n\
	<property>\n\
		<name>dfs.namenode.http-address</name>\n\
		<value>master1:50070</value>\n\
	</property>\n\
	<property>\n\
		<name>dfs.namenode.name.dir</name>\n\
		<value>file://tmp/dfs/name</value>\n\
	</property>\n\
	<property>\n\
		<name>dfs.namenode.secondary.http-address</name>\n\
		<value>master2:50090</value>\n\
	</property>\n\
	<property>\n\
		<name>dfs.namenode.checkpoint.dir</name>\n\
		<value>file://tmp/dfs/namesecondary</value>\n\
	</property>\n\
	<property>\n\
		<name>dfs.namenode.checkpoint.edits.dir</name>\n\
		<value>file://tmp/dfs/namesecondary</value>\n\
	</property>\n\
	<property>\n\
		<name>dfs.datanode.data.dir</name>\n\
		<value>file://tmp/dfs/data</value>\n\
	</property>\n\
	<property>\n\
		<name>dfs.blocksize</name>\n\
		<value>1m</value>\n\
	</property>\n\
	<property>\n\
		<name>dfs.replication</name>\n\
		<value>2</value>\n\
	</property>\n\
</configuration>\n\
' >> $HADOOP_HOME/etc/hadoop/hdfs-site.xml

# set mapred-site.xml
RUN echo '\
<?xml version="1.0"?>\n\
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>\n\
<configuration>\n\
	<property>\n\
		<name>mapreduce.framework.name</name>\n\
		<value>yarn</value>\n\
	</property>\n\
</configuration>\n\
' >> $HADOOP_HOME/etc/hadoop/mapred-site.xml



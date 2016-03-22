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

# set ssh
RUN apt-get -y install openssh-server
RUN apt-get -y install openssh-client
RUN ssh-keygen -t dsa -P '' -f /root/.ssh/id_dsa
RUN cat /root/.ssh/id_dsa.pub >> /root/.ssh/authorized_keys
RUN chmod 600 /root/.ssh/authorized_keys

# set script
RUN echo \
'#!/bin/bash\n'\
'\
echo "172.17.42.201 master1" >> /etc/hosts\n\
echo "172.17.42.199 master2" >> /etc/hosts\n\
echo "172.17.42.31 worker1" >> /etc/hosts\n\
echo "172.17.42.32 worker2" >> /etc/hosts\n\
echo "172.17.42.33 worker3" >> /etc/hosts\n\
echo "172.17.42.34 worker4" >> /etc/hosts\n\
echo "172.17.42.35 worker5" >> /etc/hosts\n\
echo "172.17.42.36 worker6" >> /etc/hosts\n\
/etc/init.d/ssh restart\n\
exit 0\n\
' > /root/thank.sh
RUN chmod 755 /root/thank.sh



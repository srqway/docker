#!/bin/bash
docker build -t="jdk:1.8.0_73" ./jdk1.8.0_73/
docker build -t="hadoop:2.6.4" ./hadoop-2.6.4/
docker run -itd --name="master1" --net=none hadoop:2.6.4 /bin/bash
docker run -itd --name="master2" --net=none hadoop:2.6.4 /bin/bash

/opt/pipework-master/pipework docker0 master1 172.17.42.201/24@172.17.42.1
/opt/pipework-master/pipework docker0 master2 172.17.42.199/24@172.17.42.1

docker exec -d master1 /bin/sh -c /root/thank.sh
docker exec -d master2 /bin/sh -c /root/thank.sh
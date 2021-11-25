#!/bin/sh
mvn clean package && docker build -t com.mycompany/Tarefa-Ejb-Game .
docker rm -f Tarefa-Ejb-Game || true && docker run -d -p 9080:9080 -p 9443:9443 --name Tarefa-Ejb-Game com.mycompany/Tarefa-Ejb-Game
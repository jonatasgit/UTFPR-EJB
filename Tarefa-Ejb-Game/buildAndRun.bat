@echo off
call mvn clean package
call docker build -t com.mycompany/Tarefa-Ejb-Game .
call docker rm -f Tarefa-Ejb-Game
call docker run -d -p 9080:9080 -p 9443:9443 --name Tarefa-Ejb-Game com.mycompany/Tarefa-Ejb-Game
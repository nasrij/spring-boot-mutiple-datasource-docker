# Running Spring Boot Application with Multiple Datasources in Docker
An example how to configure multiple datasources in a Spring Boot application and run it inside docker container linked with postgres database 

## How to run it with Docker
Assume you already have Docker installed. See https://docs.docker.com/installation/.

First, clone the project and build locally:

~~~
git clone https://github.com/nasrij/spring-boot-mutiple-datasource-docker.git
cd spring-boot-mutiple-datasource-docker
mvn clean package docker:build
~~~

Run Postgres in Docker container:

~~~
docker pull postgres
docker run --name demo-postgres -e POSTGRES_PASSWORD=123456 -d postgres
~~~

Check the log to make sure the server is running OK:
~~~
docker logs demo-postgres
~~~

Run demo application in Docker container and link to demo-postgres:

~~~
docker run -p 8080:8080 --name multi-datasource-docker --link demo-postgres:postgresql -d nasrijr/spring-boot-docker-multiple-datasources
~~~


You can check the log by
~~~
docker logs multi-datasource-docker
~~~

Open http://localhost:9999/bar/all in browser and you should see an empty array. you can add new Bars and new Foos.

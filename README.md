# INTRODUCTION
This project is a challenge with NE to build a client application in AngularJs 
from which we can access at the movie gateway API that acts as proxy of OmDB API 
(www.omdbapi.com).

# HOW TO EXPLOIT IT
If you don't want to clone the project you can test immediately the project 
if you have already docker-engine on your machine.
From the root project (~/omgw), just grabs the following command line:
> docker-compose up

# 1. Clone the project
>git clone https://github.com/mehdimahmoud/omgw.git

# 2. Build the project
## With gradle
on windows terminal: 
>gradlew build

on linux/unix shell: 
>./gradlew build

## Or with docker
on windows: 
>gradlew buildDocker

on linux: 
>./gradlew buildDocker

This task carries out in one task two important tasks: 
1. builds the project
2. Creates the docker image of the project

#3. Deploy your project locally
##1. With gradle
>gradlew bootRun

On the console, you can see two embedded tomcat's instances. So you get three interesting access to test:
1. The application portal:
on windows: 
>http://192.168.99.100:8090/

on linux:
>http://localhost:8090/

2. The swagger client to test the gateway API:
on windows: 
>http://192.168.99.100:8090/swagger-ui.html

on linux:
>http://localhost:8090/swagger-ui.html

2. For the metrics:
on windows: 
>http://192.168.99.100:8091/health

on linux:
>http://localhost:8090/health

##2. Or with/on Docker
Once your docker image mmik/omgw is built as explained above, so you can boot the application:
>docker run -it --name=c_omgw -p 8090:8090 -p 8091:8091 mmik/omgw:latest




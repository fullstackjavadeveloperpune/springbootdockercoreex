# springbootdockercoreex

Docker- Docker is an open-source centralized platform designed to create, deploy, and run applications. 
Docker uses container on the host's operating system to run applications.

Before Docker, many users face the problem that a particular code is running in the developer's system but not in the user's system. 
So, the main reason to develop docker is to help developers to develop applications easily, ship them into containers, and can be deployed anywhere.

Docker Software Requirements-

A] Install Docker Desktop for Windows- 
https://docs.docker.com/desktop/windows/install/

B] Download and install the Linux kernel update package- 
https://docs.microsoft.com/en-us/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package

C] Select Windows logo key + R, type winver, select OK. 
You can update to the latest Windows version by selecting Start > Settings > **Windows Update **> Check for updates.
--------------------------------------------------------------------------------
Steps for Docker Spring Boot Application-
1. Create Dockerfile under project root folder- Below are the contents-
FROM openjdk:17
LABEL maintainer="com.fullstack"
ADD target/springbootdockercore-0.0.1-SNAPSHOT.jar springbootdockercore.jar
ENTRYPOINT ["java", "-jar", "springbootdockercore.jar"]

2. Build Docker Image-
docker build -t springbootdockercore:latest .

3. Run Docker Image in a Container-
docker run -p 8081:8080 springbootdockercore
---------------------------------------------------------------------------------
API Testing- Swagger UI-
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.6.0</version>
		</dependency>
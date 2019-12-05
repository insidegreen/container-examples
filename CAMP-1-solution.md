

# 1. Run "hello-world" from Docker Hub

- Search for the image "hello-world"
  - ```docker search hello-world```
- Create a container and run hello-world
  - ```docker run hello-world```
- List running containers
  - ```docker ps```
- List all containers
  - ```docker ps -a```
- What's the name of your "hello-world" Container?
  - ```docker ps -a```
  - Note the column 'names'
- Check the container log by using this name
  - ```docker logs <name>```
- Start the container again by using this name
  - ```docker start <name>```
- Delete your container
  - ```docker delete <name>```
- Delete the "hello-world" image
  - ```docker images```
  - ```docker rmi <name | ID>```

# 2. Run Nginx from Docker Hub

* Search fron 'nginx'
* Run a NGINX Container with flag -d
  * ```docker run -d nginx```
* List running containers
  * ```docker ps```
* Access the NGINX website with your browser
* Why is it now working?
  * NGINX is listening on an internal port 80
* Run the NGINX container again and create a port forward to port 8080
  * ```docker run -d -p 8080:80 nginx```
* Access the NGINX website with your browser


### Modify the index.html file in the NGINX conainer 
* Connect to your NGINX container and open a shell
  * ```docker exec -it <name |ID> bash```
* Replace the content /usr/share/nginx/html/index.html with 'Hello world!'
  * ```echo 'Hello world!' > /usr/share/nginx/html/index.html```
* Access the NGINX website with your browser
* Stop and delete your container
* Run the NGINX container again with port forward to port 8080
* Access the NGINX website with your browser
* Stop and delete all NGINX containers
  * ```docker ps -a```
  * ```docker rm <name |ID> <name | ID>```

### Persistent data
* Create an index.html file with the content of your choice
* Create a NGINX container and mount the index.html to /usr/share/nginx/html/index.html
  * ```docker run -d -v $(pwd)/index.html:/usr/share/nginx/html/index.html```
* Access the NGINX website with your browser
* Change the content of index.html and check the website again
* Stop and delete your container
  * ```docker ps -a```
  * ```docker rm <name |ID> <name | ID>```

# 3. Run a Jenkins Container

- Search for 'jenkins' on Docker Hub
  - ```docker search jenkins```
- Create a container from a Jenkins image and name it "jenkins-master"
  - ```docker run -d -p 8080:8080 --name jenkins jenkins```
- Fullfil the setup process
  - The password can be found in the container log
  - ```docker logs jenkins```
- Stop and delete your container
  - ```docker stop jenkins && docker rm jenkins```
- Re-create the container and persist the Jenkins home directory (/var/jenkins_home/)
  - ```docker run -d -p 8080:8080 -v $(pwd)/jenkins-data:/var/jenkins_home --name jenkins jenkins```
- Fullfil the setup process

# 4. Build and run a Spring Boot REST Service

- Create a Java + Maven image (folder 'java-build-env')
  - ```cd java-build-env```
  - ```docker build -t javabuild-env .```
- Compile and pacakge the Spring Boot Application (folder backend)
  - ```cd backend```
  - use the java-build-env image to create a container <br>
    mount the folder 'backend' into the container <br>
    execute 'mvn package' in the container <br>
  - ``` docker run --rm -v $(pwd):/build java-build-env /bin/sh -c 'cd /build; mvn package'```
  - Build the 'backend' Docker image
  - ```docker build -t backend .```
  - Run a container from the backend image
  - ```docker run -d backend```
  - Access the http://localhost:8080/api/info with your browser
  

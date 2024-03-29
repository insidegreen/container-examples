

# 1. Run "hello-world" from Docker Hub

- Search for the image "hello-world"
- Create a container and run hello-world
- List running containers
- List all containers
- What's the name of your "hello-world" Container?
- Check the container log by using this name
- Start the container again by using this name
- Delete your container
- Delete the "hello-world" image

# 2. Run Nginx from Docker Hub

* Search fron 'nginx'
* Run a NGINX Container with flag -d
  * ```docker run -d nginx```
* List running containers
* Access the NGINX website with your browser
* Why is it now working?
* Run the NGINX container again and create a port forward to port 8080
* Access the NGINX website with your browser
* List all running containers

### Modify the index.html file in the NGINX conainer 
* Connect to your NGINX container and open a shell
* Replace the content /usr/share/nginx/html/index.html with 'Hello world!'
  * echo 'Hello world!' > /usr/share/nginx/html/index.html
* Access the NGINX website with your browser
* Stop and delete your container
* Run the NGINX container again with port forward to port 8080
* Access the NGINX website with your browser
* Stop and delete all NGINX containers

### Persistent data
* Create an index.html file with the content of your choice
* Create a NGINX container and mount the index.html to /usr/share/nginx/html/index.html
* Access the NGINX website with your browser
* Change the content of index.html and check the website again
* Stop and delete your container

# 3. Run a Jenkins Container

- Search for 'jenkins' on Docker Hub
- Create a container from a Jenkins image and name it "jenkins-master" (hint: Jenkins comes up on port 8080)
- Fullfil the setup process
- Stop and delete your container
- Re-create the container and persist the Jenkins home directory (/var/jenkins_home/)
- Fullfil the setup process

# 4. Build and run a Spring Boot REST Service

- Create a Java + Maven image (folder 'java-build-env')
- Compile and pacakge the Spring Boot Application (folder backend)
  - use the java-build-env image to create a container <br>
   mount the folder 'backend' into the container <br>
   execute 'mvn package' in the container
  - Build the 'backend' Docker image
  - ```docker build -t backend .```
  - Run a container from the backend image
  - ```docker run -d backend```
  - Access the http://localhost:8080/api/info with your browser
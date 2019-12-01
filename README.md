# Vagrant

```
vagrant box list # List locally available Vagrant Boxes (VM Images)

vagrant up  # Create and run your VM based on the Vagrantfile in the current folder

vagrant provision # re-provision your VM (e.g. run Ansible again)

vagrant reload # restart your VM

vagrant halt # Shutdown your VM (vagrant up for starting it again)

vagrant destroy # Delete your VM
```

## SSH into your VM

```
vagrant ssh
```

### Trouble shooting your SSH connection

```
vagrant ssh-debug
```

# Docker

## Basic Docker commands
__Search Community Images in Docker Hub__
```
docker search hello-world
```
__Work with Images__
```
docker pull hello-world  # Pull an image from Docker Hub

docker images  # List your locally available images

docker rmi hello-world   # Remove local image
```
__Work with Containers__
```
docker run hello-world  # Create and run a container from an image

docker run --name my-hello-world hello-world  # give your container a name

docker run --name webserver -d nginx  # Detach from container

docker logs webserver # Show container log messages

docker logs -f webserver # Show container log messages  and attach to it

```
__List containers__
```
docker ps  # list running containers

docker ps -a # show all containers (includes stopped containers)
```
__Start / stop / delete Containers__
```
docker ps

CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
98ce9a98b4c6        nginx               "nginx -g 'daemon of…"   6 seconds ago       Up 3 seconds        80/tcp              webserver

docker stop <98c | webserver> # containers can be identified by name or ID

docker stop 98c

docker start webserver

docker rm webserver # removes the container webserver -  needs to be stopped
```

__Run a command in a running Container__

```
docker exec webserver cat /etc/nginx/nginx.conf # display the NGINX configuration file

docker exec -it webserver /bin/bash  # open a shell and redirect stdin 
```

## Exposing Container Ports to the Host

By default, when you create a container, it does not publish any of its ports to the outside world. To make a port available to services outside of Docker, or to Docker containers which are not connected to the container’s network, use the --publish or -p flag.

```
docker run -p 8080:80 --name webserver -d nginx  # expose NGINX port 80 in the container to host port 8080
```

## Volumes

Share data from the host with a container.
```
docker run -p 8080:80 --name webserver -v /tmp/html:/usr/share/nginx/html -d nginx   
```



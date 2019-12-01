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
Search Community Images in Docker Hub
```
docker search hello-world
```
Work with Images
```
docker pull hello-world  # Pull an image from Docker Hub
docker images  # List your locally available images
docker rmi hello-world   # Remove local image
```
Work with Containers
```
docker run hello-world  # Create and run a container from an image
docker run --name my-hello-world hello-world  # give your container a name
docker run --name webserver -d nginx  # Detach from container 
```
List containers
```
docker ps  # show running containers
docker ps -a # show all containers (includes stopped containers)
```
## 


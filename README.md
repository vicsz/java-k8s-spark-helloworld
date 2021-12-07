# Sample Java Webapp with Docker and Kubernetes (K8s) support
 
[![.github/workflows/build.yml](https://github.com/vicsz/java-k8s-spark-helloworld/actions/workflows/build.yml/badge.svg)](https://github.com/vicsz/java-k8s-spark-helloworldactions/workflows/build.yml)

## Normal Steps

Run the app:

```sh
./gradlew app:run
```

Verify app is working: 

```sh
curl localhost:8080
```

## Docker Image Creation Steps

Build the Helloworld Jar File:

```sh
./gradlew app:build
```

Create the Docker Image:

```sh
docker build -t local/helloworld:latest .
```

Confirm Docker Image Created:

```sh
docker image list
```

Run the Docker Image:

```sh
docker run -p 8080:8080 local/helloworld
```

List Running Docker Containers:

```sh
docker ps
```

Verify app is working: 

```sh
curl localhost:8080
```

### Alternate Docker Step - Build and Package using Docker

```sh
docker build -f Dockerfile.buildAndPackage -t local/helloworld:latest .
```

## Kubernetes Steps

### Make Docker Image Available to MiniKube

#### Option #1: Make minikube docker available on terminal and rebuild image

<i>Note: eval command can be added to your bash start script to have docker always default to the minikube version.
```sh
eval $(minikube docker-env)
```

```sh
docker build -t local/helloworld:latest .
```

#### Option #2: Load local Image into MiniKube

```sh
minikube image load local/helloworld:latest
```
### Apply K8s YAML and Start the Pod

Confirm Docker Image is available in MiniKube to Load:
```sh
minikube ssh
-> docker images
```

Apply the Kubernetes YAML file:
```sh
kubectl apply -f k8s/app.yaml
```

View Running Pods:
```sh
kubectl get pods
```

View Services:
```sh
kubectl get services
```

## Kubernetes and Docker MacOs Install Steps

Tools required: 
- Homebrew 
- kubectl
- docker desktop (for Mac)
- minikube
- virtualbox

```sh
brew update && brew install kubectl && brew install --cask docker virtualbox && brew install minikube
```

## Starting Up Kubernetes and Docker Environments

1. Start the Docker Desktop Application (GUI)

2. Start the MiniKube local K8s Cluser (will take a few minutes)
```sh
minikube start 
```

### Verifying Environment is Up / Working

To view the MiniKube Dashboard GUI:
```sh
minikube dashboard
```
To verify kubectl connectivity:
```sh
kubectl api-versions
```

### Other Commands / TroubleShooting

Stop / Delete Local K8S Cluster:
```sh
minikube delete 
```
Start MiniKube with additional debugging:
```sh
minikube start --v=10 
```
View Available Image in MiniKube:
```sh
minikube ssh
docker images
```
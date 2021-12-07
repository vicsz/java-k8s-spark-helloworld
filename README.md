# java-k8s-spark-helloworld
 
[![.github/workflows/build.yml](https://github.com/vicsz/java-k8s-spark-helloworld/actions/workflows/build.yml/badge.svg)](https://github.com/vicsz/java-k8s-spark-helloworldactions/workflows/build.yml)

# Normal Steps

Run the app:

```sh
./gradlew app:run
```

Verify app is working: 

```sh
curl localhost:8080
```

# Docker Steps

Create the Docker Image (build and package)

```sh
docker build -t java-k8s-spark-helloworld:latest .
```

Confirm Docker Image Created: 

```sh
docker image list
```

Run the Docker Image:

```sh
docker run -p 8080:8080 java-k8s-spark-helloworld
```

List Running Docker Containers:

```sh
docker ps
```

Verify app is working: 

```sh
curl localhost:8080
```

# Alternate Docker Step - Build and Package using Docker

```sh
docker build -f Dockerfile.buildAndPackage -t java-k8s-spark-helloworld:latest .
```

# Kubernetes Steps

<b> TODO </b>

# Kubernetes and Docker MacOs Install Steps

Tools required: 
- Homebrew 
- kubectl
- docker desktop (for Mac)
- minikube
- virtualbox

```sh
brew update && brew install kubectl && brew install --cask docker virtualbox && brew install minikube
```

# Starting Up Kubernetes and Docker 

# Starting the Environment

1. Start the Docker Desktop Application (GUI)

2. Start the MiniKube local K8s Cluser (will take a few minutes)
```sh
minikube start 
```

# Verifying Environment is Up / Working

To view the MiniKube Dashboard GUI:
```sh
minikube dashboard
```
To verify kubectl connectivity:
```sh
kubectl api-versions
```

# Other Commands 

Stop / Delete Local K8S Cluster:
```sh
minikube delete 
```
Start MiniKube with additional debugging:
```sh
minikube start --v=10 
```

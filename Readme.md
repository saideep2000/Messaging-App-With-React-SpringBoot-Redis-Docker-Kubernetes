This project is created from 

<!-- my-project/
├── backend/
│   ├── src/main/java/com/example/demo/
│   │   ├── DemoApplication.java
│   │   ├── controller/
│   │   │   └── MessageController.java
│   │   ├── model/
│   │   │   └── Message.java
│   │   └── service/
│   │       └── MessageService.java
│   ├── src/main/resources/application.properties
│   ├── pom.xml
├── frontend/
│   ├── src/
│   │   ├── App.tsx
│   │   ├── index.tsx
│   ├── package.json
│   ├── tsconfig.json
├── docker-compose.yml
├── kubernetes/
│   ├── backend-deployment.yaml
│   ├── backend-service.yaml
│   ├── frontend-deployment.yaml
│   ├── frontend-service.yaml
│   ├── redis-deployment.yaml
│   ├── redis-service.yaml
└── README.md -->


Steps followed :

Spring Boot project using Spring Initializr :

1. Spring Web
2. Spring Data Redis (Access + Driver)
3. Lombok

Backend :

create MVC struture.

Frontend :

npx create-react-app frontend --template typescript

npm install axios


Steps followed :

cd backend

brew install maven

mvn -version

mvn -N io.takari:maven:wrapper

./mvnw clean package

java -jar target/*.jar

mkdir Dockerfile


docker build -t messaging-backend-image .

-------------------------------------------------------

cd ../frontend

mkdir Dockerfile

docker build -t messaging-frontend-image .

-------------------------------------------------------

docker tag messaging-frontend-image:latest saideepsamineni/messaging-frontend-image:latest
docker tag messaging-backend-image:latest saideepsamineni/messaging-backend-image:latest
docker push saideepsamineni/messaging-frontend-image:latest
docker push saideepsamineni/messaging-backend-image:latest


-------------------------------------------------------

minikube start


kubectl apply -f kubernetes/redis-deployment.yaml
kubectl apply -f kubernetes/redis-service.yaml
kubectl apply -f kubernetes/backend-deployment.yaml
kubectl apply -f kubernetes/backend-service.yaml
kubectl apply -f kubernetes/frontend-deployment.yaml
kubectl apply -f kubernetes/frontend-service.yaml

kubectl get pods

kubectl get svc


To kill all docker containers : 

docker images

docker stop $(docker ps -q)

-------------------------------------------------------

minikube ip

The ip address of the minikube keeps changing, we can run a file which can get the ip of the minikube and set that to the env and in the frontend we can fetch the ip from the env.

But without these we'll use ingress which to manage access to Minikube cluster services.

minikube addons enable ingress

create ingress.yaml

Update /etc/hosts

echo "$(minikube ip) myapp.local" | sudo tee -a /etc/hosts

kubectl apply -f ingress.yaml

kubectl get pods -n kube-system | grep ingress

kubectl get ingress

http://myapp.local

-------------------------------------------------------

Debugging:

kubectl get pods -n ingress-nginx

kubectl logs -n ingress-nginx -l app.kubernetes.io/name=ingress-nginx

kubectl describe ingress myapp-ingress

minikube tunnel





minikube delete




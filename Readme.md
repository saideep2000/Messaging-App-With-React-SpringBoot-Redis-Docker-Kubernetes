This project is created from 

my-project/
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
└── README.md


Steps followed :

Spring Boot project using Spring Initializr :

1. Spring Web
2. Spring Data Redis (Access + Driver)
3. Lombok

Backend :

create MVC struture.

Frontend :

npx create-react-app frontend --template typescript


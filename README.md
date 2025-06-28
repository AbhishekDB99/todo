# 🧠 Todo Backend – Spring Boot API

This is the backend service for the Todo App built with **Spring Boot** and connected to a **PostgreSQL** database (hosted on Supabase). It provides RESTful APIs to manage tasks across Backlog, Today, and Completed lists.

## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- PostgreSQL (Supabase)
- Maven
- Deployed using Docker (on Render)

## 📁 Folder Structure

```
src/
 └── main/
     ├── java/com/example/todo/
     │    ├── controller/      # REST Controllers
     │    ├── service/         # Business Logic
     │    ├── model/           # Entity + Enum
     │    ├── config/          # CORS Config
     │    └── TodoApplication.java
     └── resources/
          └── application.yml
```

## ⚙️ API Endpoints

- `GET /api/todos/backlog` – Fetch backlog todos
- `GET /api/todos/today` – Fetch today todos
- `GET /api/todos/completed` – Fetch completed todos
- `POST /api/todos` – Create a new todo (`{ title: string }`)
- `POST /api/todos/{id}/assign` – Move a todo to today
- `POST /api/todos/{id}/complete` – Mark a todo as completed

## 🐳 Deployment (Render + Docker)

1. Build the JAR: `mvn clean package`
2. Use the `Dockerfile` present or edit it according to your needs
3. Deploy to Render with Dockerfile method
4. Set environment variables for DB config if needed

## 🔒 CORS Config

Located in `WebConfig.java` to allow frontend Netlify origin access.
.allowedOrigins(
  "https://todo-react.netlify.app",
  "http://localhost:5173"
)
---



# 📚 Book Review System

A simple full-stack application for managing book reviews. Users can create, retrieve, update, delete, and search book reviews through a REST API with a connected front-end interface.

---

## 🎯 Objectives

* Build a full-stack application with Spring Boot and RESTful principles.
* Use JPA for entity persistence with H2 in-memory database.
* Perform CRUD operations and search filtering.
* Validate incoming data with Jakarta Bean Validation.
* Handle exceptions globally using `@ControllerAdvice`.
* Document the API with Swagger/OpenAPI.
* Implement unit and integration testing using JUnit and MockMvc.
* Provide a basic front-end view using HTML, CSS, and JavaScript.

---

## 📁 Project Structure

```
book-review-system/
├── src/
│   ├── main/
│   │   ├── java/com/example/reviews/
│   │   │   ├── controllers/         # API endpoints
│   │   │   ├── exceptions/          # Custom exceptions and handlers
│   │   │   ├── models/              # Entities and request models
│   │   │   ├── repository/          # JPA repository interfaces
│   │   │   ├── services/            # Business logic
│   │   │   └── BookReviewApplication.java
│   │   └── resources/
│   │       ├── static/              # HTML/JS/CSS frontend
│   │       └── application.yml
├── test/java/com/example/reviews/   # Unit and integration tests
└── pom.xml
```

---

## ⚙️ Functionality

* Create a book review
* View all reviews
* Retrieve a single review by ID
* Update an existing review
* Delete a review
* Search reviews by phrase in title or content

---

## 🧪 Testing

* Controller tests using MockMvc
* Mocked repository behavior using Mockito
* Tests for:

  * Valid and invalid input
  * ID not found
  * Input parsing errors
  * Empty search results

---

## 📚 Technologies Used

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Jakarta Validation
* Swagger/OpenAPI (springdoc-openapi)
* JUnit 5
* Mockito
* MockMvc
* HTML/CSS/JS (for frontend)

---

## 🚀 How to Run

1. **Clone the repository**
   `git clone https://github.com/your-username/book-review-system.git`

2. **Run the application**
   Use your IDE or:
   `./mvnw spring-boot:run`

3. **Open the browser**

   * API Root: `http://localhost:8080/api/reviews`
   * Swagger UI: `http://localhost:8080/swagger-ui.html`
   * Frontend: open `src/main/resources/static/index.html` in your browser

---

# URL Shortener Microservices

A robust and scalable URL shortener built with Java Spring Boot, following a microservices architecture. It uses **Apache Cassandra** for high-volume storage and **Redis** for high-performance caching.

## Architecture

The system is designed with scalability in mind, separating the write path (Shortening) from the read path (Redirect) to handle high-traffic loads efficiently.

![Architecture Diagram](./url_shortener_diagram.png)

## Tech Stack

*   **Java 25** & **Spring Boot 4**
*   **Spring Cloud Gateway**: Central entry point for routing and load balancing.
*   **Netflix Eureka**: Service Registry and Discovery.
*   **Apache Cassandra**: NoSQL for high-volume storage and high-performance read scalability.
*   **Redis**: In-memory data structure store used as a cache to minimize database reads.
*   **Docker & Docker Compose**: Containerized environment for easy deployment.

## Microservices Breakdown

### 1. URL Shortening Service
Responsibility: Generates unique short codes for long URLs.
*   **Database**: Writes persistent data to **Cassandra**.
*   **Logic**: Accepts a long URL, hashes it, and saves the mapping.

### 2. URL Redirect Service
Responsibility: Resolves short codes to original URLs.
*   **Caching Strategy**: **Read-Through**. It first checks **Redis**. If the key exists, it redirects immediately. If not, it fetches from **Cassandra**, populates Redis, and then redirects.

### 3. API Gateway
Responsibility: Routing and API composition.
*   **Discovery**: Automatically discovers routes from Eureka.

## Getting Started

### Prerequisites
*   **Docker** and **Docker Compose** installed.
*   **Java 25**.

### Installation & Running

1.  Clone the repository.
2.  Start the infrastructure and services using Docker Compose:

    ```bash
    docker-compose up --build --scale redirect-service=2
    ```

    This will start:
    *   Cassandra (9042)
    *   Redis (6379)
    *   Eureka Server (8761)
    *   Spring Api Gateway (8080)
    *   Redirect Service (2 instances)
    *   Shortening Service

3.  Verify services are up in Eureka Dashboard: `http://localhost:8761`

## API Usage

All requests should be sent to the **API Gateway** at `http://localhost:8080`.

### 1. Shorten a URL
Create a short link for a long URL.

*   **Endpoint**: `POST /url/shorten`
*   **Body**:
    ```json
    {
      "url": "https://www.google.com/search?q=spring+boot+microservices"
    }
    ```
*   **Response**:
    ```json
    {
      "url": "https://www.google.com/search?q=spring+boot+microservices",
      "shortUrl": "a7B2x"
    }
    ```

### 2. Redirect
Access the original URL using the short code.

*   **Endpoint**: `GET /url/{shortCode}`
*   **Example**: `http://localhost:8080/url/a7B2x`
*   **Behavior**: Returns `302 Found` and redirects to the original "long" URL.


# Microservices Architecture with Java, Quarkus, Kafka, PostgreSQL, MongoDB, Docker, and Kong API Gateway

This repository demonstrates a microservices architecture utilizing **Java**, **Quarkus**, **Apache Kafka**, **PostgreSQL**, **MongoDB**, **Docker**, and **Kong API Gateway**. Each service performs distinct business functions, collaborating to deliver a cohesive system.

## Project Overview

This project consists of three microservices: **Student**, **Professor**, and **Study**, each with its unique setup. The services leverage **Kafka** for event-driven communication, store data using **PostgreSQL** and **MongoDB**, and manage APIs with **Kong API Gateway**.

### Key Components

- **Quarkus Framework**: A high-performance Java framework optimized for microservices.
- **PostgreSQL and MongoDB**: Supports relational and NoSQL data storage.
- **Kafka for Event Streaming**: Facilitates asynchronous message exchange between services.
- **Kong API Gateway**: Provides centralized API management with routing and security.
- **Dockerized Environment**: Deploys all services in isolated containers with minimal configuration.

## Architecture Overview

Each microservice operates independently with specific data and event-handling responsibilities:

1. **Student Service** - Manages student data, using PostgreSQL with a dedicated schema.
2. **Professor Service** - Manages professor information, also using PostgreSQL.
3. **Study Service** - Handles study materials, using MongoDB for NoSQL storage.

All services:
- Operate on separate ports.
- Act as both Kafka producers and consumers.
- Register with the Kong API Gateway for unified access.

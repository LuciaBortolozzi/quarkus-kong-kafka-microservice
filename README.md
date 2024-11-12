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

## Screenshots

![Quarkus](https://github.com/user-attachments/assets/de083e1d-c578-48e9-b8d5-7d0c88d4af36)
![Quarkus resources endpoints example](https://github.com/user-attachments/assets/7de437e4-52ea-4461-a33e-f404a6f56809)

![Kong manager overview](https://github.com/user-attachments/assets/fc9f1d01-6943-4a7b-94c8-f5697b4b4e06)

![Kafka Dashboard](https://github.com/user-attachments/assets/c09f3cd9-e1b0-4ffb-9419-0e37058972d0)
![Kafka topic](https://github.com/user-attachments/assets/ab6f1c36-1462-47a2-a83a-f14f0163d513)


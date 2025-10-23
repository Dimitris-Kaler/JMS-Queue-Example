# JMS Queue Example with Quarkus & ActiveMQ Artemis

This project demonstrates a simple messaging system using **Quarkus**, **SmallRye Reactive Messaging**, and **ActiveMQ Artemis** over **AMQP**.

## 📦 Overview

The application consists of:

- **MsgProducer**: Sends messages to an AMQP queue (`words-out`)
- **MsgConsumer**: Receives messages from the queue (`words-in`)
- **MsgResource**: Exposes a REST endpoint to send messages via HTTP POST

Communication is handled reactively using SmallRye Reactive Messaging.


----

## 🧱 Architecture

```mermaid
[HTTP POST /messages] → MsgResource → MsgProducer → AMQP Queue → MsgConsumer
```
- Messages are sent to the `words` address via `words-out`
- Messages are received from the same address via `words-in`


---

## ⚙️ Technologies Used

- [Quarkus](https://quarkus.io/)
- [SmallRye Reactive Messaging](https://smallrye.io/smallrye-reactive-messaging/)
- [ActiveMQ Artemis](https://activemq.apache.org/components/artemis/)
- Jakarta REST, CDI
- Docker & Docker Compose
---




If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.jar.type=uber-jar
```
## 🚀 How to Run

### 1. Build the Quarkus application
```bash
./gradlew build
```

### 2. Start with Docker Compose

```bash
docker-compose up --build
```
This will start:

- ActiveMQ Artemis broker

- Quarkus JMS client on port 9999


## 📬 API Usage

### Send Message

```bash 
curl -X POST http://localhost:9999/messages \
     -H "Content-Type: text/plain" \
     -d "Hello from Quarkus!"

```


### Expected Output
- The message is sent to the AMQP queue

- The consumer logs the received message:

```Code
📥 Received: Hello from Quarkus!
```
## 🔌 Multithreaded Client-Server Communication in Java

This repository demonstrates a basic **multithreaded client-server architecture** in Java using sockets. The server handles multiple client connections concurrently using a **Thread Pool (`ExecutorService`)** to efficiently manage resources and scale connections.

### 🧠 Features

* Java-based TCP socket communication
* Server uses `ExecutorService` for efficient thread management
* Clients send messages and receive responses from the server
* Demonstrates multithreading and concurrent programming
* Easily scalable to handle multiple clients (100+)

---

### 📁 Project Structure

```
multithreaded/
├── Server.java    // Server-side logic with ThreadPool
└── Client.java    // Client-side logic with Runnable
```

---

### 🚀 How to Run

#### 1. Start the Server

```bash
javac Server.java
java multithreaded.Server
```

#### 2. Start Clients

```bash
javac Client.java
java multithreaded.Client
```

The client will spawn 100 threads to simulate concurrent connections to the server.

---

### 🛠 Tech Stack

* Java 8+ (compatible with latest JDKs)
* `java.net.Socket`, `ServerSocket`
* `ExecutorService` for multithreading
* `PrintWriter`, `BufferedReader` for message I/O

---

### 📚 Learning Goals

* Understand how to implement a basic socket server and client in Java
* Learn how to manage threads efficiently with `ExecutorService`
* Explore real-world scenarios where multithreading improves performance

---



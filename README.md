# COSC 3P91 – Assignment 4

**Authors:** Yuvraj Sehgal and Rohit Pillai  
**Student IDs:** 6921795 and 6959308  
**University:** Brock University, Canada  

## Overview

This document explains how we have incorporated the server/client computing model into our game design for VillageWar.

## How to Run

1. **Open your terminal in the `VillageWar` directory.**
2. **Compile the Java source files** using the following command:
   ```bash
   javac -d ./out/ \
     src/Game/*.java \
     src/GUI/*.java \
     src/Utility/*.java \
     src/VillageElements/*.java \
     src/AbstractFactory/*.java \
     src/ChallengeDecision/*.java \
     src/Controllers/*.java \
     src/Models/*.java \
     src/Views/*.java \
     src/concurrency/*.java \
     src/ConcurrentAbstractFactory/*.java \
     src/connection/*.java \
     src/connection/Server/*.java \
     src/connection/Clients/*.java \
     src/connection/protocols/*.java

   mkdir out\src\resources
copy .\src\resources\levels.properties .\out\src\resources\
cd out
Now to run the server write this command: type port number as argument:
java connection.ServerRunner <port number>
In another terminal write this command to run the first client: type
port number as first argument same as server and "localhost" as second
argument:
cd out
java connection.Client1Runner <port number> <host name>
If you want to two clients on the same Server, another terminal write
this command to run the second client:type port number as
first argument same as server and "localhost" as second
argument:
cd out
java connection.Client2Runner <port number> <host name>


## 1. Random Army Unit and Random Village Testing

The random army generating feature is implemented in the `GameEngine` class, allowing users to generate an army to test their village. Additionally, users can test a village using a random army through the console. By pressing `3`, their village will be attacked by a random army, and the Challenge Result will be shown on the console. This fight occurs concurrently as the server supports multiple clients (as shown in Figure 1).

## 2. Why Have We Used TCP?

TCP (Transmission Control Protocol) is used because it is a connection-oriented service that ensures data is delivered in order. This is essential for our game to keep requests synchronized and prevent duplication. Although UDP (User Datagram Protocol) could have been faster, TCP provides necessary error checking and synchronization, which outweighs the performance benefits of UDP in this case.

## 3. Generating Random Army

In accordance with the assignment requirements, the game is designed to generate a complete army detached from the player’s village. The `Game.GameEngine` package contains a method that randomly generates an army on the server side. To test a village, you can press `18` in the console to have your village attacked by a random compatible army, and the result will be displayed. Similarly, pressing `3` will create a new random village on the server side, allowing users to attack the village and see the outcome on the console.

## 4. Description of Connection

The classes related to the client/server model are located in the `connection` package:

- **Clients Package:** Contains the client class and the protocols that the client and server follow.
- **Server Package:** Includes the client handler class, which uses concurrency to handle multiple clients, and the `MultiClientServer` class, which is the main server class. We use a cached thread pool instead of a fixed number of threads to improve performance and avoid the overhead of creating and destroying threads.
- **Protocols Package:** Contains the protocol-related classes.

**Note:** We are logging updates on both the server and client sides to demonstrate that changes are taking place.

### 4.1 Description of Concurrency

Several aspects of the game utilize concurrency for instance creation:

- **Concurrent Abstract Factory Classes:** These help create new buildings and workers concurrently.
- **Village Controller Generator Class:** Creates instances of village controllers concurrently.

Both the server and client are `Runnable`, meaning they handle multiple tasks concurrently to ensure efficient processing.


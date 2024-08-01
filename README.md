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

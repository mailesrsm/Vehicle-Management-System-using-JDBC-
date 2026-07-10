# Vehicle Management System (JDBC)

## Overview

The Vehicle Management System is a Java console application developed using JDBC (Java Database Connectivity) and MySQL. It performs basic CRUD (Create, Read, Update, Delete) operations on vehicle records stored in a MySQL database.

## Features

* Insert a new vehicle
* Get vehicle details by ID
* Search vehicles by company name
* Update vehicle details
* Delete a vehicle
* Display all vehicles

## Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE (or any Java IDE)

## Database

**Database Name**

```
vehicle_entity
```

**Table Structure**

```sql
CREATE TABLE VEHICLE (
    ID INT PRIMARY KEY,
    YEAR INT,
    MODEL VARCHAR(50),
    NAME VARCHAR(50)
);
```

## Project Structure

```
VehicleManagementSystem/
│
├── src/
│   └── com/
│       └── jdbc/
│           └── vehicle_entity.java
│
└── README.md
```
## SQL CODE ##

```sql
CREATE DATABASE VEHICLE_ENTITY;
USE VEHICLE_ENTITY;
CREATE TABLE VEHICLE(
ID INT,
YEAR INT,
MODEL VARCHAR(50),
NAME VARCHAR(50)
);
SELECT * FROM VEHICLE;
INSERT INTO VEHICLE VALUES
(101,2005,"baleno","maruti suzuki"),
(102,2006,"glanza","toyota"),
(103,2007,"hycross","toyota"),
(104,2008,"Q3","audi"),
(105,2009,"creta","hyundai"),
(106,2000,"qwalis","toyota"),
(107,2015,"verna","hyundai"),
(108,2020,"venue","hyundai"),
(109,2022,"GLA","benz"),
(110,2021,"X3","bmw");
SELECT * FROM VEHICLE;
```

## How to Run

1. Install MySQL.
2. Create the database:

   ```sql
   CREATE DATABASE vehicle_entity;
   ```
3. Create the `VEHICLE` table using the SQL script above.
4. Update the database credentials in the Java program if required.
5. Compile and run the program.

## Menu

```
1. Insert Vehicle
2. Get Vehicle By ID
3. Get Vehicle By Name
4. Update Vehicle
5. Delete Vehicle
6. Show All Vehicles
7. Exit
```

## Sample Output

```
Connection Successful

VEHICLE MANAGEMENT
1. Insert Vehicle
2. Get Vehicle By ID
3. Get Vehicle By Name
4. Update Vehicle
5. Delete Vehicle
6. Show All Vehicles
7. Exit

Enter Choice :
```

## Learning Outcomes

* JDBC Database Connectivity
* MySQL CRUD Operations
* PreparedStatement
* ResultSet
* SQL Queries
* Java Exception Handling
* Console-Based Menu-Driven Programs

## Author

**Maileswaran R S**


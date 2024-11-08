This document contains homework tasks for `JDBC Advanced Techniques (+ Spring JDBC)`.


Task 1 - SpringJDBC-based Social Network
========================================

**Cost**: 25 points

1. Create simple database with tables
    * `Users (id, name, surname, birthdate)`
    * `Friendships (userid1, userid2, timestamp)`
    * `Posts (id, userId, text, timestamp)`
    * `Likes (postid, userid, timestamp)`
2. Populate tables with data which are make sense (`> 1 000 users`, `> 70 000 friendships`, `> 300 000 likes in 2025`) **\***
3. Program should print out all names (only distinct) of users who has more than `100 friends` and `100 likes` in `March 2025`. Implement all actions (table creation, insert data and reading) with SpringJDBC.

**\*** You could prepare dictionaries (maps) in memory (with usernames for example) or data in files to generate data for the populating process.



Task 2 - Highload Writing Console Tool
======================================

**Cost**: 25 points.

Create a Highload Writing Console Tool that populates the database (URL/Name are configuration settings).

Required functionality:

1. It creates **N** random tables with random unique name (or names from dictionary) and **K** random columns with type taken from **Z** random types.
2. It creates **m** random rows for the **i**-th table, where **m** is an **i**-th element of **M**. **M** is an **N**-length array predefined by a user of this tool and each element in the array by itself is array with follow structure [K, Z, m].
3. It supports the table creation/populating via **L** concurrent connections (from different threads or from a few instances of classes running simultaneously).
4. All settings are located in a configuration file; the path to this file is a parameter of `main()` function.

Discuss with mentor how to improve performance of suggested solution.



Task 3 (Optional) - Database Copy Console Tool
===================================

Create a Database Copy Console Tool that copies the database (URL/Name are command line parameters) step-by-step (table by table).

Required functionality:

1. Copying of tables in lexicographic order.
2. Rows in direct or reverse order (command line parameter).
3. It works for `10 GB` database in minimal time (should tune performance using Java and database performance features).
4. The solution is delivered with a test database (populated with a huge volume of data).

**\*** `10 GB` sample database could be generated via Highload Writing Tool.



Task 4 (Optional)- Play the Game with DBUnit
==================================

Add five DBUnit tests to appropriate project (pet project) or another. Prepare test datasets if it is required.



Task 5 - Stored Procedure
=========================

**Cost**: 25 points.

1. Take the existing (or write from zero) JDBC solution with a few CRUD operations and more complex SQL (for simple report generation) and migrate it to stored procedures. **\***
2. Write SQL script to create those stored procedures with Java style parameters and specific external names. **\*\***
3. Write a test which drops all stored procedures and creates a few of them via Java code.
4. Also, provide the script to print out all stored procedure in your database and dropping them for test purposes, for example.
5. Check that the application works properly, all test are green and so on.
6. Compare the performance of two solutions; explain to your mentor the benefits or disadvantages of storage procedure usage for the taken application.

**\*** 3-5 tables with CRUD operations and two complex `SELECT`s can be enough.
**\*\*** Use `MySQL` or `PostgreSQL` or `Oracle`.



Task 6 (Optional) - Pre-defined Stored Procedure
=====================================

If your database **\*** has pre-defined storage procedure, use a few of them to print out
interesting information or maintain something in the database.

**\*** Use `MySQL` or `PostgreSQL` or `Oracle`.



Task 7 - File Sharing
=====================

**Cost**: 25 points.

Implement the next use cases of File Share application:

1. Save file to the database.
2. Retrieve file from the database.
3. Optional: file expiration.

Large files should be supported (size up to `200 MB`).

Acceptance criteria:

1. File Share database schema is developed:
    * DB schema diagram is provided (5 points);
    * stored procedures for saving and retrieving files from DB are created (5 points).
2. DAO on JDBC is implemented:
    * DAO methods that are not used in proposed use cases can throw `UnsupportedOperationException` (2 points);
    * `CallableStatement` is used to call DB stored procedures (3 points);
    * large binary files are retrievable from DB (5 points).

Think about **pros** and **cons** of stored procedures usage comparing to SQL statement stored in Java code.
Describe what difficulties you’ve faced when working with large binary files.
Make demo via console interface or via special main method.



Task 8 (Optional) - JabaORM
================

Write your own annotation-based or XML-based JabaORM that parses specific class and
generates SQL-queries for CRUD (or SCRUD) operations.

Your mini-ORM should have one entry point, which supports CRUD operations for parsed
class passed as a parameter in

* `.save`
* `.load`
* `.update`
* `.delete`

methods.

Implement all actions via `RowSet` if it is possible.

# JPA Demo Project using Sakila Database

## Sakila Database

The examples use PostgreSQL database.
If you are using Windows there is a PosgreSQL Portable: https://gareth.flowers/postgresql-portable/ and if you are on Mac you can use Postgres.app http://postgresapp.com/ if you don't want to install PostgreSQL on your computer.

The scripts to create the demo Sakila database can be found in the jOOQ repository: https://github.com/jOOQ/jOOQ/tree/master/jOOQ-examples/Sakila

Create a database, a user and a password all with the name sakila and create the schema and insert the data with the scripts:
- postgres-sakila-schema.sql
- postgres-sakila-insert-data.sql

You have to replace **OWNER TO postgres** with **OWNER TO sakila** in the schema script.

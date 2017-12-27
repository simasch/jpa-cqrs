# JPA Demo Project using Sakila Database

## Sakila Database

### Database installation
The examples use PostgreSQL database.

If you don't want to install PosgreSQL you can use one of these:

- Windows: PosgreSQL Portable: https://gareth.flowers/postgresql-portable/ and
- Mac: Postgres.app http://postgresapp.com/

### Schema creation

The scripts to create the demo Sakila database can be found in the jOOQ repository: https://github.com/jOOQ/jOOQ/tree/master/jOOQ-examples/Sakila

Create a database, a user and a password all with the name sakila and create the schema and insert the data with the scripts:
- postgres-sakila-schema.sql
- postgres-sakila-insert-data.sql

You have to replace **OWNER TO postgres** with **OWNER TO sakila** in the schema script before executing.

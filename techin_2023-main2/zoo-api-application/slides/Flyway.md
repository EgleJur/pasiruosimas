# Flyway
### Database migration tool

other popular tool: **Liquibase**


### Configuration
- Maven plugin
- `/db/migration scripts`
- rollback strategy - DB rollback. _Flyway Undo is a commercial feature of Flyway and isn't available in the Community Edition_
- doc: https://flywaydb.org/documentation/usage/maven/migrate
- usage example:  https://www.baeldung.com/database-migrations-with-flyway
- Github example: https://github.com/eugenp/tutorials/tree/master/persistence-modules/flyway

### Commands
- `migrate` Migrates the database
- `clean` Drops all objects in the configured schemas
- `info` Prints the details and status information about all the migrations
- `validate` Validates the applied migrations against the ones available on the classpath
- `undo` Flyway Teams	Undoes the most recently applied versioned migrations
- `baseline` Baselines an existing database, excluding all migrations up to and including baselineVersion
- `repair` Repairs the schema history table

### Additional info
- for better test management - extend with: `FlywayTestExecutionListener`
ex.: https://github.com/flyway/flyway-test-extensions/blob/master/flyway-test-extensions/flyway-test-samples/flyway-test-spring-samples/flyway-test-sample-spring5/src/test/java/org/flywaydb/test/sample/spring5/FlywayTestWithSqlScriptsTestExecutionListenerTest.java
    https://github.com/flyway/flyway-test-extensions/blob/master/flyway-test-extensions/flyway-test-samples/flyway-test-spring-samples/flyway-test-sample-spring5/src/test/java/org/flywaydb/test/sample/spring5/SpringBeforeTest.java

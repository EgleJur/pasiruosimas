# ZOO api

## API documentation
- Swagger: `http://localhost:8080/swagger-ui/`
- GET animals: 'http://localhost:8080/api/v1/animals'

## Next in our Implementation Roadmap:
`(we'll do it in our class, this is not the Homework)`
- [x] Error handler
- [x] Validation. And check
- [x] ORM (Spring Data, Jpa, Hibernate)
- [ ] DB migrations
- [ ] Unit Tests, Integration tests


### Maven useful commands
- mvn clean package -DskipTests
- mvn clean install -U
- mvn dependency:tree
- mvn spring-boot:run
- mvn spring-boot:run --debug

### GIT commands
- stash push -m "message"
- git stash list
- git stash apply <stash_no>
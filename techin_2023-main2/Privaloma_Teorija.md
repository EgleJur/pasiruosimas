# techin_2023
Egzaminui reikalinga teorija

### Bazinis sąrašas
- MVC ir Application Layers. Iš Backend: Controller, Service, DAO.
- Logger. Logging levels. Configuration

### REST API
- Request/Response model
- HTTP protokolas. URL. Paketas (header, body). HTTP metodai. HTTP status codes.
- Content Negotiation (paviršutinis žinojimas). Header'is `Accept`
- Response Mapping (Object mappers, jackson). Request ir Response. Šiek tiek žinoti apie formatavimą (Date, non_null inclusion)
- Data formats: JSON, YAML, XML
- DTOs ir mappinim'as

### Spring Core
- Spring IoC. (Dependency injection)
- Spring Beans. (Bean Lifecycle, Bean Scopes)

### Spring daugiau
- Rutininiai: `@Scheduled`
- API call via: `RestTemplate`


### Server-side validation
- `@Min @Max @Size` ir tt anotacijos
- Exception mapping/handling: `@ExceptionHandler`, `@ControllerAdvice`
- HTTP status: 400 (Bad Request)


### DB, ORM, Transactions
- žinoti: Spring Data -> JPA -> Hibernate
- žinoti apie Hibernate galimybes sukurti, atnaujinti DB struktūrą
- žinoti apie Flyway DB migravimo principą ir pagrindinius metodus
- Entity Lifecycle ir iškvietimai pvz `@PrePersist`, `@PreUpdate`
- JPA užklausų kalba. Žinoti apie JPQL
- Spring Data užklausų kalba. DAO bei CRUD operacijos
- anotacija @Modifying
- Transactions, JTA Transaction manager (žinoti esminius dalykus, tačiau nereikalingas labai gilus išmanymas, kadangi kurse nenagrinėjome daug pavyzdžių)
- Relationships: `@OneToMany`
- Relationships: `Lazy` asociacija
- Dinaminiai queriai: `findByExample()`
- JPA Paging: `PagingAndSortingRepository`
- mokėti susikonfigūruoti bent jau in memory H2 (DB)


### Konfigūravimas. Žinoti esminius dalykus. Pvz.:
- Configuration Properties 
- Property injection `@Value`
- `application.properties` arba `application.yml`

### Unit/Integration testing
- `@SpringBootTest`
- žinoti kuo skiriasi Unit / Integration / E2E testai
- šiuos tris būdus peržiūrėsim dar kart per konsultaciją



### Naudingos nuorodos
- Spring Reference doc: https://docs.spring.io/spring-framework/docs/current/reference/html/
- Spring-Web doc: https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/web.html#spring-web
- Spring projects in GIT: https://github.com/spring-projects
- JPA 2.2 doc: https://download.oracle.com/otn-pub/jcp/persistence-2_2-mrel-spec/JavaPersistence.pdf
- Spring Data naming reference https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
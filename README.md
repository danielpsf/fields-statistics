## Field statistics


This is a simple microservice to collect and retrieve field statistics using Spring Boot and Maria DB running on Docker.



### Development environment tools

- [SDK Man](https://sdkman.io/) 
- [IntelliJ IDEA CE](https://www.jetbrains.com/idea/download)
- [Docker](https://docs.docker.com/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) - _Just to visualize the data_


### Start development

- Install SDK Man
    - `curl -s "https://get.sdkman.io" | bash`
    - `source "$HOME/.sdkman/bin/sdkman-init.sh"`
- Execute `sdk install java 10.0.2-zulu`
- Execute `sdk install gradle 5.4.1`
- Install IntelliJ IDEA CE
- Install Docker and Docker Compose
- Checkout this project
- [Import this project using IntelliJ](https://www.jetbrains.com/help/idea/gradle.html#gradle_import_project_start)
- Have a great day :grimacing:
    - [YouTube](https://www.youtube.com/watch?v=-crsuEOlUO0&list=PLuIL0d4Qk6YOWHEmesQC1FNYM4bJ5jPWJ)
    - [Spotify](https://open.spotify.com/playlist/37i9dQZF1DX7KNKjOK0o75)

### Running locally

1. Execute `chmod +x run-local.sh`
2. Execute `./run-local.sh`
    - Execute tests
    - Build the Java project
    - Execute `docker-compose up`

#### Try some requests

- Add some entries

```
curl -X POST http://localhost:8080/field-statistics -d '{
    "vegetation": 0.9,
    "occurrenceAt": "2019-04-23T19:40Z"
}'
```

- Retrieve the statistics

_Assuming you have Python installed, if you don't just get rid of everything from the | until the end_

```
$ curl -X GET http://localhost:8080/field-statistics | python -m json.tool
   % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                  Dload  Upload   Total   Spent    Left  Speed
 100    70    0    70    0     0   5276      0 --:--:-- --:--:-- --:--:--  5384
 {
     "vegetationResponse": {
         "min": 0.2,
         "max": 0.2,
         "avg": 0.20000000298023224
     }
 }
```

### Interesting readings and decision points

- Why did I choose Java 10 and what about that interesting parameter `-XX:+UseContainerSupport`
    - https://www.baeldung.com/java-10-overview
    - https://royvanrijn.com/blog/2018/05/java-and-docker-memory-limits
    - https://developers.redhat.com/blog/2017/03/14/java-inside-docker/
    - https://blog.csanchez.org/2017/05/31/running-a-jvm-in-a-container-without-getting-killed/
    - https://blog.csanchez.org/2018/06/21/running-a-jvm-in-a-container-without-getting-killed-ii/
    - https://medium.com/adorsys/jvm-memory-settings-in-a-container-environment-64b0840e1d9e

- Why did I choose Gradle over Maven?

    _TL;DR: I prefer to. I don't dislike Maven, I just have more familiarity with Gradle._
    
    - https://www.baeldung.com/ant-maven-gradle (just history)
    - https://stackshare.io/stackups/gradle-vs-maven (community hype alert! :smile:)
    - https://gradle.org/maven-vs-gradle (marketing alert! :smile:)

- Why did I choose to throw unchecked exceptions?

    _TL;DR: I prefer to. I don't hold anything against the other way around, just find RuntimeExceptions to improve
    readability of my controller methods and once they cannot recover from those, well what's the point on catching it :winki:._

    - https://www.baeldung.com/java-exceptions
    - https://stackabuse.com/exception-handling-in-java-a-complete-guide-with-best-and-worst-practices/
    - https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html
    - https://stackoverflow.com/a/23179413/1855042

- Why did I choose to use Spock over JUnit?
    - https://dzone.com/articles/spock-vs-junit-which-one-should-you-choose
    - http://www.blog.j-labs.pl/2017/02/Spock-vs-Junit-with-Mockito
    - https://bmuschko.com/blog/junit5-vs-spock-showdown/
    - https://www.youtube.com/watch?v=oEamW8_FtAg

- Why did I choose to use DTO instead of passing entities up to the controller?

    _TL;DR: Using entities in any other layer other than persistence is not a good practice and could lead to several
    coupling issues while the project grows. So, for this example it may seems very unreasonable to use DTOs and make
    conversion from Entity to DTO and vice versa, but that may save your live in the future when the project grow._ :grimacing:

    - https://softwareengineering.stackexchange.com/questions/373284/what-is-the-use-of-dto-instead-of-entity
    - https://stackoverflow.com/questions/44872427/should-i-use-jpa-entity-in-rest-request-and-or-response


### TODO

- [X] Implement statistics collect endpoint
    - [X] Create the endpoint
    - [X] Save the entry into database
    - [ ] Implement bean validation (check with the PO what are the possible entries that I could expect in here and extrapolate)
- [ ] Implement statistics retrieve endpoint
    - [X] Create the endpoint
    - [X] Retrieve statistics from database
    - [ ] Format the AVG result to 2 decimals only
    - [ ] Check with the PO what should be returned instead of `null` when no data has not been inserted yet
    - [ ] Try to optimize JPA Query to use interface projection
- [ ] Make a bean out of ObjectMapper to optimize memory consumption
    - [ ] Configure ObjectMapper with good practice default values
- [ ] Implement default exception handling
- [ ] Make the occurrenceAt parameter customizable
- [ ] Add unit testing (Not feeling like TDD today. :sweat_smile:)
- [ ] Add Lombok
- [ ] Add Travis CI pipeline to build and test
- [ ] Implement E2E tests using Spring Cloud Contract
- [ ] Implement performance tests using artillery.io
- [ ] Implement logging using aspect
- [ ] Upgrade to Java 11
- [ ] Optimize docker-compose to limit memory and cpu


### Improvements to discuss with PO
- Split report from data collection to make it RESTfull

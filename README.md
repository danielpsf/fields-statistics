## Field statistics

[![Build Status](https://travis-ci.org/danielpsf/fields-statistics.svg?branch=master)](https://travis-ci.org/danielpsf/fields-statistics)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/30207d739ffd4aa9a05aa1b86ba45d97)](https://app.codacy.com/app/danielpsf/fields-statistics?utm_source=github.com&utm_medium=referral&utm_content=danielpsf/fields-statistics&utm_campaign=Badge_Grade_Dashboard)
[![codecov](https://codecov.io/gh/danielpsf/fields-statistics/branch/master/graph/badge.svg)](https://codecov.io/gh/danielpsf/fields-statistics)

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
- Execute `sdk install java 11.0.3-zulu`
- Execute `sdk install gradle 5.4.1`
- Install IntelliJ IDEA CE
    - [Install Lombok plugin](https://projectlombok.org/setup/intellij)
    - Configure Lombok plugin
        - https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000224490/comments/115000241264
        - https://stackoverflow.com/a/52392862/1855042
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
    "vegetation": 0.98,
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
         "min": 0.98,
         "max": 0.99,
         "avg": 0.985
     }
 }
```

### Interesting readings and decision points

- Why did I choose Java 11 and what about that interesting parameter `-XX:+UseContainerSupport`
    - https://medium.com/criciumadev/its-time-migrating-to-java-11-5eb3868354f9 (_I'm on the second step, so no modules just yet_)
    - https://www.baeldung.com/java-10-overview (_Good things have been added in the 10th version_)
    - https://blog.docker.com/2018/04/improved-docker-container-integration-with-java-10/
    - https://royvanrijn.com/blog/2018/05/java-and-docker-memory-limits
    - https://developers.redhat.com/blog/2017/03/14/java-inside-docker/
    - https://blog.csanchez.org/2017/05/31/running-a-jvm-in-a-container-without-getting-killed/
    - https://blog.csanchez.org/2018/06/21/running-a-jvm-in-a-container-without-getting-killed-ii/
    - https://medium.com/adorsys/jvm-memory-settings-in-a-container-environment-64b0840e1d9e

- Why did I choose Gradle over Maven?

    > TL;DR: I prefer to. I don't dislike Maven, I just have more familiarity with Gradle._
    
    - https://www.baeldung.com/ant-maven-gradle (just history)
    - https://stackshare.io/stackups/gradle-vs-maven (community hype alert! :smile:)
    - https://gradle.org/maven-vs-gradle (marketing alert! :smile:)

- Why did I choose to throw unchecked exceptions?

    > TL;DR: I prefer to. I don't hold anything against the other way around, just find RuntimeExceptions to improve
    > readability of my controller methods and once they cannot recover from those, well what's the point on catching it :wink:

    - https://www.baeldung.com/java-exceptions
    - https://stackabuse.com/exception-handling-in-java-a-complete-guide-with-best-and-worst-practices/
    - https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html
    - https://stackoverflow.com/a/23179413/1855042

- Why did I choose to use Spock over JUnit?
    > TL;DR: I'm a trully believer in the living documentation of the code, meaning that the tests are the first thing
    > someone should read to understand what your code does, and Spock brings that capability to your tests. It was based
    > on RSpec and it carries the most advance testing features from modern world into both Java, Groovy or even Kotlin.
    > On the current state of JUnit, Mockito and Hamcrest one might question the legitimacy of using Spock, so to be clear
    > I'm a huge fan of those tecnologies and I do not opose myself to them, as you can see on my other repositories ([here](https://github.com/danielpsf/java-design-patterns/blob/master/builder/src/test/java/com/danielpsf/labs/BuilderSpec.java), [here](https://github.com/danielpsf/java-design-patterns/blob/master/command/src/test/java/com/danielpsf/lab/FleetSpec.java), [here](https://github.com/danielpsf/java-design-patterns/blob/master/command/src/test/java/com/danielpsf/lab/AdmiralSpec.java), [here](https://github.com/danielpsf/java-design-patterns/blob/master/composite/src/test/java/com/danielpsf/labs/CompositeSpec.java) and so on), my point is that
    > Spock brings more readability as well as technological capability to tests as you try more modern approaches on the tests such as data driven tests or complex social interaction for unit testing.

    - https://dzone.com/articles/spock-vs-junit-which-one-should-you-choose
    - http://www.blog.j-labs.pl/2017/02/Spock-vs-Junit-with-Mockito
    - https://bmuschko.com/blog/junit5-vs-spock-showdown/
    - https://www.youtube.com/watch?v=oEamW8_FtAg
    - https://www.slideshare.net/hlship/spock-a-highly-logical-way-to-test (learn spock in 5min)
    - http://spockframework.org/spock/docs/1.3/all_in_one.html
    
    _This link guides you to my personal brain dump of links I've already read and changed the way I think about a lot of
    things. A personal bookmark one might say. But you'll find in there a lot of links related to Software Testing that
    defined the way I see this amazing field of computer science._ :wink:
    - https://1drv.ms/o/s!Ap3C0ryKbvyZhQENhKNWZk7PHxng
    
    

- Integration testing
    - https://www.slideshare.net/restlet/take-a-groovy-rest-55361056
    - https://www.blazemeter.com/blog/testing-your-api-assertions-with-the-spock-framework/
    - https://www.baeldung.com/spring-testing-separate-data-source
    - https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-integration-testing/

- Why did I choose to use DTO instead of passing entities up to the controller?

    > TL;DR: Using entities in any other layer other than persistence is not a good practice and could lead to several
    > coupling issues while the project grows. So, for this example it may seems very unreasonable to use DTOs and make
    > conversion from Entity to DTO and vice versa, but that may save your live in the future when the project grow. :grimacing:

    - https://softwareengineering.stackexchange.com/questions/373284/what-is-the-use-of-dto-instead-of-entity
    - https://stackoverflow.com/questions/44872427/should-i-use-jpa-entity-in-rest-request-and-or-response


### TODO

- [X] Implement statistics collect endpoint
    - [X] Create the endpoint
    - [X] Save the entry into database
    - [ ] Implement bean validation (check with the PO what are the possible entries that I could expect in here and extrapolate)
- [X] Implement statistics retrieve endpoint
    - [X] Create the endpoint
    - [X] Retrieve statistics from database
- [ ] Implement default exception handling
- [ ] Implement logging
- [X] Add unit testing (Not feeling like TDD today. :sweat_smile:)
- [X] Add Lombok
- [X] Upgrade to Java 11


#### Open questions

- [ ] Check with the PO how big does the decimal report must be
- [ ] Check with the PO what should be returned when no data has been saved if `null` isn't an acceptable return value


#### Extra mile:

- [ ] Make the occurrenceAt parameter customizable preserving the default to 30 days
- [X] Add Travis CI pipeline to build and test
- [X] Implement integration tests
    - [ ] Try to implement real integration tests using real database bu spinning up a testing container using https://www.baeldung.com/docker-test-containers
- [ ] Implement performance tests using artillery.io
- [ ] Add [Spring FOX](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api) support
- [ ] Optimize docker-compose to limit memory and cpu
- [ ] Try to optimize JPA Query to use interface projection instead of class projection


### Improvements to discuss with PO
- Split report from data collection to make it RESTfull

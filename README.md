# initial-service
Prime number discovery service

To start the service run:
gradlew bootRun


To start the service specifing a different implementation class use
gradlew bootJar
java -jar "-Dspring.profiles.active=dummy" .\build\libs\prime-service-1.0.0.jar


The service has a cap on the max reachable value that will be evaluated. You can change that value from application.properties ("prime.maxallowed") or lunching the jar as:
java -jar "-Dprime.maxallowed=500" .\build\libs\prime-service-1.0.0.jar

The service is hosted on AWS at address:
debia-primeservice.eu-west-1.elasticbeanstalk.com/{number}
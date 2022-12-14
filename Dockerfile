FROM maven:3.8.4-jdk-11-slim as builder
WORKDIR /src
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn package
RUN mvn sonar:sonar \
  -Dsonar.projectName=rmt-new-api-gateway-service-dev \
  -Dsonar.projectKey=rmt-new-api-gateway-service-dev \
  -Dsonar.host.url=https://sonarqube8.andersenlab.com \
  -Dsonar.login=ce98d4abe4b77d9cbe924f524857f4c30668118e \
  -Dsonar.java.binaries=/src/target/classes/**/* \
  -Dsonar.java.test.binaries=/src/target/test-classes/**/* \
  -Dsonar.java.test.exclude=test \
  -Dsonar.coverage.exclusions=**/Jwt*.java,**/Dto*.java,src/main/java/com/andersenlab/rmtbanking/api-gatewayservice/aspect/*,src/main/java/com/andersenlab/rmtbanking/api-gatewayservice/controller/*,src/main/java/com/andersenlab/rmtbanking/api-gatewayservice/entity/* \
  -Dsonar.exclusions=/src/main/java/com/andersenlab/rmtbanking/userservice/configuration \
  -Dsonar.jacoco.reportPath=/src/target/jacoco.exec

FROM alpine:3.15.3
RUN apk --no-cache add openjdk11-jre
COPY --from=builder /src/target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

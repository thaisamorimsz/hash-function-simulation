# Read Me First
The following was discovered as part of building this project:

* The following dependencies are not known to work with Spring Native: 'Cloud Bootstrap, Spring Boot DevTools'. As a result, your application may not work as expected.
* The original package name 'com.hashfunction.hash-function-simulation' is invalid and this project uses 'com.hashfunction.hashfunctionsimulation' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/#build-image)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [Cloud Bootstrap](https://spring.io/projects/spring-cloud-commons)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#using-boot-devtools)

### Additional Links
These additional references should also help you:

* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.9.0/reference/htmlsingle/#spring-aot-maven)

## Spring Native

This project has been configured to let you generate a lightweight container running a native executable.
Docker should be installed and configured on your machine prior to creating the image, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.9.0/reference/htmlsingle/#getting-started-buildpacks).

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image
```

Then, you can run the app like any other container:

```
$ docker run --rm hash-function-simulation:0.0.1-SNAPSHOT
```

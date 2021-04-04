# Aerospike Spring Boot Example
This example is old, incredibly old if you look at the dates. It has not kept up with the developments in [Spring Data Aerospike](https://github.com/aerospike-community/spring-data-aerospike) and the auto-configuration project [aerospike-community/spring-boot-data-aerospike](https://github.com/aerospike-community/spring-boot-data-aerospike).

No worries, here is a [modern example of Spring Boot using Aerospike](https://github.com/aerospike-examples/simple-springboot-aerospike-demo) and the associated February 2021 blog post [Simple Web Application Using Java, Spring Boot, Aerospike and Docker](https://medium.com/aerospike-developer-blog/simple-web-application-using-java-spring-boot-aerospike-database-and-docker-ad13795e0089?source=friends_link&sk=43d747f5f55e527248125eeb18748d92).


## This Example
Aerospike example application built using Spring Boot and Spring Data for Aerospike. It is associated with the January 2016 blog post [Spring Data for Aerospike](https://www.aerospike.com/blog/spring-data-for-aerospike/).

This is the application built from the [Spring Boot Tutorial](https://github.com/aerospike-examples/spring-boot-example/wiki/Setup) on this repo's wiki.

The example expects an Aerospike DB to be running at localhost:3000. To configure this edit the [configuration class](https://github.com/aerospike-examples/spring-boot-example/blob/master/src/main/java/com/aerospike/spring/boot/example/configuration/RepositoryConfiguration.java#L23).

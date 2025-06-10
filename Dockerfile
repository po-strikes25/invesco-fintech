#starter
FROM openjdk:17

#expose the port outside of the container
EXPOSE 8686

#add jar of spring boot docker
ADD target/invesco-fintech-aws-exe.jar invesco-fintech-aws-exe.jar

#command to run the jar
ENTRYPOINT ["java", "-jar", "/invesco-fintech-aws-exe.jar"]
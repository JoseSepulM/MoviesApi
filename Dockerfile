FROM openjdk:21-ea-24-oracle

WORKDIR /app

COPY target/bdget-0.0.1-SNAPSHOT.jar app.jar

# COPY WALLET

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
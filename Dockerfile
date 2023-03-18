# Usa una imagen de Java 11 como base
FROM adoptopenjdk:11-jre-hotspot

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR de la aplicación en el contenedor
COPY target/ms-alfa-arpis-arquetipo-0.0.1.jar app.jar

# Expone el puerto 8080 en el contenedor
EXPOSE 8080

# Configura el entorno de ejecución para la aplicación
ENV SPRING_PROFILES_ACTIVE=production \
    JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=80"

# Ejecuta la aplicación cuando se inicia el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
# ms-alfa-arpis-arquetipo
Arquetipo Oficial de Creación de Microservicios con Spring Boot.

Requisitos
Java 17
Maven

Dependencias:
Spring Boot Starter Validation
Spring Boot Starter Web
Spring Boot DevTools
PostgreSQL JDBC Driver
Project Lombok
Spring Boot Starter Test
SpringDoc OpenAPI WebMVC UI
JUnit 5 (JUnit Jupiter API)
Mockito
AWS SDK for Java 2.x (CloudWatch)
Jakarta XML Binding API
Google Gson

Configuración
Para compilar y ejecutar el proyecto, siga los siguientes pasos:

Clone el repositorio:

git clone https://github.com/your-repository-url/ms-alfa-arpis-arquetipo.git

Cambie al directorio del proyecto:

cd ms-alfa-arpis-arquetipo

Compile el proyecto utilizando Maven:

mvn clean install

Ejecute el proyecto con Spring Boot:

mvn spring-boot:run

El servidor se iniciará en http://localhost:8080.

Documentación de la API
La documentación de la API se genera automáticamente utilizando SpringDoc OpenAPI. Puede acceder a la interfaz de usuario de Swagger en http://localhost:8080/swagger-ui.html después de ejecutar el proyecto.

Pruebas
Para ejecutar las pruebas del proyecto, utilice el siguiente comando:

mvn test

Las pruebas utilizan JUnit 5 y Mockito para proporcionar una amplia cobertura de las funcionalidades del proyecto.

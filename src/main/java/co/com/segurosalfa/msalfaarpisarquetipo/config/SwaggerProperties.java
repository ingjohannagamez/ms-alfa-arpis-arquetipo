package co.com.segurosalfa.msalfaarpisarquetipo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * NO BORRAR
 * <p>
 * Clase empleada para mapear las propiedades registradas en el application.properties
 * referentes a la documentación autogenerada.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor()
@Configuration
@ConfigurationProperties(prefix = "swagger.properties")
public class SwaggerProperties {
    
    /**
     * Nombre del microservicio o del proyecto
     */
    private String projectName;

    /**
     * Una corta descripción de las funcionalidades del proyecto
     */
    private String projectShortDescription;

    /**
     * Tu nombre, o el nombre del desarrollador
     */
    private String developerName;

    /**
     * Correo electrónico del desarrollador... preferiblemente el corporativo
     */
    private String developerMail;

    /**
     * URL de la empresa para la cual se desarrolla el microservicio
     */
    private String organizationUrl;

    /**
     * version del microservicio
     */
    private String version;
    
}

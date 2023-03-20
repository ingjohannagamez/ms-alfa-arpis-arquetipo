package co.com.segurosalfa.msalfaarpisarquetipo.model.dto;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessType;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderInType", propOrder = {
    "pais",
    "lenguaje",
    "origen",
    "operacion",
    "idEjecucion",
    "FechaPeticion"
})
@Data
@XmlRootElement(name ="HeaderIn")
public class HeaderInTypeDTO {
    
    @XmlElement(required = true)
    protected String pais;
    @XmlElement(required = true)
    protected String lenguaje;
    @XmlElement(required = true)
    protected String origen;
    @XmlElement(required = true)
    protected String operacion;
    @XmlElement(required = true)
    protected String idEjecucion;
    @XmlElement(required = true)
    protected String FechaPeticion;

}

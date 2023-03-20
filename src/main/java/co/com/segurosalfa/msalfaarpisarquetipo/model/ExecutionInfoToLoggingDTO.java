package co.com.segurosalfa.msalfaarpisarquetipo.model;

import lombok.Data;

@Data
public class ExecutionInfoToLoggingDTO {
    
    protected String locacion;
    protected String idEjecucion;
    protected String origen;
    protected String codigoErrorRetornado;
    protected String descripcionErrorRetornado;

    public ExecutionInfoToLoggingDTO() {
        super();
    }

    public ExecutionInfoToLoggingDTO(String locacion, String idEjecucion) {
        super();
        this.locacion = locacion;
        this.idEjecucion = idEjecucion;
    }

}

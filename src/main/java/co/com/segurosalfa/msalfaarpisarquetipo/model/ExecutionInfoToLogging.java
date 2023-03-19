package co.com.segurosalfa.msalfaarpisarquetipo.model;

import lombok.Data;

@Data
public class ExecutionInfoToLogging {
    
    protected String locacion;
    protected String idEjecucion;
    protected String origen;
    protected String codigoErrorRetornado;
    protected String descripcionErrorRetornado;

    public ExecutionInfoToLogging() {
        super();
    }

    public ExecutionInfoToLogging(String locacion, String idEjecucion) {
        super();
        this.locacion = locacion;
        this.idEjecucion = idEjecucion;
    }

}

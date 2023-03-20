package co.com.segurosalfa.msalfaarpisarquetipo.utils;

import java.util.Optional;

import co.com.segurosalfa.msalfaarpisarquetipo.model.ErrorDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.ExecutionInfoRuntimeDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.ExecutionInfoToLoggingDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.HeaderInTypeDTO;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;

public class LogService {
    
    public String createExecutionLog(HeaderInTypeDTO headerIn, String errorCode, String errorDescription, ExecutionInfoToLoggingDTO logExecInfo, String location) {
        Optional.ofNullable(errorCode)
                .ifPresent(code -> {
                    logExecInfo.setCodigoErrorRetornado(code);
                    logExecInfo.setDescripcionErrorRetornado(errorDescription);
                });
    
        logExec(headerIn, logExecInfo, location);
    
        return logExecInfo.toString();
    }
    
    public void logExec(HeaderInTypeDTO headerIn, ExecutionInfoToLoggingDTO logExecInfo, String location) {
        logExecInfo.setLocacion(location);
        logExecInfo.setOrigen(headerIn.getOrigen());
        logExecInfo.setIdEjecucion(headerIn.getIdEjecucion());
    }

    public String logToCloudWatch(HeaderInTypeDTO headerIn, ErrorDTO error, ExecutionInfoRuntimeDTO execRuntimeInfo, CloudWatchClient cloudWatchClient) {
        return createExecutionLog(headerIn, error.getExceptionCode(), error.getErrorMessage(), new ExecutionInfoToLoggingDTO(), error.getLocation());
    }
    
}

package co.com.segurosalfa.msalfaarpisarquetipo.utils;

import java.util.Optional;

import co.com.segurosalfa.msalfaarpisarquetipo.model.ErrorDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.ExecutionInfoRuntimeDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.ExecutionInfoToLogging;
import co.com.segurosalfa.msalfaarpisarquetipo.model.HeaderInType;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;

public class LogService {
    
    public String createExecutionLog(HeaderInType headerIn, String errorCode, String errorDescription, ExecutionInfoToLogging logExecInfo, String location) {
        Optional.ofNullable(errorCode)
                .ifPresent(code -> {
                    logExecInfo.setCodigoErrorRetornado(code);
                    logExecInfo.setDescripcionErrorRetornado(errorDescription);
                });
    
        logExec(headerIn, logExecInfo, location);
    
        return logExecInfo.toString();
    }
    
    public void logExec(HeaderInType headerIn, ExecutionInfoToLogging logExecInfo, String location) {
        logExecInfo.setLocacion(location);
        logExecInfo.setOrigen(headerIn.getOrigen());
        logExecInfo.setIdEjecucion(headerIn.getIdEjecucion());
    }

    public String logToCloudWatch(HeaderInType headerIn, ErrorDTO error, ExecutionInfoRuntimeDTO execRuntimeInfo, CloudWatchClient cloudWatchClient) {
        return createExecutionLog(headerIn, error.getExceptionCode(), error.getErrorMessage(), new ExecutionInfoToLogging(), error.getLocation());
    }
    
}

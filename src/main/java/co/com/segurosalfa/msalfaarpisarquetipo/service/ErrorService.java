package co.com.segurosalfa.msalfaarpisarquetipo.service;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.stereotype.Component;

import co.com.segurosalfa.msalfaarpisarquetipo.model.ErrorDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.ComponentException;

@Component
public class ErrorService {
    
    public ErrorDTO errorHandlerRest(ComponentException exception, String location) {
        
        ErrorDTO messageFault = new ErrorDTO();
    
        messageFault.setExceptionCode(exception.getErrorException().toString());
    
        String errorMessage;
        if (exception.getMessage() == null) {
            if (exception.getErrorCause() != null && !exception.getErrorCause().isEmpty()) {
                errorMessage = exception.getErrorCause();
            } else {
                errorMessage = "No se tiene mensaje definido";
            }
        } else {
            errorMessage = exception.getMessage();
        }
    
        messageFault.setErrorMessage(errorMessage);
        messageFault.setErrorCause(getErrorCause(exception));
    
        messageFault.setLocation(exception.getLocation());
    
        return messageFault;
    }
    
    private String getErrorCause(ComponentException exception) {
        StringWriter sw = new StringWriter();
    
        try (PrintWriter pw = new PrintWriter(sw)) {
            if (exception.getCause() != null) {
                exception.getCause().printStackTrace(pw);
            } else {
                sw.append(exception.getMessage());
            }
        } catch (Exception ex) {
            // Handle any exceptions that might occur during StringWriter or PrintWriter operations.
        }
    
        return sw.toString();
    }
    
}

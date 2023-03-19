package co.com.segurosalfa.msalfaarpisarquetipo.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ComponentException extends Exception {
    
    private static final long serialVersionUID = 1L;

	private final String errorCode;

	private final CodeTypeError errorException;

	private String errorCause;

	private String message;

	private String location;

	public ComponentException(String errorCode, CodeTypeError errorException, String errorCause, String message, String location) {
		this.errorCode = errorCode;
		this.errorException = errorException;
		this.errorCause = errorCause;
		this.message = message;
		this.location = location;
	}

}

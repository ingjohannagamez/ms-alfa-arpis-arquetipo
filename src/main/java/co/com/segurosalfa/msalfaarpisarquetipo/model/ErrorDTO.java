package co.com.segurosalfa.msalfaarpisarquetipo.model;

import lombok.Data;

@Data
public class ErrorDTO {

    private String exceptionCode;
	private String errorMessage;
	private String errorCause;
	private String location;

}

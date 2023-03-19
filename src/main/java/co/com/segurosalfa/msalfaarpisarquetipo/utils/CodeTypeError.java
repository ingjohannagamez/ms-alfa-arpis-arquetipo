package co.com.segurosalfa.msalfaarpisarquetipo.utils;

import java.util.Arrays;

public enum CodeTypeError {
    
    ERROR_INESPERADO("0001"), 
    ERROR_PARAMETROS_INCORRECTOS("0002"), 
    ERROR_SIN_RESULTADOS("0280"), 
    ERROR_PARAMETROS_HI("0002");

	private final String code;

	private CodeTypeError(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static CodeTypeError getEnumByCode(String code) {
		return Arrays.asList(CodeTypeError.values()).stream().filter(et -> et.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
	}
    
}

package co.com.segurosalfa.msalfaarpisarquetipo.utils;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import co.com.segurosalfa.msalfaarpisarquetipo.model.dto.ExecutionInfoRuntimeDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.service.component.Utilities;

public abstract class BasicOperationAdapter<R, P> {
    
    private String serviceClass;
	private String serviceMethod;

	private Map<String, String> headers;

	private R response;
	private P request;

	protected String uUidTransaction = null;

	public BasicOperationAdapter(Map<String, String> headers, R response, P request) {
		this.headers = headers;
		this.request = request;
		this.response = response;
	}
	
	public BasicOperationAdapter(Map<String, String> headers, R response) {
		this.headers = headers;
		this.response = response;
	}

	public abstract R process(Map<String, String> headers, P request) throws ComponentException;

	public R preRun() throws ComponentException {
		return run();
	}

	public R run() throws ComponentException {

		// DTO de respuesta homologada
		ComponentException error = null;

		processHeader(headers);

		// Se almacena la información de ejecución del servicio.
		ExecutionInfoRuntimeDTO execRuntimeInfo = new ExecutionInfoRuntimeDTO(new Date());
		// Variable para almacenar la respuesta encriptada.
		R responseData = null;
		// Se define la ubicacion en caso de error.
		String location = Utilities.createErrorLocation(serviceClass, serviceMethod);

		try {

			// Se registra la fecha de inicio de invocación al legado.
			execRuntimeInfo.setLegacyInitialDate(new Date());

			responseData = process(headers, request);

			// Se registra la fecha de fin de invocación al legado
			execRuntimeInfo.setLegacyEndDate(new Date());

			// Se codifica y asigna la respuesta del servicio.
		} catch (ComponentException e) {

			error = e;

			throw error;
		} catch (Exception e) {

			// Se captura y encasula el error
			error = new ComponentException("",CodeTypeError.ERROR_INESPERADO, e.getCause().getMessage(), e.getCause().toString(),  location);

			throw error;
		} finally {

		}
		return responseData;

	}

	private void processHeader(Map<String, String> headers) {
		// Se define el id de transaccion unico.
		uUidTransaction = UUID.randomUUID().toString();
	}

	public BasicOperationAdapter<R, P> setCommonInfo(String serviceClass, String serviceMethod) {
		this.serviceClass = serviceClass;
		this.serviceMethod = serviceMethod;
		return this;
	}

	public BasicOperationAdapter<R, P> initializer() {

		return this;
	}
    
}

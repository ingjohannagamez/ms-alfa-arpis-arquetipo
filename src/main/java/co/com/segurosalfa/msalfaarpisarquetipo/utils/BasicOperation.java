package co.com.segurosalfa.msalfaarpisarquetipo.utils;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.SmartValidator;

import co.com.segurosalfa.msalfaarpisarquetipo.model.ErrorDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.ExecutionInfoRuntimeDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.HeaderInType;
import co.com.segurosalfa.msalfaarpisarquetipo.service.ErrorService;
import co.com.segurosalfa.msalfaarpisarquetipo.service.Utilities;

public abstract class BasicOperation<R, P> {
    
    private ErrorService adapterError;

	private SmartValidator validator;

	private Map<String, String> headers;

	private R response;
	private P request;

	private LogService servicioLog;

	protected String uUidTransaction = null;

	private String serviceClass;
	private String serviceMethod;

	public BasicOperation(Map<String, String> headers, R response, P request) {

		this.headers = headers;
		this.response = response;
		this.request = request;
	}

	public BasicOperation(Map<String, String> headers, R response) {

		this.headers = headers;
		this.response = response;
	}

	public abstract R process(Map<String, String> headers, P request) throws ComponentException;

	public ResponseEntity preRun() throws ComponentException {
		return run();
	}

	public ResponseEntity run() throws ComponentException {

		// DTO de respuesta homologada
		ErrorDTO error = null;

		// Headers del contexto
		HttpHeaders headersOutMap = null;
		// DTO de respuesta homologada

		processHeader(headers);

		// Se almacena la información de ejecución del servicio.
		ExecutionInfoRuntimeDTO execRuntimeInfo = new ExecutionInfoRuntimeDTO(new Date());

		// Variable para almacenar la respuesta encriptada.
		R responseData = null;

		String locacion = Utilities.createErrorLocation(serviceClass, serviceMethod);

		HeaderInType headerIn = null;
		try {

			headerIn = Utilities.getHeaderIn(headers, serviceClass, serviceMethod);
			// Se realiza la validación del body

			if (request != null) {
				Utilities.validateBodyMessage(request, validator, locacion);
			}
			// Se registra la fecha de inicio de invocación al legado.
			execRuntimeInfo.setLegacyInitialDate(new Date());

			responseData = process(headers, request);

			// Se registra la fecha de fin de invocación al legado
			execRuntimeInfo.setLegacyEndDate(new Date());

			return new ResponseEntity<R>(responseData, headersOutMap, HttpStatus.OK);

		} catch (Exception e) {

			// Se transforma a ComponentException
			ComponentException exc = new ComponentException("",CodeTypeError.ERROR_INESPERADO, e.getMessage(),
					Utilities.getExceptionMessage(e), locacion);

			// Se incluye excepción en el MessageFault a retornar
			error = adapterError.errorHandlerRest(exc, locacion);

			return new ResponseEntity<ErrorDTO>(error, HttpStatus.valueOf(Integer.parseInt("500")));

		} finally {

			if (error != null) {
                // Reemplazar esta línea con la lógica de registro usando CloudWatch
                //logService.logToCloudWatch(headerIn, error, execRuntimeInfo, cloudWatchClient);
				/* telemetryClient.trackEvent(servicioLog.createExecutionLog(headerIn, error.getExceptionCode(),
						error.getErrorCause(), new ExecutionInfoToLogging(), error.getLocation())); */
			}

		}
	}

	private void processHeader(Map<String, String> headers) {
		// Se define el id de transaccion unico.
		uUidTransaction = UUID.randomUUID().toString();
	}

	public BasicOperation<R, P> setCommonInfo(String serviceClass, String serviceMethod) {
		this.serviceClass = serviceClass;
		this.serviceMethod = serviceMethod;
		return this;
	}

	public BasicOperation<R, P> initializer(SmartValidator validator, LogService servicioLog) {
		this.validator = validator;
		this.servicioLog = servicioLog;
		return this;
	}

	public BasicOperation<R, P> errors(ErrorService adapterError) {
		this.adapterError = adapterError;
		return this;
	}
    
}

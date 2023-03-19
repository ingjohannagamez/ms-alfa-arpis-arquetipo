package co.com.segurosalfa.msalfaarpisarquetipo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.segurosalfa.msalfaarpisarquetipo.service.ErrorService;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.BasicOperation;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.ComponentException;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.GeneralConstants;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.LogService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("${controller.properties.base-path}")
@Tag(name = "Controller", description = "Controller encargado de XXXXXXXXXXXXXXXXX")
public class ServiceController {
 
    private final ErrorService adapterError;
    private final SmartValidator smartValidator;
    private final LogService servicioLog;

	public ServiceController(ErrorService adapterError, SmartValidator smartValidator, LogService servicioLog) {
        this.adapterError = adapterError;
        this.smartValidator = smartValidator;
        this.servicioLog = servicioLog;
    }

	@CrossOrigin(origins = "*")
    @GetMapping("/personas")
	@Tag(name = "Ejemplo", description = "Este es un ejemplo de endpoint")
	public ResponseEntity<?> personasFindAll() throws ComponentException {

		Map<String, String> headerReq = new HashMap<>();
			headerReq.put("X-TransactionId", "9999");
			headerReq.put("X-FromAppId", "jimmy-postman");
			headerReq.put("Accept", "Application/json");
			headerReq.put("Content-Type", "application/merge-patch+json");
			headerReq.put("Authorization", "Basic QUFJOkFBSQ==");
			
		return new BasicOperation<Object, Object>(headerReq, new Object(), new Object()) {
			@Override
            public ResponseEntity<?> process(Map<String, String> headers, Object request) throws ComponentException {
				return ResponseEntity.ok("todo bien");
			}
		}.errors(adapterError).initializer(smartValidator, servicioLog).setCommonInfo(this.getClass().getSimpleName(), GeneralConstants.GET_OPERATION).run();
	}
    
}

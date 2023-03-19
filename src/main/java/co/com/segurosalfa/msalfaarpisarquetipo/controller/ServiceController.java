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
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("${controller.properties.base-path}")
@Tag(name = "Controller", description = "Controller encargado de XXXXXXXXXXXXXXXXX")
public class ServiceController {
 
    private ErrorService adapterError = new ErrorService();
    private SmartValidator smartValidator;
    private LogService servicioLog;

	@CrossOrigin(origins = "*")
    @GetMapping("/personas")
	public ResponseEntity<?> personasFindAll() throws ComponentException {

		Map<String, String> headerReq = new HashMap<>();
			
		return new BasicOperation<String, String>(headerReq, "", null) {
			@Override
            public String process(Map<String, String> headers, String request) throws ComponentException {
				return "todo bien";
			}
		}.errors(adapterError).initializer(smartValidator, servicioLog).setCommonInfo(this.getClass().getSimpleName(), GeneralConstants.GET_OPERATION).run();
	}
    
}

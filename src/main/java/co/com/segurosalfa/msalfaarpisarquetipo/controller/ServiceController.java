package co.com.segurosalfa.msalfaarpisarquetipo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.SmartValidator;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.segurosalfa.msalfaarpisarquetipo.service.ErrorService;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.BasicOperation;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.CodeTypeError;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.ComponentException;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.GeneralConstants;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Controlador REST para gestionar operaciones relacionadas con XXXXXXXXXXXXXXXXX.
 * Utiliza SpringDoc OpenAPI Starter para generar la documentación de la API.
 */
@RestController
@RequestMapping("${controller.properties.base-path}")
@Tag(name = "ServiceController", description = "Controller encargado de XXXXXXXXXXXXXXXXX")
public class ServiceController {
 
    // Servicio para manejar errores
    private ErrorService adapterError = new ErrorService();
    // Validador inteligente de Spring
    private SmartValidator smartValidator;
    // Servicio para registrar eventos (logs)
    private LogService servicioLog;

    /**
     * Endpoint para recuperar todas las personas.
     *
     * @return ResponseEntity con una lista de personas o una respuesta de error en caso de fallo.
     * @throws ComponentException en caso de error en el procesamiento de la solicitud.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/personas")
    @Operation(summary = "Recuperar todas las personas", description = "Recupera una lista de todas las personas disponibles.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de personas recuperada con éxito",
                     content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))}),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
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

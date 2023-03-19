package co.com.segurosalfa.msalfaarpisarquetipo.service;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.SmartValidator;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import co.com.segurosalfa.msalfaarpisarquetipo.model.HeaderInDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.HeaderInType;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.CodeTypeError;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.ComponentException;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.GeneralConstants;

@Component
public class Utilities {
    
    public static void validateBodyMessage(Object request, SmartValidator validator, String locacion) throws ComponentException {
        
        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(request, request.getClass().getSimpleName());
        validator.validate(request, bindingResult);

        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();

            bindingResult.getFieldErrors().stream().forEach(ef -> {
                errorMessages.append(ef.getObjectName())
                              .append(GeneralConstants.DOT)
                              .append(ef.getField())
                              .append(GeneralConstants.SPACE)
                              .append(ef.getDefaultMessage());
            });
            throw new ComponentException("", CodeTypeError.ERROR_PARAMETROS_INCORRECTOS, errorMessages.toString(), "", locacion);
        }
    }

    public static String getExceptionMessage(Exception ex) {
        String message = GeneralConstants.EMPTY;
        if (ex != null) {
            if (ex.getMessage() != null) {
                message = ex.getMessage();
            } else if (ex.getCause() != null) {
                message = ex.getCause().getMessage();
            }
        }
        return message;
    }

    public static String createErrorLocation(String serviceClass, String serviceMethod) {
        return new StringBuilder(GeneralConstants.STRING_SERVICE)
                .append(serviceClass)
                .append(GeneralConstants.SPACE)
                .append(GeneralConstants.STRING_OPERATION)
                .append(serviceMethod)
                .toString();
    }

    public static HeaderInType getHeaderIn(Map<String, String> headers, String serviceClass, String serviceMethod)
            throws ComponentException {
        try {
            HeaderInDTO headerIn = mapToObject(headers, HeaderInDTO.class);
            return objectToObject(headerIn, HeaderInType.class);
        } catch (Exception ex) {
            throw new ComponentException("", CodeTypeError.ERROR_PARAMETROS_HI, ex.getCause().toString(),
                    ex.getMessage(), createErrorLocation(serviceClass, serviceMethod));
        }
    }

    public static <T> T mapToObject(Map<String, String> map, Class<T> classe) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        return mapper.convertValue(map, classe);
    }

    public static <T, R> R objectToObject(T object, Class<R> classe) {
        Gson json = new Gson();
        String jsonString = json.toJson(object);
        return json.fromJson(jsonString, classe);
    }

}

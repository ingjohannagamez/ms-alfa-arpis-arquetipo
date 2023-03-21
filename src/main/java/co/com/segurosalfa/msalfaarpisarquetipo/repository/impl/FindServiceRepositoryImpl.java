package co.com.segurosalfa.msalfaarpisarquetipo.repository.impl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.com.segurosalfa.msalfaarpisarquetipo.model.dto.ServiceRequestDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.dto.ServiceResponseDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.repository.interfaces.FindServiceRepository;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.BasicOperationAdapter;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.ComponentException;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.GeneralConstants;

@Service
public class FindServiceRepositoryImpl implements FindServiceRepository {

    @Override
    public ServiceResponseDTO personaFindById(Map<String, String> headerReq, ServiceRequestDTO request) throws ComponentException {
        try {			
            return new BasicOperationAdapter<ServiceResponseDTO, ServiceRequestDTO>(headerReq, new ServiceResponseDTO(), request) {

                public ServiceResponseDTO process(Map<String, String> headers, ServiceRequestDTO request) throws ComponentException {

                    ServiceResponseDTO result = new ServiceResponseDTO();

                    result.setId(String.valueOf(HttpStatus.OK.value()));
                    result.setName("Prueba del arquetipo.");
                    result.setDescription("ejecución exitosa.");

                    return result;
                }

            }.initializer().setCommonInfo(this.getClass().getSimpleName(), GeneralConstants.GET_OPERATION).run();
        } catch (Exception e) {
            throw e;
        }

    }
    
}

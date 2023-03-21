package co.com.segurosalfa.msalfaarpisarquetipo.service.interfaces;

import java.util.Map;

import co.com.segurosalfa.msalfaarpisarquetipo.model.dto.ServiceRequestDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.dto.ServiceResponseDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.ComponentException;

public interface FindService {

    ServiceResponseDTO personaFindById(Map<String, String> headerReq, ServiceRequestDTO request) throws ComponentException;
}

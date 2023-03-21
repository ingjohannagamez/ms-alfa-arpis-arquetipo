package co.com.segurosalfa.msalfaarpisarquetipo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.segurosalfa.msalfaarpisarquetipo.model.dto.ServiceRequestDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.model.dto.ServiceResponseDTO;
import co.com.segurosalfa.msalfaarpisarquetipo.repository.interfaces.FindServiceRepository;
import co.com.segurosalfa.msalfaarpisarquetipo.service.interfaces.FindService;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.BasicOperationService;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.ComponentException;
import co.com.segurosalfa.msalfaarpisarquetipo.utils.GeneralConstants;

@Service
public class FindServiceImpl implements FindService {

	@Autowired
	private FindServiceRepository findServiceRepository;

    @Override
    public ServiceResponseDTO personaFindById(Map<String, String> headerReq, ServiceRequestDTO request) throws ComponentException {
        try {
			return new BasicOperationService<ServiceResponseDTO, ServiceRequestDTO>(headerReq,	new ServiceResponseDTO(), request) {

				@Override
				public ServiceResponseDTO process(Map<String, String> headerReq, ServiceRequestDTO request)	throws ComponentException {
					
					return findServiceRepository.personaFindById(headerReq, request);
				}
			}.initializer().setCommonInfo(this.getClass().getSimpleName(), GeneralConstants.GET_OPERATION).run();
		} catch (Exception e) {
			throw e;
		}
    }
    
}

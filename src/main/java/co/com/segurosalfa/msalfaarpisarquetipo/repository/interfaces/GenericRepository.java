package co.com.segurosalfa.msalfaarpisarquetipo.repository.interfaces;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import co.com.segurosalfa.msalfaarpisarquetipo.model.entity.Persona;

public interface GenericRepository extends CrudRepository<Persona, Integer>, PagingAndSortingRepository<Persona, Integer>, JpaSpecificationExecutor<Persona> {
    
}

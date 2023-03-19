package co.com.segurosalfa.msalfaarpisarquetipo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class HeaderInDTO {
    
    @NotNull
	@NotEmpty
	@Size(min = 2, max = 2)
	protected String pais;

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 2)
	protected String lenguaje;

	@NotNull
	@Size(max = 32)
	protected String origen;

	@NotNull
	@Size(max = 32)
	protected String operacion;

	@NotNull
	@NotEmpty
	@Size(max = 36)
	@Pattern(regexp = "[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}")
	@JsonAlias("idejecucion")
	protected String idEjecucion;

	@NotNull
	@NotEmpty
	@Size(max = 29)
	protected String FechaPeticion;
    
}

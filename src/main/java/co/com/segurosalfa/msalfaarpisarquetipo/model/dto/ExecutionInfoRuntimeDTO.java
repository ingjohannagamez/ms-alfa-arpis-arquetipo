package co.com.segurosalfa.msalfaarpisarquetipo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ExecutionInfoRuntimeDTO {
    
    @NonNull
    private Date serviceInitialDate;
    private Date legacyInitialDate;
    private Date legacyEndDate;
    private Date serviceEndDate;
    
}

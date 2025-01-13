package nl.mesander.dtos.output;

// Imports
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class MultipleEmployeeDto {
    private List<EmployeeDto> employeeDtos;
}

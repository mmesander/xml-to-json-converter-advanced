package nl.mesander.dtos.input;

// Imports
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Employees")
public class MultipleEmployeeInputDto {
    private List<EmployeeInputDto> employees;

    // Getters and Setters
    @XmlElement(name = "Employee")
    public List<EmployeeInputDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeInputDto> employees) {
        this.employees = employees;
    }
}

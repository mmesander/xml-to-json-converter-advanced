package nl.mesander.dtos.input;

// Imports
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
public class EmployeeInputDto {
    private String name;
    private String function;
    private String company;
    private String toHire;

    // Getters and Setters
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @XmlElement
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @XmlElement
    public String getToHire() {
        return toHire;
    }

    public void setToHire(String toHire) {
        this.toHire = toHire;
    }
}

package nl.mesander.dtos.output;

public class EmployeeDto {
    private String name;
    private String function;
    private String company;
    // Changed from toHire to isHired
    private String isHired;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIsHired() {
        return isHired;
    }

    public void setIsHired(String isHired) {
        this.isHired = isHired;
    }
}

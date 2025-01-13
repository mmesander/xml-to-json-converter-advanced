package nl.mesander;

import nl.mesander.dtos.input.EmployeeInputDto;
import nl.mesander.dtos.input.MultipleEmployeeInputDto;
import nl.mesander.dtos.output.EmployeeDto;

import java.util.List;

import static nl.mesander.services.EmployeeService.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String fileLocation = "src/main/resources/Employees.xml";
        MultipleEmployeeInputDto employeeInputDtos = xmlToJava(fileLocation);
        List<EmployeeDto> employeeDtos = multipleEmployeesToDto(xmlToJava(fileLocation));

        if (employeeInputDtos != null || !employeeInputDtos.getEmployees().isEmpty()) {
            System.out.println("XML to Java: ");
            for (EmployeeInputDto employeeInputDto : employeeInputDtos.getEmployees()) {
                System.out.println("------------------");
                System.out.println("Name: " + employeeInputDto.getName());
                System.out.println("Function: " + employeeInputDto.getFunction());
                System.out.println("Company: " + employeeInputDto.getCompany());
                System.out.println("To Hire: " + employeeInputDto.getToHire());
                System.out.println("------------------");
                System.out.println(" ");
            }
        }

        if (employeeDtos != null || !employeeDtos.isEmpty()) {
            System.out.println("Input to Output dto's");
            for (EmployeeDto employeeDto : employeeDtos) {
                System.out.println("------------------");
                System.out.println("Name: " + employeeDto.getName());
                System.out.println("Function: " + employeeDto.getFunction());
                System.out.println("Company: " + employeeDto.getCompany());
                System.out.println("Is Hired: " + employeeDto.getIsHired());
                System.out.println("------------------");
                System.out.println(" ");
            }
        }













//
//        if (employeeDto != null) {
//            String jsonString = javaToJson(employeeDto);
//            System.out.println("Json string: ");
//            System.out.println(jsonString);
//            System.out.println("------------------");
//            System.out.println(" ");
//        }
    }
}
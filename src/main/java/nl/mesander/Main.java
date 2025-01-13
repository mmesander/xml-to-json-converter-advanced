package nl.mesander;

import nl.mesander.dtos.input.EmployeeInputDto;
import nl.mesander.dtos.input.MultipleEmployeeInputDto;
import nl.mesander.dtos.output.EmployeeDto;

import static nl.mesander.services.EmployeeService.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String fileLocation = "src/main/resources/Employees.xml";
        MultipleEmployeeInputDto employeeInputDtos = xmlToJava(fileLocation);
        EmployeeDto employeeDto = null;

        for (EmployeeInputDto employeeInputDto : employeeInputDtos.getEmployees()) {
            System.out.println(employeeInputDto.getName());
            System.out.println(employeeInputDto.getFunction());
            System.out.println(employeeInputDto.getCompany());
            System.out.println(employeeInputDto.getToHire());
        }



//        if (employeeInputDto != null) {
//            System.out.println("XML naar Java: ");
//            System.out.println(employeeInputDto.getName());
//            System.out.println(employeeInputDto.getFunction());
//            System.out.println(employeeInputDto.getCompany());
//            System.out.println(employeeInputDto.getToHire());
//            System.out.println("------------------");
//            System.out.println(" ");
//        } else {
//            System.out.println("Employee not found for transfer xml to java");
//            System.out.println("------------------");
//            System.out.println(" ");
//        }
//
//        if (employeeInputDto != null) {
//            employeeDto = employeeToDto(employeeInputDto);
//            System.out.println("Input naar output: ");
//            System.out.println(employeeDto.getName());
//            System.out.println(employeeDto.getFunction());
//            System.out.println(employeeDto.getCompany());
//            System.out.println(employeeDto.getIsHired());
//            System.out.println("------------------");
//            System.out.println(" ");
//        } else {
//            System.out.println("Employee not found for transfer input to output");
//            System.out.println("------------------");
//            System.out.println(" ");
//        }
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
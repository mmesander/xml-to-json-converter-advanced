package nl.mesander.services;

// Imports
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import nl.mesander.dtos.input.EmployeeInputDto;
import nl.mesander.dtos.input.MultipleEmployeeInputDto;
import nl.mesander.dtos.output.EmployeeDto;
import java.io.File;

public class EmployeeService {

    // Transfer Methods
    public static EmployeeDto employeeToDto(EmployeeInputDto inputDto) {
        EmployeeDto employeeDto = new EmployeeDto();

        // CopyProperties helper method optional
        employeeDto.setName(inputDto.getName());
        employeeDto.setFunction(inputDto.getFunction());
        employeeDto.setCompany(inputDto.getCompany());

        // Changed variable
        employeeDto.setIsHired(inputDto.getToHire());

        return employeeDto;
    }

    // Methods
    public static MultipleEmployeeInputDto xmlToJava(String fileLocation) {
        if (fileLocation == null || fileLocation.isEmpty()) {
            throw new IllegalArgumentException("File location is null/empty");
        }

        // Create file to make method universal (not hardcoded)
        File xmlFile = new File(fileLocation);

        if (!xmlFile.exists() || !xmlFile.isFile()) {
            throw new IllegalArgumentException("File: " + fileLocation + " doesn't exist");
        }

        try {
            // Create a new inputDto class
            JAXBContext xmlContext = JAXBContext.newInstance(MultipleEmployeeInputDto.class);

            // Create Unmarshaller for converting XML to Java (Marshaller for java to xml)
            Unmarshaller unmarshaller = xmlContext.createUnmarshaller();

            // Execute unmarshaller, unmarshaller provides an object
            // unmarshaller creates an object so use explicit cast to 'transfer' object to EmployeeInputDto
            MultipleEmployeeInputDto employeeInputDtos = (MultipleEmployeeInputDto) unmarshaller.unmarshal(xmlFile);

            return employeeInputDtos;
        } catch (JAXBException error) {
            throw new IllegalArgumentException("Problem with unmarshalling file " + fileLocation + ": " + error.getMessage());
        }
    }

    public static String javaToJson(EmployeeDto employeeDto) {
        try {
            // Create an instance of objectmapper from jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert Java object to JSON string
            String jsonString = objectMapper.writeValueAsString(employeeDto);

            return jsonString;
        } catch (JsonProcessingException error) {
            error.printStackTrace();
            return null;
        }
    }
}

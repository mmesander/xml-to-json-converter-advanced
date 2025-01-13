package nl.mesander.services;

// Imports
import nl.mesander.dtos.input.EmployeeInputDto;
import nl.mesander.dtos.input.MultipleEmployeeInputDto;
import nl.mesander.dtos.output.EmployeeDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeInputDto mockEmployeeInputDto1;
    EmployeeInputDto mockEmployeeInputDto2;

    EmployeeDto mockEmployeeDto1;
    EmployeeDto mockEmployeeDto2;

    List<EmployeeInputDto> mockEmployeeInputDtos;
    List<EmployeeDto> mockEmployeeDtos;

    MultipleEmployeeInputDto mockMultipleEmployeeInputDto;

    String testFileLocationSuccess;
    String testFileLocationEmpty;
    String testFileLocationNotFound;

    String mockJsonStringSuccess;
    String mockJsonStringException;

    @BeforeEach
    void init() {
        // Input Dto
        mockEmployeeInputDto1 = new EmployeeInputDto();
        mockEmployeeInputDto1.setName("Mark Test");
        mockEmployeeInputDto1.setFunction("Junior Java Developer Test");
        mockEmployeeInputDto1.setCompany("Copernicus Test");
        mockEmployeeInputDto1.setToHire("Absolutely");

        mockEmployeeInputDto2 = new EmployeeInputDto();
        mockEmployeeInputDto2.setName("David Test");
        mockEmployeeInputDto2.setFunction("Eindbaas Java Developer");
        mockEmployeeInputDto2.setCompany("Copernicus Test");
        mockEmployeeInputDto2.setToHire("Yes");

        // Output Dto
        mockEmployeeDto1 = new EmployeeDto();
        mockEmployeeDto1.setName("Mark Super Test");
        mockEmployeeDto1.setFunction("Medior Java Developer Test");
        mockEmployeeDto1.setCompany("Copernicus Maximus");
        mockEmployeeDto1.setIsHired("100% Yes");

        mockEmployeeDto2 = new EmployeeDto();
        mockEmployeeDto2.setName("David Verloop Test");
        mockEmployeeDto2.setFunction("Tech Lead Super Deluxe");
        mockEmployeeDto2.setCompany("Copernicus Maximus");
        mockEmployeeDto2.setIsHired("Already Hired Test");

        // Multiple Input Dtos
        mockEmployeeInputDtos = new ArrayList<>();
        mockEmployeeInputDtos.add(mockEmployeeInputDto1);
        mockEmployeeInputDtos.add(mockEmployeeInputDto2);

        mockMultipleEmployeeInputDto.setEmployees(mockEmployeeInputDtos);

        // Multiple Output Dtos
        mockEmployeeDtos = new ArrayList<>();
        mockEmployeeDtos.add(mockEmployeeDto1);
        mockEmployeeDtos.add(mockEmployeeDto2);

        // Location
        testFileLocationSuccess = "src/test/resources/EmployeeTest.xml";
        testFileLocationEmpty = "";
        testFileLocationNotFound = "/src/test/resources/NotHere.xml";

        //Json
        mockJsonStringSuccess = "{\"name\":\"Mark Super Test\",\"function\":\"Medior Java Developer Test\",\"company\":\"Copernicus Super Test\",\"isHired\":\"100% Yes\"}";
        mockJsonStringException = "";


    }

    @AfterEach
    void tearDown() {
        mockEmployeeInputDto1 = null;
        mockEmployeeInputDto2 = null;
        mockEmployeeDto1 = null;
        mockEmployeeDto2 = null;
        mockEmployeeInputDtos = null;
        mockEmployeeDtos = null;
        mockMultipleEmployeeInputDto = null;
        testFileLocationSuccess = "";
        testFileLocationNotFound = "";
        mockJsonStringSuccess = "";
        mockJsonStringException = "";
    }

    @Test
    @DisplayName("Should transfer EmployeeInputDto to EmployeeDto")
    void employeeToDto_Success() {
        // Arrange
        // BeforeEach init EmployeeInputDto: mockEmployeeInputDto

        // Act
        EmployeeDto result = EmployeeService.employeeToDto(mockEmployeeInputDto);

        // Assert
        assertEquals(mockEmployeeInputDto.getName(), result.getName());
        assertEquals(mockEmployeeInputDto.getFunction(), result.getFunction());
        assertEquals(mockEmployeeInputDto.getCompany(), result.getCompany());
        assertEquals(mockEmployeeInputDto.getToHire(), result.getIsHired());
    }

    @Test
    @DisplayName("Should transfer Xml file to MultipleEmployeeInputDto")
    void XmlToJava_Success() {
    }

    @Test
    @DisplayName("Should throw exception: file location is null/empty")
    void XmlToJava_Exception_WhenEmpty() {
    }

    @Test
    @DisplayName("Should throw exception: File doesn't exist")
    void testXmlToJava_Exception_WhenDoesNotExist() {
    }

    @Test
    @DisplayName("Should throw exception: Problem with unmarshalling file")
    void testXmlToJava_Exception_WhenJAXBException() {
    }

    //    @Test
//    @DisplayName("Should transfer XML file to EmployeeInputDto")
//    void xmlToJava() {
//        // Arrange
//        // BeforeEach init String: testFileLocation
//
//        // Act
//        EmployeeInputDto result = EmployeeService.xmlToJava(testFileLocation);
//
//        // Assert
//        assertEquals("Mark Mesander Test", result.getName());
//        assertEquals("Junior Java Developer Test", result.getFunction());
//        assertEquals("Copernicus Test", result.getCompany());
//        assertEquals("Absolutely", result.getToHire());
//    }

    @Test
    @DisplayName("Should transfer multiple EmployeeInputDto's to List of EmployeeDto's")
    void multipleEmployeesToDto_Success() {
    }

    @Test
    @DisplayName("Should throw exception: No employees found")
    void multipleEmployeesToDto_Exception_WhenNotFound() {
    }

    //    @Test
//    @DisplayName("Should transfer EmployeeDto to JsonString")
//    void javaToJson() {
//        // Arrange
//        // BeforeEach init EmployeeDto: mockEmployeeDto
//        // BeforeEach init String: mockJsonString
//
//        // Act
//        String result = EmployeeService.javaToJson(mockEmployeeDto);
//
//        // Assert
//        assertEquals(mockJsonString, result);
//
//    }

    @Test
    @DisplayName("Should transfer java to Json String")
    void testJavaToJson_Success() {
    }

    @Test
    @DisplayName("Should throw exception: Can't be empty")
    void testJavaToJson_Exception_WhenEmpty() {
    }

    @Test
    @DisplayName("Should throw exception: Problem with processing json")
    void testJavaToJson_Exception_WhenJsonProcessingException() {
    }
}
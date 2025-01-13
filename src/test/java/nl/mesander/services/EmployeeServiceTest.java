package nl.mesander.services;

// Imports
import nl.mesander.dtos.input.EmployeeInputDto;
import nl.mesander.dtos.output.EmployeeDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeInputDto mockEmployeeInputDto;
    EmployeeDto mockEmployeeDto;
    String testFileLocation;
    String mockJsonString;

    @BeforeEach
    void init() {
        mockEmployeeInputDto = new EmployeeInputDto();
        mockEmployeeInputDto.setName("Mark Test");
        mockEmployeeInputDto.setFunction("Junior Java Developer Test");
        mockEmployeeInputDto.setCompany("Copernicus Test");
        mockEmployeeInputDto.setToHire("Absolutely");

        testFileLocation = "src/test/resources/EmployeeTest.xml";

        mockJsonString = "{\"name\":\"Mark Super Test\",\"function\":\"Medior Java Developer Test\",\"company\":\"Copernicus Super Test\",\"isHired\":\"100% Yes\"}";

        mockEmployeeDto = new EmployeeDto();
        mockEmployeeDto.setName("Mark Super Test");
        mockEmployeeDto.setFunction("Medior Java Developer Test");
        mockEmployeeDto.setCompany("Copernicus Super Test");
        mockEmployeeDto.setIsHired("100% Yes");
    }

    @AfterEach
    void tearDown() {
        mockEmployeeInputDto = null;
        mockEmployeeDto = null;
        testFileLocation = "";
        mockJsonString = "";
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
package nl.mesander.services;

// Imports
import nl.mesander.dtos.input.EmployeeInputDto;
import nl.mesander.dtos.input.MultipleEmployeeInputDto;
import nl.mesander.dtos.output.EmployeeDto;
import nl.mesander.exceptions.IllegalArgumentException;
import nl.mesander.exceptions.RecordNotFoundException;
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
    List<EmployeeDto> mockEmployeeDtosEmpty;
    List<EmployeeInputDto> mockEmployeeDtosInvalid;

    MultipleEmployeeInputDto mockMultipleEmployeeInputDtoEmpty;
    MultipleEmployeeInputDto mockMultipleEmployeeInputDto;

    String testFileLocationSuccess;
    String testFileLocationEmpty;
    String testFileLocationNotFound;
    String testFileLocationInvalid;

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

        mockMultipleEmployeeInputDtoEmpty = new MultipleEmployeeInputDto();
        mockMultipleEmployeeInputDto = new MultipleEmployeeInputDto();
        mockMultipleEmployeeInputDto.setEmployees(mockEmployeeInputDtos);

        // Multiple Output Dtos
        mockEmployeeDtosEmpty = new ArrayList<>();
        mockEmployeeDtos = new ArrayList<>();
        mockEmployeeDtos.add(mockEmployeeDto1);
        mockEmployeeDtos.add(mockEmployeeDto2);

        // Location
        testFileLocationSuccess = "src/test/resources/EmployeeTest.xml";
        testFileLocationEmpty = "";
        testFileLocationNotFound = "/src/test/resources/NotHere.xml";
        testFileLocationInvalid = "src/test/resources/EmployeeTestInvalid.xml";

        //Json
        mockJsonStringSuccess = "[{\"name\":\"Mark Super Test\",\"function\":\"Medior Java Developer Test\",\"company\":\"Copernicus Maximus\",\"isHired\":\"100% Yes\"},{\"name\":\"David Verloop Test\",\"function\":\"Tech Lead Super Deluxe\",\"company\":\"Copernicus Maximus\",\"isHired\":\"Already Hired Test\"}]";
        mockJsonStringException = "";


    }

    @AfterEach
    void tearDown() {
        mockEmployeeInputDto1 = null;
        mockEmployeeInputDto2 = null;
        mockEmployeeDto1 = null;
        mockEmployeeDto2 = null;
        mockEmployeeInputDtos = null;
        mockEmployeeDtosEmpty = null;
        mockEmployeeDtos = null;
        mockMultipleEmployeeInputDto = null;
        mockMultipleEmployeeInputDtoEmpty = null;
        testFileLocationSuccess = "";
        testFileLocationEmpty = "";
        testFileLocationNotFound = "";
        testFileLocationInvalid = "";
        mockJsonStringSuccess = "";
        mockJsonStringException = "";
    }

    // Transfer Method Tests
    @Test
    @DisplayName("Should transfer EmployeeInputDto to EmployeeDto")
    void employeeToDto_Success() {
        // Arrange
        // BeforeEach init EmployeeInputDto: mockEmployeeInputDto1

        // Act
        EmployeeDto result = EmployeeService.employeeToDto(mockEmployeeInputDto1);

        // Assert
        assertEquals(mockEmployeeInputDto1.getName(), result.getName());
        assertEquals(mockEmployeeInputDto1.getFunction(), result.getFunction());
        assertEquals(mockEmployeeInputDto1.getCompany(), result.getCompany());
        assertEquals(mockEmployeeInputDto1.getToHire(), result.getIsHired());
    }

    // Transfer XML to Java Tests
    @Test
    @DisplayName("Should transfer Xml file to MultipleEmployeeInputDto")
    void XmlToJava_Success() {
        // Arrange
        // BeforeEach init String: testFileLocationSuccess

        // Act
        MultipleEmployeeInputDto result = EmployeeService.xmlToJava(testFileLocationSuccess);

        // Assert
        assertEquals("Mark Mesander Test", result.getEmployees().get(0).getName());
        assertEquals("Medior Java Developer", result.getEmployees().get(0).getFunction());
        assertEquals("Copernicus", result.getEmployees().get(0).getCompany());
        assertEquals("Absolutely", result.getEmployees().get(0).getToHire());
        assertEquals("David Verloop", result.getEmployees().get(1).getName());
        assertEquals("Tech Lead", result.getEmployees().get(1).getFunction());
        assertEquals("Copernicus", result.getEmployees().get(1).getCompany());
        assertEquals("Already Hired", result.getEmployees().get(1).getToHire());
    }

    @Test
    @DisplayName("Should throw exception: file location is null/empty")
    void XmlToJava_Exception_WhenEmpty() {
        // Arrange
        // BeforeEach init String: testFileLocationEmpty

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EmployeeService.xmlToJava(testFileLocationEmpty);
        });

        // Assert
        String expectedMessage = "File location is null/empty";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should throw exception: File doesn't exist")
    void testXmlToJava_Exception_WhenDoesNotExist() {
        // Arrange
        // BeforeEach init String: testFileLocationNotFound

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EmployeeService.xmlToJava(testFileLocationNotFound);
        });

        String expectedMessage = "File: " + testFileLocationNotFound + " doesn't exist";
        String actualMessage = exception.getMessage();

        // Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should throw exception: Problem with unmarshalling file")
    void testXmlToJava_Exception_WhenJAXBException() {
        // Arrange
        // BeforeEach init String: testFileLocationInvalid

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EmployeeService.xmlToJava(testFileLocationInvalid);
        });

        // Assert
        String expectedMessage = "Problem with unmarshalling file " + testFileLocationInvalid + ": ";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Expected message should contain actual message");
    }

    // Transfer InputDto to OutputDto Tests
    @Test
    @DisplayName("Should transfer multiple EmployeeInputDto's to List of EmployeeDto's")
    void multipleEmployeesToDto_Success() {
        // Arrange
        // BeforeEach init MultipleEmployeeInputDto: mockMultipleEmployeeInputDto

        // Act
        List<EmployeeDto> result = EmployeeService.multipleEmployeesToDto(mockMultipleEmployeeInputDto);

        // Assert
        assertEquals("Mark Test", result.get(0).getName());
        assertEquals("Junior Java Developer Test", result.get(0).getFunction());
        assertEquals("Copernicus Test", result.get(0).getCompany());
        assertEquals("Absolutely", result.get(0).getIsHired());
        assertEquals("David Test", result.get(1).getName());
        assertEquals("Eindbaas Java Developer", result.get(1).getFunction());
        assertEquals("Copernicus Test", result.get(1).getCompany());
        assertEquals("Yes", result.get(1).getIsHired());
    }

    @Test
    @DisplayName("Should throw exception: No employees found")
    void multipleEmployeesToDto_Exception_WhenNotFound() {
        // Arrange
        // BeforeEach init MultipleEmployeeInputDto: mockMultipleEmployeeInputDtoEmpty

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            EmployeeService.multipleEmployeesToDto(mockMultipleEmployeeInputDtoEmpty);
        });

        // Assert
        String expectedMessage = "No employees found";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    // Transfer Java to JSON Tests
    @Test
    @DisplayName("Should transfer java to Json String")
    void testJavaToJson_Success() {
        // Arrange
        // BeforeEach init List<EmployeeDto>: mockEmployeeDtos
        // BeforeEach init String: mockJsonStringSucces

        // Act
        String result = EmployeeService.javaToJson(mockEmployeeDtos);

        // Assert
        assertEquals(mockJsonStringSuccess, result);
    }

    @Test
    @DisplayName("Should throw exception: Can't be empty")
    void testJavaToJson_Exception_WhenEmpty() {
        // Arrange
        // BeforeEach init List<EmployeeDto>: mockEmployeeDtosEmpty

        // Act
        Exception exception = assertThrows(RecordNotFoundException.class, () -> {
            EmployeeService.javaToJson(mockEmployeeDtosEmpty);
        });

        // Assert
        String expectedMessage = "EmployeeDto's can't be empty";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

//    @Test
//    @DisplayName("Should throw exception: Problem with processing json")
//    void testJavaToJson_Exception_WhenJsonProcessingException() {
//        // Arrange
//        List<EmployeeDto> employeeDtosInvalid = List.of(new EmployeeDto());
//
//
//        // Act
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            EmployeeService.javaToJson(employeeDtosInvalid);
//        });
//
//        // Assert
//        String expectedMessage = "Problem with processing json: ";
//        String actualmessage = exception.getMessage();
//
//        assertTrue(actualmessage.contains(expectedMessage), "Expected message should contain actual message");
//    }
}
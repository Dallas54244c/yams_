package proba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloResourceTest {

    @Test
    public void testHello() {
        // Arrange
        HelloResource helloResource = new HelloResource();
        String expectedResponse = "Hello, World!";

        // Act
        String actualResponse = helloResource.hello();

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }
}


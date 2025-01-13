package nl.mesander.exceptions;

// Imports
import java.io.Serial;

public class IllegalArgumentException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public IllegalArgumentException() {}

    public IllegalArgumentException(String message) {
        super(message);
    }
}

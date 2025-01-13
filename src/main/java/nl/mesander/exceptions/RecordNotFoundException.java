package nl.mesander.exceptions;

// Imports
import java.io.Serial;

public class RecordNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {}

    public RecordNotFoundException(String message) {
        super(message);
    }
}

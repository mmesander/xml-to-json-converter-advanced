package nl.mesander.helpers;

// imports
import org.springframework.beans.BeanUtils;

public class CopyProperties {
    public static <Input, Output> void copyProperties(Input source, Output destination) {
        BeanUtils.copyProperties(source, destination);
    }
}

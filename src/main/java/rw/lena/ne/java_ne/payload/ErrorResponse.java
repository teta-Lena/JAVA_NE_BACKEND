package rw.lena.ne.java_ne.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private final boolean success = false;
    private String message;
    private Object info;
}

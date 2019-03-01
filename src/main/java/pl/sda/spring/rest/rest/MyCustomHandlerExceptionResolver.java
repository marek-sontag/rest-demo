package pl.sda.spring.rest.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyCustomHandlerExceptionResolver extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(RuntimeException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(createErrorBody());
    }

    private Object createErrorBody() {
        return "This is an error body";
    }
}

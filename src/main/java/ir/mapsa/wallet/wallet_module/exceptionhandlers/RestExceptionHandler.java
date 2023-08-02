package ir.mapsa.wallet.wallet_module.exceptionhandlers;

import ir.mapsa.wallet.wallet_module.exceptionhandlers.exceptions.ExceptionResponse;
import ir.mapsa.wallet.wallet_module.exceptionhandlers.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.InaccessibleObjectException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionResponse> getException(SQLIntegrityConstraintViolationException exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage(exception.getMessage() + " " + "You have entered invalid Id");
        return ResponseEntity.internalServerError().body(exceptionResponse);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(ServiceException serviceException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage(serviceException.getErrorCode());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(MethodArgumentNotValidException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        FieldError fieldError = exception.getBindingResult().getFieldError();
        String message =
                "Error in field : " + fieldError.getField() + " " + fieldError.getDefaultMessage();
        exceptionResponse.setMessage(message);
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(NullPointerException exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage("Wallet not found");
        return ResponseEntity.internalServerError().body(exceptionResponse);
    }

//    @ExceptionHandler(InaccessibleObjectException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ExceptionResponse> getException(InaccessibleObjectException exception) {
//
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setError(true);
//        exceptionResponse.setMessage("wallet not found");
//        return ResponseEntity.internalServerError().body(exceptionResponse);
//    }
}

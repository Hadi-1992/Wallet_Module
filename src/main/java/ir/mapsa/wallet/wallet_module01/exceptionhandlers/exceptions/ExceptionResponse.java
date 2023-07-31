package ir.mapsa.wallet.wallet_module01.exceptionhandlers.exceptions;

import lombok.Data;

@Data
public class ExceptionResponse {
    private String message;
    private Boolean error;
}

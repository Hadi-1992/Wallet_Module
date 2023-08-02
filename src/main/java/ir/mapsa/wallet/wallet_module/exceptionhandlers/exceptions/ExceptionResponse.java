package ir.mapsa.wallet.wallet_module.exceptionhandlers.exceptions;

import lombok.Data;

@Data
public class ExceptionResponse {
    private String message;
    private Boolean error;
}

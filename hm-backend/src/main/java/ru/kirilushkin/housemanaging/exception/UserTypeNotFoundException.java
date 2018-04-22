package ru.kirilushkin.housemanaging.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserTypeNotFoundException extends RuntimeException{
    public UserTypeNotFoundException() {
    }

    public UserTypeNotFoundException(String message) {
        super(message);
    }

    public UserTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserTypeNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

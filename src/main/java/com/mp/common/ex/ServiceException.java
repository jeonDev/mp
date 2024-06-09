package com.mp.common.ex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private final String code;
    private final String message;

    public ServiceException(ServiceError serviceError) {
        this.code = serviceError.getErrorCode();
        this.message = serviceError.getErrorMessage();
    }
}

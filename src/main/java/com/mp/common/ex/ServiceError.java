package com.mp.common.ex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceError {
    LOGIN_PASSWORD_PATTERN_FAIL("90081", "Password Pattern unMatch"),
    LOGIN_ID_NOT_EXISTS("90091", "No Exists Id"),
    LOGIN_PASSWORD_FAIL("90092", "Login Password unMatch");

    private final String errorCode;
    private final String errorMessage;

}

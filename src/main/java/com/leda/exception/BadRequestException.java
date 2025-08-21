package com.leda.exception;

import com.leda.exception.base.BaseException;

public class BadRequestException extends BaseException {
    public BadRequestException(String message) {
        super("400", message);
    }

}

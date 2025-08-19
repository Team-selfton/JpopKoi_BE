package com.example.jpopkoi_server.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JpopKoiException extends RuntimeException {
    private final ErrorCode errorCode;
}

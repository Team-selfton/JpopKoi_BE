package com.example.jpopkoi_server.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    //presentation
    PRESENTATION_NOT_FOUND(404, "PRENTATION NOT FOUND"),

    //material
    MATERIAL_NOT_FOUND(404, "MATERIAL NOT FOUND"),

    // general
    BAD_REQUEST(400, "프론트 탓"),
    INTERNAL_SERVER_ERROR(500, "서버 탓");


    private final int statusCode;
    private final String ErrorMessage;
}

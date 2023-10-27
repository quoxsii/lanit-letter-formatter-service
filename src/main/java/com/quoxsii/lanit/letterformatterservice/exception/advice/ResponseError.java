package com.quoxsii.lanit.letterformatterservice.exception.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quoxsii.lanit.letterformatterservice.util.DateTimeUtil;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ResponseError {

    private final Integer status;

    private final String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime time = DateTimeUtil.getCurrentTimeInUTC();

    public ResponseError(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }

}

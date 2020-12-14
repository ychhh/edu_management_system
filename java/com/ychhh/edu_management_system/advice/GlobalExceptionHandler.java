package com.ychhh.edu_management_system.advice;

import com.ychhh.edu_management_system.utils.ResponseException;
import com.ychhh.edu_management_system.utils.ResponseMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = ResponseException.class)
    public ResponseMessage handle(ResponseException e) {
        if (e.getReason() != null) {
            return ResponseMessage.fail(e.getReason());
        }
        return ResponseMessage.fail(e.getMessage());
    }
}

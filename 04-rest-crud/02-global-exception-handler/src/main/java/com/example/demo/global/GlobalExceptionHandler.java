package com.example.demo.global;

import com.example.demo.student.exception.StudentErrorResponse;
import com.example.demo.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 타입 명시 안하면 모든 exception을 받을 수 있음
    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity<StudentErrorResponse> handleStudentNotFound(StudentNotFoundException exception) {
        // 에러 응답 메시지 생성
        var error = new StudentErrorResponse();
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());

        // 에러 응답을 http response에 대한 래퍼 객체인 ResponseEntity에 담아 보낸다.
        // return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    // 모든 종류의 에러를 잡는 핸들러 추가. Exception으로 설정해서 모든 에러를 다 잡을 수 있음.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllException(Exception exception) {
        // 에러 응답 메시지 생성
        var error = new StudentErrorResponse();
        error.setMessage(exception.getMessage()); // 좀 더 유저 친화적인 에러 메시지를 전달할 수도 있음.
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());

        // 에러 응답을 http response에 대한 래퍼 객체인 ResponseEntity에 담아 보낸다.
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}

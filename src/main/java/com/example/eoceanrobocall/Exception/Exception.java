package com.example.eoceanrobocall.Exception;

import org.springframework.http.HttpStatus;

public class Exception extends RuntimeException {
  HttpStatus status;
  public Exception(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }

  public HttpStatus getStatus() {
    return status;
  }
}

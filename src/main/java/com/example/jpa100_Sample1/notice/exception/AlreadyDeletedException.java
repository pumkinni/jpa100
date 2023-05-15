package com.example.jpa100_Sample1.notice.exception;

public class AlreadyDeletedException extends RuntimeException {

  public AlreadyDeletedException(String message) {
    super(message);
  }
}

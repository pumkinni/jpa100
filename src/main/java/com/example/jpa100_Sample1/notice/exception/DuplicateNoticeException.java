package com.example.jpa100_Sample1.notice.exception;

public class DuplicateNoticeException extends RuntimeException{

  public DuplicateNoticeException(String message) {
    super(message);
  }
}

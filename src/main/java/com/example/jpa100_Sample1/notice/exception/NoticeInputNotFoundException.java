package com.example.jpa100_Sample1.notice.exception;

public class NoticeInputNotFoundException extends
    RuntimeException {

  public NoticeInputNotFoundException(String message) {
    super(message);
  }
}

package com.example.jpa100_Sample1.notice.exception;

public class NoticeNotFoundException extends RuntimeException {

  public NoticeNotFoundException(String message) {
    super(message);
  }
}

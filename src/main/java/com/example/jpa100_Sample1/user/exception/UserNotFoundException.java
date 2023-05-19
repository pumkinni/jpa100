package com.example.jpa100_Sample1.user.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message){
    super(message);
  }

}

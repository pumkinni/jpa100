package com.example.jpa100_Sample1.notice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseError {

  private String field;
  private String message;

  public static ResponseError of(FieldError e) {
    return ResponseError.builder()
        .field(e.getField())
        .message(e.getDefaultMessage())
        .build();
  }
}

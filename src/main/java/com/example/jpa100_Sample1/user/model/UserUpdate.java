package com.example.jpa100_Sample1.user.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserUpdate {

  @Size(max = 20, message = "연락처는 최대 20자까지 입력해야 합니다.")
  @NotBlank(message = "연락처는 필수 항목 입니다.")
  private String phone;

}

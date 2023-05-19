package com.example.jpa100_Sample1.notice.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NoticeInput {

  //제목, 내용
  @Max(value = 100, message = "제목은 100자 이하 입니다.")
  @Min(value = 10, message = "제목은 10자 이상 입니다.")
  @Size(min=10, max = 100, message = "제목은 10-100자 사이의 값입니다.")
  @NotBlank(message="제목은 필수 항목입니다.")
  private String title;
  @NotBlank(message="내용은 필수 항목입니다.")
  private String contents;
}

package com.example.jpa100_Sample1.notice.model;

import javax.validation.constraints.NotBlank;
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
  @NotBlank(message="제목은 필수 항목입니다.")
  private String title;
  @NotBlank(message="내용은 필수 항목입니다.")
  private String contents;
}

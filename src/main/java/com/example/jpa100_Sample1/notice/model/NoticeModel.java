package com.example.jpa100_Sample1.notice.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeModel {

  //ID, 제목, 내용, 등록일(작성일)

  private int id;
  private String title;
  private String contents;
  private LocalDateTime regDate;
}

package com.example.jpa100_Sample1.notice.controller;

import com.example.jpa100_Sample1.notice.model.NoticeModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

  // 6번
  /*
  @GetMapping("/api/notice")
  public String notice() {
    return "공지사항입니다.";
  }
   */

  // 7번
  /*
  @GetMapping("/api/notice")
  public NoticeModel notice(){
    NoticeModel notice = new NoticeModel();
    notice.setId(1);
    notice.setTitle("공지사항 입니다.");
    notice.setContents("공지사항 내용입니다.");
    notice.setRegDate(LocalDateTime.now());
    return notice;
  }

   */

  // 8번
  /*
  @GetMapping("/api/notice")
  public List<NoticeModel> notice(){
    List<NoticeModel> notices = new ArrayList<>();

    NoticeModel notice1 = new NoticeModel();
    notice1.setId(1);
    notice1.setTitle("공지사항입니다.");
    notice1.setContents("공지사항내용입니다.");
    notice1.setRegDate(LocalDateTime.now());

    notices.add(notice1);

    NoticeModel notice2 = new NoticeModel();
    notice2.setId(2);
    notice2.setTitle("두번째 공지사항입니다.");
    notice2.setContents("두번째 공지사항 내용입니다.");
    notice2.setRegDate(LocalDateTime.now());

    notices.add(notice2);

    return notices;
  }


   */


  /* 9번
  @GetMapping("/api/notice")
  public List<NoticeModel> notice(){

    List<NoticeModel> notices = new ArrayList<>();


    return notices;
  }

  */


  @GetMapping("/api/notice/count")
  public int noticeCount() {
    List<NoticeModel> notices = new ArrayList<>();
    notices.add(NoticeModel.builder().build());
    notices.add(NoticeModel.builder().build());
    notices.add(NoticeModel.builder().build());

    return notices.size();
  }


}

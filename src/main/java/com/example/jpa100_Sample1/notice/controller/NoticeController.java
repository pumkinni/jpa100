package com.example.jpa100_Sample1.notice.controller;

import com.example.jpa100_Sample1.notice.Entity.Notice;
import com.example.jpa100_Sample1.notice.model.NoticeInput;
import com.example.jpa100_Sample1.notice.model.NoticeModel;
import com.example.jpa100_Sample1.notice.repository.NoticeRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NoticeController {

  private final NoticeRepository noticeRepository;



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


  /* 10번
  @GetMapping("/api/notice/count")
  public int noticeCount() {
    List<NoticeModel> notices = new ArrayList<>();
    notices.add(NoticeModel.builder().build());
    notices.add(NoticeModel.builder().build());
    notices.add(NoticeModel.builder().build());

    return notices.size();
  }

   */

  /*11번
  @PostMapping("/api/notice")
  public NoticeModel addNotice(@RequestParam String title, @RequestParam String contents){
    NoticeModel notice = NoticeModel.builder()
        .id(1)
        .title(title)
        .contents(contents)
        .regDate(LocalDateTime.now())
        .build();

    return notice;
  }

   */

 /* 12번
 @PostMapping("/api/notice")
  public NoticeModel addNotice(NoticeModel noticeModel) {

    noticeModel.setId(2);
    noticeModel.setRegDate(LocalDateTime.now());

    return noticeModel;
  }*/


/*  13번
@PostMapping("/api/notice")
  public NoticeModel addNotice(@RequestBody NoticeModel noticeModel){

    noticeModel.setId(3);
    noticeModel.setRegDate(LocalDateTime.now());

    return noticeModel;
  }*/


/*  14번
  @PostMapping("/api/notice")
  public Notice addNotice(@RequestBody NoticeInput noticeInput){

    Notice notice = Notice.builder()
        .title(noticeInput.getTitle())
        .contents(noticeInput.getContents())
        .regDate(LocalDateTime.now())
        .build();

    noticeRepository.save(notice);

    return notice;
  }*/




/*  15번
  @PostMapping("/api/notice")
  public Notice addNotice(@RequestBody NoticeInput noticeInput){

    Notice notice = Notice.builder()
        .title(noticeInput.getTitle())
        .contents(noticeInput.getContents())
        .regDate(LocalDateTime.now())
        .hits(0)
        .likes(0)
        .build();

    Notice resultNotice = noticeRepository.save(notice);

    return resultNotice;

  }*/




}

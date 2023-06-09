package com.example.jpa100_Sample1.notice.controller;

import com.example.jpa100_Sample1.notice.Entity.Notice;
import com.example.jpa100_Sample1.notice.exception.AlreadyDeletedException;
import com.example.jpa100_Sample1.notice.exception.DuplicateNoticeException;
import com.example.jpa100_Sample1.notice.exception.NoticeInputNotFoundException;
import com.example.jpa100_Sample1.notice.exception.NoticeNotFoundException;
import com.example.jpa100_Sample1.notice.model.NoticeInput;
import com.example.jpa100_Sample1.notice.repository.NoticeRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  // 16번
  @GetMapping("/api/notice/{id}")
  public Notice notice(@PathVariable Long id) {
    Optional<Notice> notice = noticeRepository.findById(id);

    // 가져온 데이터 검증
    if (notice.isPresent()) {
      return notice.get();
    }

    return null;
  }

/*  17번
  @PutMapping("/api/notice/{id}")
  public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput) {
    Optional<Notice> notice = noticeRepository.findById(id);

    if (notice.isPresent()){
      notice.get().setTitle(noticeInput.getTitle());

      notice.get().setContents(noticeInput.getContents());
      notice.get().setUpdateDate(LocalDateTime.now());
      noticeRepository.save(notice.get());
    }
  }*/

  // 에러 처리


  @ExceptionHandler(NoticeNotFoundException.class)
  public ResponseEntity<String> handlerNoticeNotFoundException(NoticeNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

/* 18, 19 번
  @PutMapping("/api/notice/{id}")
  public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput){
//    Optional<Notice> notice = noticeRepository.findById(id);
//
//    if (notice.isPresent()){
//      notice.get().setTitle(noticeInput.getTitle());
//      notice.get().setContents(noticeInput.getContents());
//      notice.get().setUpdateDate(LocalDateTime.now());
//      noticeRepository.save(notice.get());
//    } else {
//      throw new NoticeNoteFoundException("공지사항의 글이 존재하지 않습니다.");
//    }

    Notice notice = noticeRepository.findById(id)
        .orElseThrow(() -> new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));

    notice.setTitle(noticeInput.getTitle());
    notice.setContents(noticeInput.getContents());
    notice.setUpdateDate(LocalDateTime.now());
    noticeRepository.save(notice);

  }
*/


/* 20번

  @PatchMapping("/api/notice/{id}/hits")
  public void noticeHits(@PathVariable Long id) {

    Notice notice = noticeRepository.findById(id).orElseThrow(() -> new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));

    notice.setHits(notice.getHits() + 1);

    noticeRepository.save(notice);
  }
*/


  /* 21번
  @DeleteMapping("/api/notice/{id}")
  public void deleteNotice(@PathVariable Long id) {
    Optional<Notice> notice = noticeRepository.findById(id);

    if (notice.isPresent()) {
      noticeRepository.delete(notice.get());
    }
  }
   */


  /* 22번
  @DeleteMapping("/api/notice/{id}")
  public void deleteNotice(@PathVariable Long id) {
    Notice notice = noticeRepository.findById(id)
        .orElseThrow(() -> new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));

    noticeRepository.delete(notice);
  }

   */

  @ExceptionHandler(AlreadyDeletedException.class)
  public ResponseEntity<String> handlerAlreadyDeletedException(AlreadyDeletedException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
  }

  /*23번
  @DeleteMapping("/api/notice/{id}")
  public void deleteNotice(@PathVariable Long id) {
    Notice notice = noticeRepository.findById(id)
        .orElseThrow(() -> new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));

    if (notice.getDeleted()) {
      throw new AlreadyDeletedException("이미 삭제된 글입니다.");
    }

    notice.setDeleted(true);
    notice.setDeletedDate(LocalDateTime.now());

    noticeRepository.save(notice);
  }

   */


  /* 24번
  @DeleteMapping("/api/notice")
  public void deleteNoticeList(@RequestBody NoticeDeleteInput noticeDeleteInput) {

    List<Notice> noticeList = noticeRepository.findByIdIn(noticeDeleteInput.getIdList())
        .orElseThrow(() -> new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));

    noticeList.stream().forEach(e -> {
      e.setDeleted(true);
      e.setDeletedDate(LocalDateTime.now());
    });

    noticeRepository.saveAll(noticeList);

  }


   */

  // 25번
  @DeleteMapping("/api/delete/all")
  public void deleteAll() {
    noticeRepository.deleteAll();
  }

/* 26번
  @PostMapping("/api/notice")
  public void addNotice(@RequestBody NoticeInput noticeInput){

    if (noticeInput.getTitle() == null || noticeInput.getTitle().equals("")
        || noticeInput.getContents() == null || noticeInput.getContents().equals("")){
      throw new NoticeInputNotFoundException("입력된 내용 중 제목과 내용을 확인해 주세요!");
    }
    Notice notice = Notice.builder()
        .title(noticeInput.getTitle())
        .contents(noticeInput.getContents())
        .regDate(LocalDateTime.now())
        .hits(0)
        .likes(0)
        .build();

    noticeRepository.save(notice);

  }*/


  @ExceptionHandler(NoticeInputNotFoundException.class)
  public ResponseEntity<String> handlerNoticeInputNotFoundException(
      NoticeInputNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

  /* 27-1 번
  @PostMapping("/api/notice")
  public void addNotice(@RequestBody NoticeInput noticeInput) {

    if (noticeInput.getTitle() == null || noticeInput.getTitle().equals("")
        || noticeInput.getContents() == null || noticeInput.getContents().equals("")) {
      throw new NoticeInputNotFoundException("입력된 내용 중 제목과 내용을 확인해 주세요!");
    }
    Notice notice = Notice.builder()
        .title(noticeInput.getTitle())
        .contents(noticeInput.getContents())
        .regDate(LocalDateTime.now())
        .hits(0)
        .likes(0)
        .build();

    noticeRepository.save(notice);

  }*/

/*
  @PostMapping("/api/notice")
  public ResponseEntity<Object> addNotice(@RequestBody @Valid NoticeInput noticeInput
      , Errors errors) {

    if (errors.hasErrors()) {

      List<ResponseError> responseErrors = new ArrayList<>();

      errors.getAllErrors().stream().forEach(e -> {
        responseErrors.add(ResponseError.of((FieldError) e));
      });

      return new ResponseEntity<>(responseErrors, HttpStatus.BAD_REQUEST);

    }

    Notice notice = Notice.builder()
        .title(noticeInput.getTitle())
        .contents(noticeInput.getContents())
        .regDate(LocalDateTime.now())
        .hits(0)
        .likes(0)
        .build();

    noticeRepository.save(notice);

    return ResponseEntity.ok().build();
  }*/


/*
  // 28번
  @PostMapping("/api/notice")
  public ResponseEntity<Object> addNotice(@RequestBody @Valid NoticeInput noticeInput
      , Errors errors) {

    if (errors.hasErrors()) {

      List<ResponseError> responseErrors = new ArrayList<>();

      errors.getAllErrors().stream().forEach(e -> {
        responseErrors.add(ResponseError.of((FieldError) e));
      });

      return new ResponseEntity<>(responseErrors, HttpStatus.BAD_REQUEST);
    }

    Notice notice = Notice.builder()
        .title(noticeInput.getTitle())
        .contents(noticeInput.getContents())
        .regDate(LocalDateTime.now())
        .hits(0)
        .likes(0)
        .build();

    noticeRepository.save(notice);

    return ResponseEntity.ok().build();
  }

*/


  //29번
  @GetMapping("/api/notice/latest/{page}")
  public Page<Notice> pageNotice(@PathVariable int page) {
    Page<Notice> noticeList = noticeRepository.findAll(
        PageRequest.of(0, page, Sort.by("regDate").descending()));

    return noticeList;
  }


  @ExceptionHandler(DuplicateNoticeException.class)
  public ResponseEntity<?> handlerDuplicationNoticeException(DuplicateNoticeException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }


  @PostMapping("/api/notice")
  public ResponseEntity<Object> addNotice(@RequestBody NoticeInput noticeInput) {

//    Optional<List<Notice>> noticeList =
//    noticeRepository.findAllByTitleAndContentsAndRegDateGreaterThanEqual(noticeInput.getTitle(), noticeInput.getContents(), LocalDateTime.now().minusMinutes(1));
//
//    if (noticeList.isPresent()){
//      if (noticeList.get().size() > 0){
//        throw new DuplicateNoticeException("1분이내에 동일한 내용의 공지사항이 등록되었습니다.");
//      }
//    }

    int noticeCount = noticeRepository.countByTitleAndContentsAndRegDateIsGreaterThanEqual(
        noticeInput.getTitle(),
        noticeInput.getContents(), LocalDateTime.now().minusMinutes(1));

    if (noticeCount > 0){
      throw new DuplicateNoticeException("1분 이내에 동일한 내용의 공지사항이 등록되었습니다.");
    }

    Notice notice = Notice.builder()
        .title(noticeInput.getTitle())
        .contents(noticeInput.getContents())
        .regDate(LocalDateTime.now())
        .hits(0)
        .likes(0)
        .build();

    noticeRepository.save(notice);

    return ResponseEntity.ok().build();
  }
}

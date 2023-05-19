package com.example.jpa100_Sample1.user.controller;


import com.example.jpa100_Sample1.notice.Entity.Notice;
import com.example.jpa100_Sample1.notice.model.ResponseError;
import com.example.jpa100_Sample1.notice.repository.NoticeRepository;
import com.example.jpa100_Sample1.user.entity.UserEntity;
import com.example.jpa100_Sample1.user.exception.UserNotFoundException;
import com.example.jpa100_Sample1.user.model.NoticeResponse;
import com.example.jpa100_Sample1.user.model.UserInput;
import com.example.jpa100_Sample1.user.model.UserResponse;
import com.example.jpa100_Sample1.user.model.UserUpdate;
import com.example.jpa100_Sample1.user.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiUserController {

  private final UserRepository userRepository;
  private final NoticeRepository noticeRepository;

  /*
  // 31번
  @PostMapping("/api/user")
  public ResponseEntity<?> addUser(@RequestBody @Valid UserInput userInput, Errors errors) {

    List<ResponseError> responseErrorList = new ArrayList<>();
    if (errors.hasErrors()) {
      errors.getAllErrors().forEach((e) -> {
        responseErrorList.add(ResponseError.of((FieldError) e));
      });

      return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
    }

    return ResponseEntity.ok().build();
  }

   */


  // 32번
  @PostMapping("/api/user")
  public ResponseEntity<?> addUser(@RequestBody @Valid UserInput userInput, Errors errors) {

    List<ResponseError> responseErrorList = new ArrayList<>();
    if (errors.hasErrors()) {
      errors.getAllErrors().forEach((e) -> {
        responseErrorList.add(ResponseError.of((FieldError) e));
      });
      return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
    }

    UserEntity user = UserEntity.builder()
        .email(userInput.getEmail())
        .userName(userInput.getUserName())
        .password(userInput.getPassword())
        .phone(userInput.getPhone())
        .regDate(LocalDateTime.now())
        .build();

    userRepository.save(user);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/api/user/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody @Valid UserUpdate userUpdate, Errors errors) {

    List<ResponseError> responseErrorList = new ArrayList<>();

    if (errors.hasErrors()) {
      errors.getAllErrors().forEach((e) -> {
        responseErrorList.add(ResponseError.of((FieldError) e));
      });
      return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
    }

    UserEntity user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));

    user.setPhone(userUpdate.getPhone());
    user.setUpdateDate(LocalDateTime.now());
    userRepository.save(user);

    return ResponseEntity.ok().build();
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<?> UserNotFoundExceptionHandler(UserNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/api/user/{id}")
  public UserResponse getUser(@PathVariable Long id){
    UserEntity user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));

//    UserResponse userResponse = new UserResponse(user);
    UserResponse userResponse = UserResponse.of(user);
    return userResponse;
  }

  @GetMapping("/api/user/{id}/notice")
  public List<NoticeResponse> userNotice(@PathVariable Long id) {
    UserEntity user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));

    List<Notice> noticeList = noticeRepository.findByUser(user);

    List<NoticeResponse> noticeResponseList = new ArrayList<>();

    noticeList.stream().forEach(e -> noticeResponseList.add(NoticeResponse.of(e)));

    return noticeResponseList;
  }


}

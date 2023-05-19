package com.example.jpa100_Sample1.user.model;


import com.example.jpa100_Sample1.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

  private long id;
  private String email;
  private String userName;
  private String phone;

//  public UserResponse(UserEntity user){
//    this.id = user.getId();
//    this.email = user.getEmail();
//    this.userName = user.getUserName();
//    this.phone = user.getPhone();
//  }

  public static UserResponse of(UserEntity user) {
    return UserResponse.builder()
        .id(user.getId())
        .userName(user.getUserName())
        .phone(user.getPhone())
        .email(user.getEmail())
        .build();
  }
}

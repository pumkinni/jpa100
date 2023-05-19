package com.example.jpa100_Sample1.notice.Entity;

import com.example.jpa100_Sample1.user.entity.UserEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn
  private UserEntity user;

  @Column
  private String title;

  @Column
  private String contents;

  @Column
  private LocalDateTime regDate;

  @Column
  private LocalDateTime updateDate;

  @Column
  private int hits;

  @Column
  private int likes;

  @Column
  private Boolean deleted;

  @Column
  private LocalDateTime deletedDate;

}

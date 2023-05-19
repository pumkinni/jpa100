package com.example.jpa100_Sample1.notice.repository;

import com.example.jpa100_Sample1.notice.Entity.Notice;
import com.example.jpa100_Sample1.user.entity.UserEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

  Optional<List<Notice>> findByIdIn(List<Long> idList);

  Optional<List<Notice>> findAllByTitleAndContentsAndRegDateGreaterThanEqual(String title,
      String contents, LocalDateTime regDate);

  int countByTitleAndContentsAndRegDateIsGreaterThanEqual(String title, String contents,
      LocalDateTime regDate);

  List<Notice> findByUser(UserEntity user);


}

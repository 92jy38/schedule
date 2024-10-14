package com.sparta.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    private Long id;                   // 고유 식별자 (Primary Key)
    private String contents;           // 할일 내용
    private String name;               // 작성자
    private String password;           // 비밀번호
    private LocalDateTime createdDate; // 작성일 (생성 시 자동 설정)
    private LocalDateTime updatedDate;  // 수정일 (수정 시 갱신)
}

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

    // 기본 생성자
//    public Schedule() {}

    // 모든 필드를 포함하는 생성자
//    public Schedule(Long id, String contents, String name, String password, LocalDateTime createdDate, LocalDateTime updatedDate) {
//        this.id = id;
//        this.contents = contents;
//        this.name = name;
//        this.password = password;
//        this.createdDate = createdDate;
//        this.updatedDate = updated;
//    }

    // Getter and Setter 메서드 주석처리
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getContents() { return contents; }
//    public void setContents(String contents) { this.contents = contents; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public LocalDateTime getCreatedDate() { return createdDate; }
//    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
//
//    public LocalDateTime getUpdatedDate() { return updatedDate; }
//    public void setUpdatedDate(LocalDateTime updatedDate) { this.updatedDate = updatedDate; }
}

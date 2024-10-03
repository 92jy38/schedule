// entity/Schedule.java
package com.sparta.schedule.entity;

import java.time.LocalDateTime;

/**
 * Schedule 엔티티 클래스는 일정의 기본 구조를 정의합니다.
 * 이 클래스는 데이터베이스 테이블과 매핑됩니다.
 */
public class Schedule {

    private Long id;                  // 고유 식별자 (Primary Key)
    private String contents;          // 일정 내용
    private String name;              // 작성자 이름
    private String password;          // 비밀번호
    private LocalDateTime createdDate; // 작성일 (생성 시 자동 설정)
    private LocalDateTime update;      // 수정일 (수정 시 갱신)

    // 기본 생성자
    public Schedule() {}

    // 모든 필드를 포함하는 생성자
    public Schedule(Long id, String contents, String name, String password, LocalDateTime createdDate, LocalDateTime update) {
        this.id = id;
        this.contents = contents;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
        this.update = update;
    }

    // Getter and Setter 메서드
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContents() { return contents; }
    public void setContents(String contents) { this.contents = contents; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public LocalDateTime getUpdate() { return update; }
    public void setUpdate(LocalDateTime update) { this.update = update; }
}

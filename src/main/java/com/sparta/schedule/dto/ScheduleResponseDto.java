package com.sparta.schedule.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ScheduleResponseDto {

    // Getter and Setter 메서드
    private Long id;                  // 일정 ID
    private String contents;          // 일정 내용
    private String name;              // 작성자 이름
    private LocalDateTime createdDate; // 작성일
    private LocalDateTime update;      // 수정일

    // 기본 생성자
    public ScheduleResponseDto() {}

    // 모든 필드를 포함하는 생성자
    public ScheduleResponseDto(Long id, String contents, String name, LocalDateTime createdDate, LocalDateTime update) {
        this.id = id;
        this.contents = contents;
        this.name = name;
        this.createdDate = createdDate;
        this.update = update;
    }

}
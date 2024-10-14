package com.sparta.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {

    // Getter and Setter 메서드
    private Long id;                   // 할일 ID
    private String contents;           // 할일 내용
    private String name;               // 작성자
    private LocalDateTime createdDate; // 작성일
    private LocalDateTime updatedDate;      // 수정일
}


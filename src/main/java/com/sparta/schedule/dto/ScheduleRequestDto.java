package com.sparta.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ScheduleRequestDto {

    // Getter and Setter 메서드
    private String contents;    // 할일
    private String name;        // 작성자
    private String password;    // 비밀번호

}
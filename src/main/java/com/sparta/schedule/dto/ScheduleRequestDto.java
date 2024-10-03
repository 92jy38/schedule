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

    // 기본 생성자
    // @NoArgsConstructor 처리
//    public ScheduleRequestDto() {}

    // 모든 필드를 포함하는 생성자
    // @AllArgsConstructor 처리
//    public ScheduleRequestDto(String contents, String name, String password) {
//        this.contents = contents;
//        this.name = name;
//        this.password = password;
//    }

}
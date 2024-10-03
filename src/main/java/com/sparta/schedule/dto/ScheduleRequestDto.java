package com.sparta.schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ScheduleRequestDto {

    // Getter and Setter 메서드
    private String contents;    // 내용
    private String name;        // 작성자 이름
    private String password;    // 비밀번호

    // 기본 생성자
    public ScheduleRequestDto() {}

    // 모든 필드를 포함하는 생성자
    public ScheduleRequestDto(String contents, String name, String password) {
        this.contents = contents;
        this.name = name;
        this.password = password;
    }

}
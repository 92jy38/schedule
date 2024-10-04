package com.sparta.schedule.controller;

import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 생성
    @PostMapping("")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {
        return scheduleService.createSchedule(dto);
    }

    // 전체 일정 조회 (필터 조건에 따라)
    @GetMapping("")
    public List<ScheduleResponseDto> getAllSchedules(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String updatedDate) {
        return scheduleService.getAllSchedules(name, updatedDate);
    }

    // 일정 ID로 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto getScheduleById(@PathVariable("id") Long id) {
        return scheduleService.getScheduleById(id);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ScheduleResponseDto updateSchedule(@PathVariable("id") Long id, @RequestBody ScheduleRequestDto dto) {
        return scheduleService.updateSchedule(id, dto);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable("id") Long id, @RequestParam String password) {
        scheduleService.deleteSchedule(id, password);
    }
}
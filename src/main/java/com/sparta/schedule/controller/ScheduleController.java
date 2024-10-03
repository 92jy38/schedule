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
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {
        return scheduleService.createSchedule(dto);
    }

    // 전체 일정 조회
    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    // 일정 ID로 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        return scheduleService.updateSchedule(id, dto);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id, @RequestParam String password) {
        scheduleService.deleteSchedule(id, password);
    }
}
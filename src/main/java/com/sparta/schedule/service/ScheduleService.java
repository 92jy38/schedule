package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 일정 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto dto) {
        LocalDateTime now = LocalDateTime.now();
        Schedule schedule = new Schedule(null, dto.getContents(), dto.getName(), dto.getPassword(), now, now);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule.getId(), schedule.getContents(), schedule.getName(), schedule.getCreatedDate(), schedule.getUpdate());
    }

    // 전체 일정 조회
    public List<ScheduleResponseDto> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream()
                .map(schedule -> new ScheduleResponseDto(schedule.getId(), schedule.getContents(), schedule.getName(), schedule.getCreatedDate(), schedule.getUpdate()))
                .collect(Collectors.toList());
    }

    // 일정 ID로 조회
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        return new ScheduleResponseDto(schedule.getId(), schedule.getContents(), schedule.getName(), schedule.getCreatedDate(), schedule.getUpdate());
    }

    // 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id);
        schedule.setContents(dto.getContents());
        schedule.setName(dto.getName());
        schedule.setUpdate(LocalDateTime.now());
        scheduleRepository.update(schedule);
        return new ScheduleResponseDto(schedule.getId(), schedule.getContents(), schedule.getName(), schedule.getCreatedDate(), schedule.getUpdate());
    }

    // 일정 삭제
    public void deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id);
        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        scheduleRepository.delete(id);
    }
}
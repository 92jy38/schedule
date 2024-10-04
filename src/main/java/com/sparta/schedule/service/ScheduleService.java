package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return new ScheduleResponseDto(schedule.getId(), schedule.getContents(), schedule.getName(), schedule.getCreatedDate(), schedule.getUpdatedDate());
    }

    // 필터 조건에 따른 전체 일정 조회
    public List<ScheduleResponseDto> getAllSchedules(String name, String updatedDate) {
        List<Schedule> schedules;

        if (name != null && updatedDate != null) {
            // 1. 수정일 + 작성자명으로 조회
            schedules = scheduleRepository.findByUpdatedDateAndName(updatedDate, name);
        } else if (updatedDate != null) {
            // 2. 수정일로만 조회
            schedules = scheduleRepository.findByUpdatedDate(updatedDate);
        } else if (name != null) {
            // 3. 작성자명으로만 조회
            schedules = scheduleRepository.findByName(name);
        } else {
            // 4. 조건 없이 전체 조회
            schedules = scheduleRepository.findAll();
        }

        return schedules.stream()
                .map(schedule -> new ScheduleResponseDto(
                        schedule.getId(),
                        schedule.getContents(),
                        schedule.getName(),
                        schedule.getCreatedDate(),
                        schedule.getUpdatedDate()))
                .collect(Collectors.toList());
    }

    // 일정 ID로 조회
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        return new ScheduleResponseDto(schedule.getId(), schedule.getContents(), schedule.getName(), schedule.getCreatedDate(), schedule.getUpdatedDate());
    }

    // 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id);
        if (!schedule.getPassword().equals(dto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다");
        } //비밀번호 오류 검증
        schedule.setContents(dto.getContents());
        schedule.setName(dto.getName());
        schedule.setUpdatedDate(LocalDateTime.now());
        scheduleRepository.update(schedule);
        return new ScheduleResponseDto(schedule.getId(), schedule.getContents(), schedule.getName(), schedule.getCreatedDate(), schedule.getUpdatedDate());
    }

    // 일정 삭제
    public void deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id);
        if (!schedule.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다");
        } //비밀번호 오류 검증
        scheduleRepository.delete(id);
    }
}
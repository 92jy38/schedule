package com.sparta.schedule.repository;

import com.sparta.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 일정 생성
    public int save(Schedule schedule) {
        String sql = "INSERT INTO schedule (contents, name, password, created_date, update) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, schedule.getContents(), schedule.getName(), schedule.getPassword(),
                schedule.getCreatedDate(), schedule.getUpdate());
    }

    // 전체 일정 조회
    public List<Schedule> findAll() {
        String sql = "SELECT * FROM schedule ORDER BY update DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Schedule(
                rs.getLong("id"),
                rs.getString("contents"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getTimestamp("created_date").toLocalDateTime(),
                rs.getTimestamp("update").toLocalDateTime()
        ));
    }

    // 일정 ID로 단일 일정 조회
    public Schedule findById(Long id) {
        String sql = "SELECT * FROM schedule WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Schedule(
                rs.getLong("id"),
                rs.getString("contents"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getTimestamp("created_date").toLocalDateTime(),
                rs.getTimestamp("update").toLocalDateTime()
        ));
    }

    // 일정 수정
    public int update(Schedule schedule) {
        String sql = "UPDATE schedule SET contents = ?, name = ?, update = ? WHERE id = ?";
        return jdbcTemplate.update(sql, schedule.getContents(), schedule.getName(),
                schedule.getUpdate(), schedule.getId());
    }

    // 일정 삭제
    public int delete(Long id) {
        String sql = "DELETE FROM schedule WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
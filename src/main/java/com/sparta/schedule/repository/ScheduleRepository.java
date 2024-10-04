package com.sparta.schedule.repository;

import com.sparta.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 일정 생성
    public int save(Schedule schedule) {
        String sql = "INSERT INTO schedule (contents, name, password, created_date, updated_date) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, schedule.getContents(), schedule.getName(), schedule.getPassword(),
                schedule.getCreatedDate(), schedule.getUpdatedDate());
    }

    // 작성자명과 수정일로 조회
    public List<Schedule> findByUpdatedDateAndName(String updatedDate, String name) {
        String sql = "SELECT * FROM schedule WHERE updated_date = ? AND name = ?";
        return jdbcTemplate.query(sql, new Object[]{updatedDate, name}, (rs, rowNum) -> mapSchedule(rs));
    }

    // 수정일로만 조회
    public List<Schedule> findByUpdatedDate(String updatedDate) {
        String sql = "SELECT * FROM schedule WHERE updated_date = ?";
        return jdbcTemplate.query(sql, new Object[]{updatedDate}, (rs, rowNum) -> mapSchedule(rs));
    }

    // 작성자명으로만 조회
    public List<Schedule> findByName(String name) {
        String sql = "SELECT * FROM schedule WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, (rs, rowNum) -> mapSchedule(rs));
    }

    // 전체 조회
    public List<Schedule> findAll() {
        String sql = "SELECT * FROM schedule";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapSchedule(rs));
    }

    // Schedule 매핑
    private Schedule mapSchedule(ResultSet rs) throws SQLException {
        return new Schedule(
                rs.getLong("id"),
                rs.getString("contents"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getTimestamp("created_date").toLocalDateTime(),
                rs.getTimestamp("updated_date").toLocalDateTime()
        );
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
                rs.getTimestamp("updated_date").toLocalDateTime()
        ));
    }

    // 일정 수정
    public int update(Schedule schedule) {
        String sql = "UPDATE schedule SET contents = ?, name = ?, updated_date = ? WHERE id = ?";
        return jdbcTemplate.update(sql, schedule.getContents(), schedule.getName(),
                schedule.getUpdatedDate(), schedule.getId());
    }

    // 일정 삭제
    public int delete(Long id) {
        String sql = "DELETE FROM schedule WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
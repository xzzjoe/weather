package service;

import com.example.search.dto.StudentDTO;

import java.time.LocalDateTime;
import java.util.List;

public class GeneralResponse {
    private int code;
    private LocalDateTime timestamp;
    private String details;  // Additional details from the other service
    private List<StudentDTO> studentDTOList;  // List of student DTOs

    // Getters and Setters

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<StudentDTO> getStudentDTOList() {
        return studentDTOList;
    }

    public void setStudentDTOList(List<StudentDTO> studentDTOList) {
        this.studentDTOList = studentDTOList;
    }
}


package dto;

import java.util.Set;

public class StudentDTO {
    private String name;
    private int id;

    private Set<TeacherDTO> teachers;

    public StudentDTO(String name, int id, Set<TeacherDTO> teachers) {
        this.name = name;
        this.id = id;
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<TeacherDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherDTO> teachers) {
        this.teachers = teachers;
    }
}

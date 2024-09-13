package dto;

import java.util.Set;

public class TeacherDTO {
    private long id;
    private String name;
    private Set<StudentDTO> students;

    public TeacherDTO(long id, String name, Set<StudentDTO> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentDTO> students) {
        this.students = students;
    }
}

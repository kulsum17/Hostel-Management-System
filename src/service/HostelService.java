package service;

import dao.*;
import dto.HostelDTO;

import java.util.List;

public class HostelService {

    private HostelDAO dao = new HostelDAOImpl();

    public void addStudent(HostelDTO student) {

        if (student.getStudentName() == null ||
                student.getStudentName().isEmpty()) {

            System.out.println("Student name cannot be empty");
            return;
        }

        dao.addStudent(student);
    }

    public HostelDTO getStudent(int id) {
        return dao.getStudentById(id);
    }

    public List<HostelDTO> getAllStudents() {
        return dao.getAllStudents();
    }

    public void updateStudent(HostelDTO student) {
        dao.updateStudent(student);
    }

    public void deleteStudent(int id) {
        dao.deleteStudent(id);
    }
}

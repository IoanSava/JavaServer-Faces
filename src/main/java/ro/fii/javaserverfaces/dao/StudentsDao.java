package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.dtos.StudentDto;
import ro.fii.javaserverfaces.entities.Exam;
import ro.fii.javaserverfaces.entities.Student;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentsDao extends Dao<Student> {
    public List getAll() {
        return entityManager.createNamedQuery("Student.getAll").getResultList();
    }

    public Student getById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    public void create(StudentDto studentDto) {
        Student student = new Student(studentDto.getName());
        List<Exam> assignedExams = getListOfExamsForStudentDto(studentDto);
        student.addExams(assignedExams.toArray(new Exam[0]));

        entityManager.persist(student);
        entityManager.flush();
    }

    public void update(Integer id, StudentDto studentDto) {
        Student student = this.getById(id);
        student.setName(studentDto.getName());
        student.setAssignedExams(new ArrayList<>());
        List<Exam> assignedExams = getListOfExamsForStudentDto(studentDto);
        student.addExams(assignedExams.toArray(new Exam[0]));

        entityManager.merge(student);
        entityManager.flush();
    }

    private List<Exam> getListOfExamsForStudentDto(StudentDto studentDto) {
        List<Exam> exams = new ArrayList<>();

        String[] assignedExamIds = studentDto.getAssignedExams().split(",");
        for (String examId : assignedExamIds) {
            Exam exam = entityManager.find(Exam.class, Integer.parseInt(examId));
            exams.add(exam);
        }

        return exams;
    }
}

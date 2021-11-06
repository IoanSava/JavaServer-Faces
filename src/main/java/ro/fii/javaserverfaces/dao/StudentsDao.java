package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.dtos.StudentDto;
import ro.fii.javaserverfaces.entities.Exam;
import ro.fii.javaserverfaces.entities.Student;

import java.util.ArrayList;
import java.util.List;

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

        beginTransaction();
        entityManager.persist(student);
        entityManager.flush();
        commitTransaction();
    }

    public void update(Integer id, StudentDto studentDto) {
        Student student = this.getById(id);
        student.setName(studentDto.getName());
        student.setAssignedExams(new ArrayList<>());
        List<Exam> assignedExams = getListOfExamsForStudentDto(studentDto);
        student.addExams(assignedExams.toArray(new Exam[0]));

        beginTransaction();
        entityManager.merge(student);
        entityManager.flush();
        commitTransaction();
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

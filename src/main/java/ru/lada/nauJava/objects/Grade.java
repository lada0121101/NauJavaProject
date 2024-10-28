package ru.lada.nauJava.objects;

import jakarta.persistence.*;

@Entity
@Table(name="Grades")
public class Grade {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private short value;
    @Column
    private String workType;
    @Column
    private String comment;
    @ManyToOne
    @JoinColumn(name = "teacherID",referencedColumnName = "id",nullable = false)
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "studentID",referencedColumnName = "id",nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "LessonID",nullable = false)
    private Lesson lesson;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}

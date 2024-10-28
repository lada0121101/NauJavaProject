package ru.lada.nauJava.objects;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Teachers")
public class Teacher {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String fullname;
    @Column
    private String subject;
    @Column
    private LocalDate birthday;
    @Column
    private int yearsOfWork;
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Grade> grades;
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Hometask> hometasks;
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Lesson> lessons;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getYearsOfWork() {
        return yearsOfWork;
    }

    public void setYearsOfWork(int yearsOfWork) {
        this.yearsOfWork = yearsOfWork;
    }


    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Hometask> getHometasks() {
        return hometasks;
    }

    public void setHometasks(List<Hometask> hometasks) {
        this.hometasks = hometasks;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}

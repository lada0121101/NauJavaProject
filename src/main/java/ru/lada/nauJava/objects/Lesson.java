package ru.lada.nauJava.objects;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Lessons")
public class Lesson {
    @Id
    @GeneratedValue()
    private long id;
    @Column
    private String theme;
    @Column
    private String className;
    @Column
    private LocalTime startt;
    @Column
    private LocalTime endt;
    @ManyToOne
    @JoinColumn(name = "teacherID",nullable = false)
    private Teacher teacher;
    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    private List<Grade> grades;
    @OneToOne(cascade = CascadeType.MERGE)
    private Hometask hometask;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public LocalTime getStartt() {
        return startt;
    }

    public void setStartt(LocalTime startt) {
        this.startt = startt;
    }

    public LocalTime getEndt() {
        return endt;
    }

    public void setEndt(LocalTime endt) {
        this.endt = endt;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Hometask getHometask() {
        return hometask;
    }

    public void setHometask(Hometask hometask) {
        this.hometask = hometask;
    }
}

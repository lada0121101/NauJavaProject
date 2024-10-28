package ru.lada.nauJava.objects;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
@Entity
@Table(name = "Hometasks")
public class Hometask {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String description;
    @Column
    private OffsetDateTime deadline;
    @ManyToOne
    @JoinColumn(name = "teacherID",referencedColumnName = "id",nullable = false)
    private Teacher teacher;
    @OneToOne(mappedBy = "hometask")
    private Lesson lesson;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(OffsetDateTime deadline) {
        this.deadline = deadline;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}

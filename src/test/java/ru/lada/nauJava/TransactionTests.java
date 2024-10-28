package ru.lada.nauJava;

import jakarta.persistence.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.lada.nauJava.objects.Hometask;
import ru.lada.nauJava.objects.Lesson;
import ru.lada.nauJava.objects.Teacher;
import ru.lada.nauJava.repos.HometaskRepos;
import ru.lada.nauJava.repos.LessonRepos;
import ru.lada.nauJava.repos.TeacherRepos;
import ru.lada.nauJava.services.HometaskService;
import ru.lada.nauJava.services.HometaskServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootTest
public class TransactionTests {
    private final LessonRepos lessons ;
    private final HometaskRepos hometasks;
    private final TeacherRepos teachers;
    private final HometaskServiceImpl service;
    @Autowired
    public TransactionTests(LessonRepos lessons, HometaskRepos hometasks, TeacherRepos teachers, HometaskServiceImpl service) {
        this.lessons = lessons;
        this.hometasks = hometasks;
        this.teachers = teachers;
        this.service = service;
        teachers.deleteAll();
        hometasks.deleteAll();
        lessons.deleteAll();
    }

    @Test
    void testTransaction(){
        OffsetDateTime deadline = OffsetDateTime.of(2024,11,30,23,59,0,0, ZoneOffset.ofHours(5));
        Hometask hometask = new Hometask();
        hometask.setDescription("hello");
        hometask.setDeadline(deadline);
        Teacher teacher= new Teacher();
        teacher.setFullname("Mrs. Stone");
        teacher.setYearsOfWork(7);
        teacher.setBirthday(LocalDate.of(1991,12,8));
        hometask.setTeacher(teacher);
        Lesson lesson= new Lesson();
        lesson.setHometask(hometask);
        lesson.setTeacher(teacher);
        lesson.setTheme("helloLesson");
        lesson.setStartt(LocalTime.of(8,30));
        lesson.setEndt(LocalTime.of(9,30));
        teachers.save(teacher);
        hometasks.save(hometask);
        lessons.save(lesson);

        service.deleteHometask(deadline);

        List<Hometask> res0 = hometasks.findByDeadline(deadline);
        Assertions.assertEquals(0,res0.size());
        List<Lesson> res1 = lessons.findByHometask(deadline);
        Assertions.assertEquals(0,res1.size());

    }
}

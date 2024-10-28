package ru.lada.nauJava;

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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootTest
public class LessonReposTests {
    private final LessonRepos lessons ;
    private final HometaskRepos hometasks;
    private final TeacherRepos teachers;
    @Autowired
    public LessonReposTests(LessonRepos lessons, HometaskRepos hometasks, TeacherRepos teachers) {
        this.lessons = lessons;
        this.hometasks = hometasks;
        this.teachers = teachers;
        teachers.deleteAll();
        hometasks.deleteAll();
        lessons.deleteAll();
    }
    @Test
    void testfindByHometask(){
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

        List<Lesson> res = lessons.findByHometask(deadline);
        Assertions.assertEquals(1,res.size());

        Assertions.assertEquals(lesson.getId(),res.getFirst().getId());
    }
}

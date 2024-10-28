package ru.lada.nauJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.lada.nauJava.objects.Hometask;
import ru.lada.nauJava.objects.Teacher;
import ru.lada.nauJava.repos.HometaskRepos;
import ru.lada.nauJava.repos.TeacherRepos;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootTest
public class HometaskReposTest {
    private final TeacherRepos teachers;
    private final HometaskRepos hometasks;
    @Autowired
    public HometaskReposTest(TeacherRepos teachers, HometaskRepos hometasks) {
        this.teachers = teachers;
        this.hometasks = hometasks;
        teachers.deleteAll();
        hometasks.deleteAll();
    }
    @Test
    void testFindByDeadline(){
        OffsetDateTime deadline = OffsetDateTime.of(2024,11,30,23,59,0,0, ZoneOffset.ofHours(5));
        Hometask hometask = new Hometask();
        hometask.setDescription("hello");
        hometask.setDeadline(deadline);
        Teacher teacher= new Teacher();
        teacher.setFullname("Mrs. Stone");
        teacher.setYearsOfWork(7);
        teacher.setBirthday(LocalDate.of(1991,12,8));
        hometask.setTeacher(teacher);
        teachers.save(teacher);
        hometasks.save(hometask);
        List<Hometask> res = hometasks.findByDeadline(deadline);
        Assertions.assertEquals(1,res.size());

        Assertions.assertEquals(hometask.getId(),res.getFirst().getId());

        Assertions.assertTrue(deadline.isEqual(res.getFirst().getDeadline()));
    }
}

package ru.lada.nauJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lada.nauJava.criteria.CustomLessonReposImpl;
import ru.lada.nauJava.objects.Lesson;

import java.time.OffsetDateTime;
import java.util.List;

@Controller
@RequestMapping("/custom/lessons")
public class LessonController {
    @Autowired
    private CustomLessonReposImpl lessons;
    @GetMapping("/findByHometask")
    public List<Lesson> findByHometask(OffsetDateTime deadline){
        return lessons.findByHometask(deadline);
    }
}

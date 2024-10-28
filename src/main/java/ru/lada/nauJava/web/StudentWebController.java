package ru.lada.nauJava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lada.nauJava.objects.Student;
import ru.lada.nauJava.repos.StudentRepos;
@Controller
@RequestMapping("/custom/students/view")
public class StudentWebController {
    @Autowired
    private StudentRepos students;
    @GetMapping("/list")
    public String studentListView(Model model){
        Iterable<Student> stds = students.findAll();
        model.addAttribute("students",stds);
        return "studentList";
    }
}

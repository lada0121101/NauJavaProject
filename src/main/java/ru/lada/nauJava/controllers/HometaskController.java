package ru.lada.nauJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lada.nauJava.criteria.CustomHometaskReposImpl;
import ru.lada.nauJava.objects.Hometask;

import java.time.OffsetDateTime;
import java.util.List;

@Controller
@RequestMapping("/custom/hometasks")
public class HometaskController {
    @Autowired
    private CustomHometaskReposImpl hometasks;

    @GetMapping("/findByDeadline")
    public List<Hometask> findByDeadline(OffsetDateTime deadline){
        return hometasks.findByDeadline(deadline);
    }
}

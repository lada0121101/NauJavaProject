package ru.lada.nauJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lada.nauJava.objects.Report;
import ru.lada.nauJava.services.ReportServiceImpl;

@Controller
public class ReportController {
    @Autowired
    private ReportServiceImpl reports;
    @GetMapping("/createReport")
    Long createReport(){
        Long id =  reports.createReport();
        reports.formContent(id);
        return id;
    }

    @GetMapping("/getReport")
    String getReport(long id,Model model)throws Exception{
        String message = reports.getContent(id);
        model.addAttribute("report",message);
        return "report";
    }
}

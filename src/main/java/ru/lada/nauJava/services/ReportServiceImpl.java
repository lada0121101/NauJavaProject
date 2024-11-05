package ru.lada.nauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lada.nauJava.objects.Report;
import ru.lada.nauJava.objects.Status;
import ru.lada.nauJava.repos.ReportRepos;
import ru.lada.nauJava.repos.StudentRepos;
import ru.lada.nauJava.repos.UserRepos;

import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepos reports;
    @Autowired
    private UserRepos users;
    @Autowired
    private StudentRepos students;

    @Override
    public Long createReport() {
        Report report = new Report();
        report.setStatus(Status.CREATED);
        reports.save(report);
        return report.getId();
    }

    @Override
    public String getContent(Long id) throws Exception {
        Report needed = reports.findById(id).orElse(null);
        if(needed!= null){
            String content = needed.getContent();
            if(content==null ||content.equals("")){
                return needed.getStatus().toString();
            }
            else{
                return needed.getContent();
            }
        }
        else{
            throw new Exception("Отсчёта с таким id нет");
        }
    }

    @Override
    public CompletableFuture<Void> formContent(Long id) {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(()->
        {
            long start = System.currentTimeMillis();
            MyRunnable r1 = new MyRunnable(users);
            Thread thread1 = new Thread(r1);
            MyRunnable r2 = new MyRunnable(students);
            Thread thread2 = new Thread(r2);
            thread1.start();
            thread2.start();
            try{
            thread1.join();
            thread2.join();
            }
            catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
            long dur = System.currentTimeMillis() - start;
            return MessageFormat.format("Количество пользователей: {0}, количесвто студентов :{1}, время на подсчёт пользователей: {2}, время на подсчёт студентов: {3}, общее время формирование отсчёта: {4}",r1.getCount(),r2.getCount(),r1.getDuration(),r2.getDuration(),dur);
        }).exceptionally((ex) ->
        {
            Report c = reports.findById(id).orElse(null);
            if( c != null){
                c.setStatus(Status.ERROR);
                reports.save(c);
            }
            return "Ошибка обработана";
        })
                .thenAccept((res)->
                {
            Report c = reports.findById(id).orElse(null);
            if( c == null){
               throw new IllegalStateException("Отчёта с таким id не существует");
            }
            else if(res!= "Ошибка"){
                c.setContent(res);
                c.setStatus(Status.COMPILED);
                reports.save(c);
            }
        });
    return future;
    }
}

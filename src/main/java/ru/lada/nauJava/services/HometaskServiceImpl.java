package ru.lada.nauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.lada.nauJava.objects.Hometask;
import ru.lada.nauJava.objects.Lesson;
import ru.lada.nauJava.repos.HometaskRepos;
import ru.lada.nauJava.repos.LessonRepos;

import java.time.OffsetDateTime;
import java.util.List;
@Service
public class HometaskServiceImpl implements HometaskService{
    private final HometaskRepos hometasks;
    private final LessonRepos lessons;
    private final PlatformTransactionManager manager;
    @Autowired
    public HometaskServiceImpl(HometaskRepos hometasks, LessonRepos lessons, PlatformTransactionManager manager) {
        this.hometasks = hometasks;
        this.lessons = lessons;
        this.manager = manager;
    }

    @Override
    public void deleteHometask(OffsetDateTime deadline) {
        TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());
        try
        {
            List<Lesson> toDelete = lessons.findByHometask(deadline);
            lessons.deleteAll(toDelete);
            List<Hometask> res = hometasks.findByDeadline(deadline);
            for(var hometask:res){
                hometasks.delete(hometask);
            }
        }
        catch (DataAccessException e){
            manager.rollback(status);
        }
    }
}

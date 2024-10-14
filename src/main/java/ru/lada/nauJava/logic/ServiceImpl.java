package ru.lada.nauJava.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lada.nauJava.access.TaskRepository;
import ru.lada.nauJava.task.Task;

import java.time.OffsetDateTime;
@Service
public class ServiceImpl implements TaskService{
    private final TaskRepository store;
    @Autowired
    ServiceImpl(TaskRepository store){
        this.store=store;
    }

    @Override
    public Task createTask(Long id, String subject, String teacher, OffsetDateTime deadline) {
        Task task = new Task();
        task.setId(id);
        task.setSubject(subject);
        task.setTeacher(teacher);
        task.setDeadline(deadline);
        return store.create(task);
    }

    @Override
    public Task findById(Long id) {
        return store.read(id);
    }

    @Override
    public Task deleteById(Long id) {
        return store.delete(id);
    }

    @Override
    public Task updateSubject(Long id, String newSub) {
         Task toReplace = store.read(id);
         Task task = new Task();
         task.setId(id);
         task.setSubject(newSub);
         task.setTeacher(toReplace.getTeacher());
         task.setDeadline(toReplace.getDeadline());
         return store.update(task);
    }

    @Override
    public Task updateTeacher(Long id, String newTeacher) {
        Task toReplace = store.read(id);
        Task task = new Task();
        task.setId(id);
        task.setTeacher(newTeacher);
        task.setSubject(toReplace.getSubject());
        task.setDeadline(toReplace.getDeadline());
        return store.update(task);
    }

    @Override
    public Task updateDeadline(Long id, OffsetDateTime newDate) {
        Task toReplace = store.read(id);
        Task task = new Task();
        task.setId(id);
        task.setDeadline(newDate);
        task.setTeacher(toReplace.getTeacher());
        task.setSubject(toReplace.getSubject());
        return store.update(task);
    }
}

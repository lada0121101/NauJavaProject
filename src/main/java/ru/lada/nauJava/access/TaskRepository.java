package ru.lada.nauJava.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lada.nauJava.task.Task;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Component
public class TaskRepository implements CRUD<Task,Long> {
    private final List<Task> taskStore;
    @Autowired
    TaskRepository(List<Task> taskStore){
        this.taskStore = taskStore;
    }
    @Override
    public Task create(Task task) {
        Optional<Task> res =taskStore.stream().filter(x->x.getId()==task.getId()).findFirst();
        if(!res.isEmpty())
            throw new IllegalArgumentException(MessageFormat.format("Repository already has user with id {0}",task.getId()));
        taskStore.add(task);
        return task;
    }

    @Override
    public Task read(Long id) {
        return taskStore.stream().filter(x->x.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Task update(Task task) {
        Optional<Task> res =taskStore.stream().filter(x->x.getId()==task.getId()).findFirst();
        if(res.isEmpty())
            throw new IllegalArgumentException(MessageFormat.format("There is no user with id {0}",task.getId()));
        int index = taskStore.indexOf(res.get());
        taskStore.remove(res.get());
        taskStore.add(index,task);
        return task;
    }

    @Override
    public Task delete(Long id) {
        Optional<Task> res =taskStore.stream().filter(x->x.getId()==id).findFirst();
        if(res.isEmpty())
            throw new IllegalArgumentException(MessageFormat.format("There is no user with id {0}",id));
        taskStore.remove(res.get());
        return res.orElse(null);
    }
}

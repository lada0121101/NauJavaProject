package ru.lada.nauJava.logic;

import ru.lada.nauJava.task.Task;

import java.time.OffsetDateTime;

public interface TaskService {
    Task createTask(Long id, String subject, String teacher, OffsetDateTime deadline);
    Task findById(Long id);
    Task deleteById(Long id);
    Task updateSubject(Long id, String newSub);
    Task updateTeacher(Long id ,String newTeacher);
    Task updateDeadline(Long id,OffsetDateTime newDate);
}

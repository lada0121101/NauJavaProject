package ru.lada.nauJava.consoleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lada.nauJava.logic.TaskService;
import ru.lada.nauJava.task.Task;

import java.time.OffsetDateTime;
@Component
public class CommandExecutor {
    private final TaskService taskService;
    @Autowired
    public CommandExecutor(TaskService taskService)
    {
        this.taskService = taskService;
    }
    public void processCommand(String input)
    {
        String[] cmd = input.split(" ");
        switch (cmd[0])
        {
            case "create" ->
            {
                taskService.createTask(Long.parseLong(cmd[1]), cmd[2],cmd[3], OffsetDateTime.parse(cmd[4]));
                System.out.println("Задание успешно добавлено...");
            }
            case "remove" ->
            {
                taskService.deleteById(Long.parseLong(cmd[1]));
                System.out.println("Задание успешно удалено...");
            }
            case "find" -> {
                Task task = taskService.findById(Long.parseLong(cmd[1]));
                System.out.println("Задание успешно найдено...");
            }
            case "update" ->{
                long id = Long.parseLong(cmd[2]);
                switch (cmd[1]){
                    case "-s" -> taskService.updateSubject(id,cmd[3]);
                    case "-t" -> taskService.updateTeacher(id,cmd[3]);
                    case "-d" -> taskService.updateDeadline(id,OffsetDateTime.parse(cmd[3]));
                }
                System.out.println("Задание успешно обновилось...");
            }
// .... здесь логика Обработки других команды
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}

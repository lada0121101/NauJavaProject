package ru.lada.nauJava.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.lada.nauJava.task.Task;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Task> tasks(){
        return new ArrayList<>();
    }
}

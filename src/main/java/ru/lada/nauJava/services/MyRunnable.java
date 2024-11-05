package ru.lada.nauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class MyRunnable implements Runnable {
    private final CrudRepository repos;
    private long count;
    private Long duration;

    public MyRunnable(CrudRepository repos) {
        this.repos = repos;
    }

    long getCount(){
        return count;
    }

    long getDuration(){
        return duration;
    }
    @Override
    public void run(){
        long start = System.currentTimeMillis();
        count = repos.count();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        duration = System.currentTimeMillis()- start;
    }
}

package ru.lada.nauJava.services;

import java.util.concurrent.CompletableFuture;

public interface ReportService {

    public Long createReport();
    public String getContent(Long id) throws Exception;
    public CompletableFuture<Void> formContent(Long id) ;
}

package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lada.nauJava.objects.Report;

public interface ReportRepos extends CrudRepository<Report,Long> {
}

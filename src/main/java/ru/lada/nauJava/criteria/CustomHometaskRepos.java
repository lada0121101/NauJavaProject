package ru.lada.nauJava.criteria;

import ru.lada.nauJava.objects.Hometask;

import java.time.OffsetDateTime;
import java.util.List;

public interface CustomHometaskRepos {
    List<Hometask> findByDeadline(OffsetDateTime deadline);
}

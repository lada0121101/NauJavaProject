package ru.lada.nauJava.access;

public interface CRUD <T, ID>{
    T create(T entity);
    T read(ID id);
    T update(T entity);
    T delete(ID id);
}

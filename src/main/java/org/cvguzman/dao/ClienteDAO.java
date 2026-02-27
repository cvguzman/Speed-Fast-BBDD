package org.cvguzman.dao;

import java.util.List;

public interface ClienteDAO<T> {
    void create(T t);
    List<T> readAll();
    void update(T t);
    void delete(T t);
}


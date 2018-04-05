package by.homework.servlets.dao;

import java.util.List;

/**
 * Created by dmurashko on 07.12.2017.
 */
public interface daoInterface <T>{
    public abstract void insert(T o);

    public abstract void delete(T o);

    public abstract void update(T o);

    public abstract T get(int id);

    public abstract List<T> getAll(String sql);


}

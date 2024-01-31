package org.example;

import java.util.List;

public interface TaskService<T extends Task> {
    
    List<T> loadAll();
    
    List<T> getAll();
    
    T get(int id);
    
    String save(T task);
    
    String update(int id, String title);
    
    String delete(int id);
    
    T get(List<T> tasks, int id);
    
}

package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImplementation implements TaskService<Task> {
    private List<Task> tasks = new ArrayList<>();
    
    @Override
    public List<Task> loadAll() {
        return tasks;
    }
    
    @Override
    public List<Task> getAll() {
        return tasks;
    }
    
    
    @Override
    public String save(Task task) {
        int id = !tasks.isEmpty() ? tasks.get(tasks.size() - 1).getId() + 1 : 1;
        task.setId(id);
        tasks.add(task);
        return "Tarefa [" + task.getId() + "] Salva";
    }
    
    @Override
    public String update(int id, String title) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                if (!title.isEmpty()) {
                    task.setTitle(title);
                }
                return "Tarefa [" + id + "] atualizada";
            }
        }
        return "Tarefa [" + id + "] não encontrada";
    }
    
    @Override
    public String delete(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                return "Tarefa [" + id + "] excluída";
            }
        }
        return "Tarefa [" + id + "] não encontrada";
    }
    
    @Override
    public Task get(List<Task> tasks, int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    
    @Override
    public Task get(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}

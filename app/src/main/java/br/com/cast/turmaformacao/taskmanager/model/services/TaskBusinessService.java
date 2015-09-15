package br.com.cast.turmaformacao.taskmanager.model.services;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entities.Task;

/**
 * Created by Administrador on 15/09/2015.
 */
public final class TaskBusinessService {
    private List<Task> values = new ArrayList<>();
    int count = 0;
    private static TaskBusinessService INSTANCE;
    private static class Singleton{
        public static final TaskBusinessService INSTANCE = new TaskBusinessService();
    }

    private TaskBusinessService() {
    super();
    }

    public static TaskBusinessService getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Task> findAll(){
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.addAll(values);
        return tasks;
    }
    public void save(Task task){

        task.setId(task.getId() == null ? ++count : task.getId());
        values.add(task);

    }
}

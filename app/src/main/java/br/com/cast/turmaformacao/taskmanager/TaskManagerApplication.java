package br.com.cast.turmaformacao.taskmanager;

import android.app.Application;

import br.com.cast.turmaformacao.taskmanager.model.entities.Color;
import br.com.cast.turmaformacao.taskmanager.util.ApplicationUtil;

/**
 * Created by Administrador on 16/09/2015.
 */
public class TaskManagerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtil.setContext(getApplicationContext());
    }
}

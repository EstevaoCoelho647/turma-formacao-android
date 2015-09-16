package br.com.cast.turmaformacao.taskmanager.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.security.cert.CRLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entities.Task;

/**
 * Created by Administrador on 16/09/2015.
 */
public final class TaskContract {

    public static String TABLE = "Task";
    public static String ID = "id";
    public static String NAME = "name";
    public static String DESCRIPTION = "description";

    public static final String[] COLUNS = {ID, NAME, DESCRIPTION};

    private TaskContract() {
    }

    public static String getCreateTableScript() {

        final StringBuilder create = new StringBuilder();

        create.append(" CREATE TABLE " +  TABLE);
        create.append(" ( ");
        create.append( ID + " INTEGER PRIMARY KEY, ");
        create.append( NAME + " TEXT NOT NULL,");
        create.append(( DESCRIPTION + " TEXT "));
        create.append(" ); ");

        return create.toString();
    }

    public static ContentValues getContentValues(Task task){
        ContentValues values = new ContentValues();
        values.put(TaskContract.ID, task.getId());
        values.put(TaskContract.NAME, task.getName());
        values.put(TaskContract.DESCRIPTION, task.getDescription());
        return values;
    }

    private static Task getTask(Cursor cursor) {
        Task task = new Task();
        if (!cursor.isBeforeFirst() || cursor.moveToNext()){
            task.setId(cursor.getLong(cursor.getColumnIndex(TaskContract.ID)));
            task.setName(cursor.getString(cursor.getColumnIndex(TaskContract.NAME)));
            task.setDescription(cursor.getString(cursor.getColumnIndex(TaskContract.DESCRIPTION)));
            return task;
        }
        return null;
    }
    public static List getTasks(Cursor cursor) {
        ArrayList<Task> tasks  = new ArrayList();
        while (cursor.moveToNext()){
            tasks.add(getTask(cursor));
        }
        return tasks;
    }


}

package br.com.cast.turmaformacao.taskmanager.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entities.Label;
import br.com.cast.turmaformacao.taskmanager.model.entities.Task;

/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelContract {

    public static String TABLE = "Label";
    public static String ID = "id";
    public static String NAME = "name";
    public static String DESCRIPTION = "description";

    public static final String[] COLUNS = {ID, NAME, DESCRIPTION};

    private LabelContract(){}

    public static String getCreateTableScript(){
        final StringBuilder create = new StringBuilder();
        create.append(" CREATE TABLE " +  TABLE);
        create.append(" ( ");
        create.append( ID + " INTEGER PRIMARY KEY, ");
        create.append( NAME + " TEXT NOT NULL,");
        create.append(( DESCRIPTION + " TEXT "));
        create.append(" ); ");

        return create.toString();
    }

    public static ContentValues getContentValues(Label label){
        ContentValues values = new ContentValues();
        values.put(TaskContract.ID, label.getId());
        values.put(TaskContract.NAME, label.getName());
        values.put(TaskContract.DESCRIPTION, label.getDescription());
        return values;
    }

    private static Label getLabel(Cursor cursor) {
        Label label = new Label();
        if (!cursor.isBeforeFirst() || cursor.moveToNext()){
            label.setId(cursor.getLong(cursor.getColumnIndex(TaskContract.ID)));
            label.setName(cursor.getString(cursor.getColumnIndex(TaskContract.NAME)));
            label.setDescription(cursor.getString(cursor.getColumnIndex(TaskContract.DESCRIPTION)));
            return label;
        }
        return null;
    }
    public static List getLabels(Cursor cursor) {
        ArrayList<Label> labels  = new ArrayList();
        while (cursor.moveToNext()){
            labels.add(getLabel(cursor));
        }
        return labels;
    }





}

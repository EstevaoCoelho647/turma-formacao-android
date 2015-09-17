package br.com.cast.turmaformacao.taskmanager.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import br.com.cast.turmaformacao.taskmanager.model.entities.Label;


/**
 * Created by Administrador on 17/09/2015.
 */
public final class LabelRepository {

    private LabelRepository() {
    }

    public static void save(Label label) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = LabelContract.getContentValues(label);
        if (label.getId() == null) {
            db.insert(LabelContract.TABLE, null, values);
        } else {
            String where = LabelContract.ID + " = ?";
            String[] params = {label.getId().toString()};
            db.update(LabelContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();
    }

    public static List<Label> getAll() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(LabelContract.TABLE, LabelContract.COLUNS, null, null, null, null, LabelContract.ID);
        List<Label> values = LabelContract.getLabels(cursor);


        db.close();
        databaseHelper.close();
        return values;
    }

    public static void delete(long id) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = LabelContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(LabelContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }
}



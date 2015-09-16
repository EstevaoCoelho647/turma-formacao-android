package br.com.cast.turmaformacao.taskmanager.controllers.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.TaskManagerApplication;
import br.com.cast.turmaformacao.taskmanager.model.entities.Task;
import br.com.cast.turmaformacao.taskmanager.model.services.TaskBusinessService;
import br.com.cast.turmaformacao.taskmanager.util.FormHelper;

/**
 * Created by Administrador on 15/09/2015.
 */
public class TaskFormActivity extends AppCompatActivity {
    EditText editTextDescription;
    EditText editTextNome;
    Button buttonSave;
    public static final String PARAM_TASK = "TASK";
    private Task task;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        initTask();

        bindEditTextNome();
        bindEditTextDescription();
        bindButtonSave();

    }
    private void initTask() {
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            this.task = (Task) extras.getParcelable(TaskFormActivity.PARAM_TASK);
        }

        this.task = task == null ? new Task() : this.task;
    }

    private void bindEditTextDescription() {
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        editTextDescription.setText(task.getName() == null ? "" : task.getDescription());
    }
//ola
    private void bindEditTextNome() {

        editTextNome = (EditText) findViewById(R.id.editTextName);
        editTextNome.setText(task.getName() == null ? "" : task.getName());
    }

    private void bindButtonSave() {
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String requiredMessage = TaskFormActivity.this.getString(R.string.msg_required);

                if (!FormHelper.validateRequired(requiredMessage, editTextNome, editTextDescription)) {
                    binTask();
                    TaskBusinessService.save(task);
                    Toast.makeText(TaskFormActivity.this, R.string.msg_success_save, Toast.LENGTH_SHORT).show();
                    TaskFormActivity.this.finish();
                }
            }
        });
    }
        private void binTask() {
            task.setName(editTextNome.getText().toString());
            task.setDescription(editTextDescription.getText().toString()); }
}



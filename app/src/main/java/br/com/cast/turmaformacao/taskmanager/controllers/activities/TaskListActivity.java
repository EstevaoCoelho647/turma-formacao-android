package br.com.cast.turmaformacao.taskmanager.controllers.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.controllers.adapters.TaskListAdapter;
import br.com.cast.turmaformacao.taskmanager.model.entities.Task;
import br.com.cast.turmaformacao.taskmanager.model.services.TaskBusinessService;

/**
 * Created by Administrador on 15/09/2015.
 */
public class TaskListActivity extends AppCompatActivity {
    private ListView listViewTaskList;
    private Task selectedTask;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        bindTaskList();
    }

    protected void onResume() {
        List<Task> values = TaskBusinessService.findAll();
        listViewTaskList.setAdapter(new TaskListAdapter(this, values));
        TaskListAdapter adapter = (TaskListAdapter) listViewTaskList.getAdapter();
        adapter.notifyDataSetChanged();
        super.onResume();
    }


    private void bindTaskList() {
        listViewTaskList = (ListView) findViewById(R.id.listViewTaskList);
        registerForContextMenu(listViewTaskList);
        listViewTaskList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TaskListAdapter adapter = (TaskListAdapter) listViewTaskList.getAdapter();
                selectedTask = (Task) adapter.getItem(position);
                return false;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_task_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.menu_add:
                onMenuAddClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context_task_list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete:
                onMenuDeleteClick();
                break;
            case R.id.menu_edit:
                onMenuEditClick();
        }
        return super.onContextItemSelected(item);

    }

    private void onMenuEditClick() {
        Intent goToTaskForm = new Intent(TaskListActivity.this, TaskFormActivity.class);
        goToTaskForm.putExtra("TASK", selectedTask);
        startActivity(goToTaskForm);
    }



    private void onMenuDeleteClick() {
        new AlertDialog.Builder(TaskListActivity.this)
                .setTitle(R.string.lbl_confirm)
                .setMessage(R.string.msg_confirm_delete)
                .setPositiveButton(R.string.lbl_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TaskBusinessService.delete(selectedTask);
                        selectedTask = null;
                        String message = getString(R.string.mgs_delete);
                        updateTaskList();
                        Toast.makeText(TaskListActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton(R.string.lbl_no, null)
                .create()
                .show();
    }

    private void updateTaskList() {
        List<Task> values = TaskBusinessService.findAll();
        listViewTaskList.setAdapter(new TaskListAdapter(this, values));
        TaskListAdapter adapter = (TaskListAdapter) listViewTaskList.getAdapter();
        adapter.notifyDataSetChanged();
    }


    private void onMenuAddClick() {
        Intent goToTaskFormActivity = new Intent(TaskListActivity.this, LabelFormActivity.class);
        startActivity(goToTaskFormActivity);
    }
}

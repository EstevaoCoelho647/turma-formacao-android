package br.com.cast.turmaformacao.taskmanager.controllers.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.cast.turmaformacao.taskmanager.R;

/**
 * Created by Administrador on 14/09/2015.
 */
public class LoginActivity extends Activity {

    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button buttonLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindEditTextLogin();
        bindEditTextPassword();
        bindButtonLogin();
    }

    private void bindButtonLogin() {
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent redirectToTaskList = new Intent(LoginActivity.this, TaskListActivity.class);
                startActivity(redirectToTaskList);


            }
        });
    }

    private void bindEditTextLogin() {
        editTextLogin =(EditText) findViewById(R.id.editTextLogin);
    }

    private void bindEditTextPassword(){
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    }


}

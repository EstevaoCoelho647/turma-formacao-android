package br.com.cast.turmaformacao.taskmanager.controllers.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cast.turmaformacao.taskmanager.R;

import static android.widget.Toast.LENGTH_SHORT;
import static java.lang.Double.parseDouble;

/**
 * Created by Administrador on 14/09/2015.
 */
public class IMCActivity extends Activity {
    private EditText editTextPeso;
    private EditText editTextAltura;
    private Button buttonCalcula;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        bindEditTextAltura();
        bindEditTextPeso();
        bindButtonCalcula();
    }

    private void bindButtonCalcula() {
        buttonCalcula = (Button) findViewById(R.id.buttonCalcular);
        buttonCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = (parseDouble(editTextPeso.getText().toString()));
                double altura = (parseDouble(editTextAltura.getText().toString()));
                double imc = peso / (altura * altura);

                String message = getResources().getString(R.string.msg_imc, imc);
                Toast.makeText(IMCActivity.this, message, LENGTH_SHORT).show();
            }

        });
    }

    private void bindEditTextPeso() {
        editTextPeso = (EditText) findViewById(R.id.editTextPeso);
    }

    private void bindEditTextAltura() {
        editTextAltura = (EditText) findViewById(R.id.editTextAltura);
    }
}

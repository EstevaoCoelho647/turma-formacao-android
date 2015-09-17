package br.com.cast.turmaformacao.taskmanager.controllers.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entities.Label;

import br.com.cast.turmaformacao.taskmanager.model.services.LabelBusinessService;

import br.com.cast.turmaformacao.taskmanager.util.FormHelper;

/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelFormActivity extends AppCompatActivity {

    EditText editTextDescription;
    EditText editTextNome;
    public static final String PARAM_LABEL = "Label";
    private Label label;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_form);

        initLabel();
        bindSpinnerColor();
        bindEditTextDescription();
        bindEditTextName();
    }

    private void initLabel() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.label = extras.getParcelable(PARAM_LABEL);
        }

        this.label = label == null ? new Label() : this.label;
    }

    private void bindEditTextName() {
        editTextNome = (EditText) findViewById(R.id.editTextName);
    }

    private void bindEditTextDescription() {
        editTextDescription = (EditText) findViewById(R.id.editTextName);
    }

    private void bindSpinnerColor() {
        Spinner spinnerColor = (Spinner) findViewById(R.id.spinnerColor);
        // spinnerColor.setAdapter(new ColorAdapter(LabelFormActivity.this, Color.values()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_label_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.menu_add_label:
                onMenuSaveClick();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onMenuSaveClick() {
        String requiredMessage = LabelFormActivity.this.getString(R.string.msg_required);

        if (!FormHelper.validateRequired(requiredMessage, editTextNome, editTextDescription)) {
            binLabel();
            LabelBusinessService.save(label);
            Toast.makeText(LabelFormActivity.this, R.string.msg_success_save, Toast.LENGTH_SHORT).show();
        }
    }

    private void binLabel() {
        label.setName(editTextNome.getText().toString());
        label.setDescription(editTextDescription.getText().toString());
    }
}

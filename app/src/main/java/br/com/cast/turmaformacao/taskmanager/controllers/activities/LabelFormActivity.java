package br.com.cast.turmaformacao.taskmanager.controllers.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.controllers.adapters.ColorListAdapter;
import br.com.cast.turmaformacao.taskmanager.model.entities.Color;
import br.com.cast.turmaformacao.taskmanager.model.entities.Label;
import br.com.cast.turmaformacao.taskmanager.model.services.LabelBusinessService;
import br.com.cast.turmaformacao.taskmanager.util.FormHelper;

/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelFormActivity extends AppCompatActivity {
    private View viewColor;

    EditText editTextDescription;
    EditText editTextNome;
    public static final String PARAM_LABEL = "Label";
    private Label label;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_form);

        initLabel();
        bindViewColor();
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

    private void bindViewColor() {
        viewColor = findViewById(R.id.viewPalletColors);
        viewColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LabelFormActivity.this);
                final ColorListAdapter adapter = new ColorListAdapter(LabelFormActivity.this);
                dialogBuilder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        updateColor(adapter.getItem(which));
                    }
                });
                dialogBuilder.setTitle("Select Color");
                dialogBuilder.setNeutralButton("Cancel", null);
                dialogBuilder.show();
            }
        });
    }


    private void updateColor(Color itemId) {
        viewColor.setBackgroundColor(android.graphics.Color.parseColor(itemId.getHex()));
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
            Toast.makeText(LabelFormActivity.this, LabelBusinessService.findAll().toString()/*R.string.msg_success_save */, Toast.LENGTH_SHORT).show();
            LabelFormActivity.this.finish();
        }
    }

    private void binLabel() {
        label.setName(editTextNome.getText().toString());
        label.setDescription(editTextDescription.getText().toString());
    }
}

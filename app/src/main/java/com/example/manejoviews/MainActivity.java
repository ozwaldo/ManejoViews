package com.example.manejoviews;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    Switch switchView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etFecha);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePickerDialog(editText);

//                Toast.makeText(getApplicationContext(), "EditText Click",
//                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void showDatePickerDialog(final EditText editText) {

        DatePickerFragment datePickerFragment =
                DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view,
                                          int year, int month, int dayOfMonth) {
                        // 06/03/2019
                        final String fechaSeleccionada =
                                dayOfMonth + "/" + month + "/" + year;

                        Log.d("TAG_LOG", fechaSeleccionada);
                        editText.setText(fechaSeleccionada);
                    }
                });

        datePickerFragment.show(this.getSupportFragmentManager(), "Fecha");
    }


    public void onToggleButtonClick(View view) {
        toggleButton = (ToggleButton) findViewById(R.id.toggle_button);

        boolean on = toggleButton.isChecked();

        if (on == true) {
            Toast.makeText(this, "ToggleButton esta Activado",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ToggleButton esta Desactivado",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onSwitchClick(View view) {
        switchView = (Switch) findViewById(R.id.switch_view);
        boolean on = switchView.isChecked();
        if (on == true) {
            Toast.makeText(this, "Switch esta en ON",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Switch esta en OFF",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onCheckboxClick(View view) {
        boolean check = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.check_box_leer:
                if (check) {
                    Toast.makeText(this, "Te gusta leer.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No te gusta leer.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.check_box_programar:
                if (check) {
                    Toast.makeText(this, "Te gusta programar.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No te gusta programar.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.check_box_videojuegos:
                if (check) {
                    Toast.makeText(this, "Te gustan los videojuegos.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No te gustan los videojuegos.",
                            Toast.LENGTH_SHORT).show();
                }

        }
    }

    public void onRadioButtonCheck(View view) {
        RadioGroup radioGroup = findViewById(R.id.radio_group);

        int id = radioGroup.getCheckedRadioButtonId();

        switch (id) {
            case R.id.radio_casado:
                Toast.makeText(this,"Usted esta casado",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_soltero:
                Toast.makeText(this,"Usted esta soltero",
                        Toast.LENGTH_SHORT).show();
        }
    }


}

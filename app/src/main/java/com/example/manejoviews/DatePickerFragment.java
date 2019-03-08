package com.example.manejoviews;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
{

    private DatePickerDialog.OnDateSetListener listener;

    public static DatePickerFragment newInstance(
            DatePickerDialog.OnDateSetListener listener){

        DatePickerFragment fragment = new DatePickerFragment();

        fragment.setListener(listener);

        return fragment;

    }

    private void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    /*public static void showDatePickerDialog(final EditText editText, Context context) {

        DatePickerFragment datePickerFragment =
                DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view,
                                          int year, int month, int dayOfMonth) {
                        // 06/03/2019
                        final String fechaSeleccionada =
                                dayOfMonth + "/" + month + "/" + year;

                        editText.setText(fechaSeleccionada);
                    }
                });

        //datePickerFragment.show(MainActivity.class..getPackageManager(), "Fecha");

    }*/

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();

        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        return new DatePickerDialog(getActivity(), listener, year, mes, dia);
    }

}

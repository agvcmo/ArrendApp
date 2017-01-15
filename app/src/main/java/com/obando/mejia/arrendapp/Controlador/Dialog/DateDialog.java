package com.obando.mejia.arrendapp.Controlador.Dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by ALEXANDER on 03/01/2017.
 */

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText txtDate;
    public DateDialog(View view)
    {
        txtDate = (EditText)view;
    }

    public Dialog onCreateDialog(Bundle saveInstanceState)
    {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day)
    {
        String date = day+"-"+(month+1)+"-"+year;
        txtDate.setText(date);
    }
}

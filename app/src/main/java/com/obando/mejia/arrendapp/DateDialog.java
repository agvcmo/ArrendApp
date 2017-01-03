package com.obando.mejia.arrendapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ALEXANDER on 03/01/2017.
 */

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText txtDate;

    public DateDialog(View view)
    {
        txtDate = (EditText) view;
    }
    public Dialog onCreateDialog(Bundle saveInstance)

}

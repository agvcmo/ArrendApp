package com.obando.mejia.arrendapp;

//region Librerias
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
//endregion Librerias

public class FechaFragment extends Fragment {

    //region Propiedades
    View fView;
    String fTipoFecha;
    onFechaSeleccionada fFechaSeleccionada;
    //endregion Propiedades

    //region Metodos
    public interface onFechaSeleccionada {
        public void FechaSeleccionada(String fecha);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fTipoFecha = getArguments().getString("TipoFecha");
        fView = inflater.inflate(R.layout.fragment_fecha, container, false);
        final EditText txtDate = (EditText) fView.findViewById(R.id.txtdate);
        txtDate.clearFocus();

        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog(view);
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    dialog.show(fragmentTransaction, "DatePicker");

                }

            }

        });

        txtDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                fFechaSeleccionada.FechaSeleccionada(String.format("%S%S%S", fTipoFecha, "/",txtDate.getText().toString()));
            }
        });
        return fView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fFechaSeleccionada = (onFechaSeleccionada) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }
    //endregion Metodos
}

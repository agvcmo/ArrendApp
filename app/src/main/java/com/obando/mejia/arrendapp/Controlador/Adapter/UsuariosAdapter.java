package com.obando.mejia.arrendapp.Controlador.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.obando.mejia.arrendapp.Modelo.Entidades.ClsUsuario;
import com.obando.mejia.arrendapp.R;

import java.util.ArrayList;

/**
 * Created by personal on 13/01/2017.
 */

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.MyvistaHolder> {
    private Context fContexto;
    private ArrayList<ClsUsuario> fUsuarios;

    public UsuariosAdapter(Context paramContext, ArrayList<ClsUsuario> paramUsuarios) {
        this.fContexto = paramContext;
        this.fUsuarios = paramUsuarios;
    }

    @Override
    public MyvistaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyvistaHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_usuarios, null));


    }

    @Override
    public void onBindViewHolder(MyvistaHolder holder, final int position) {
        holder.tNombre.setText(fUsuarios.get(position).getNombre());
        holder.tApellido.setText(fUsuarios.get(position).getApellido());
        holder.tNombreUsuario.setText(fUsuarios.get(position).getNombreUsuario());
    }


    @Override
    public int getItemCount() {
        return fUsuarios.size();
    }


    public class MyvistaHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        TextView tNombre, tApellido, tNombreUsuario;

        public MyvistaHolder(View itemView) {
            super(itemView);

            tNombre = (TextView) itemView.findViewById(R.id.Nombre);
            tApellido = (TextView) itemView.findViewById(R.id.Apellido);
            tNombreUsuario = (TextView) itemView.findViewById(R.id.NombreUsuario);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(fContexto,"Click",Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {

            Toast.makeText(fContexto,"Long Click",Toast.LENGTH_LONG).show();
            return false;
        }
    }


}

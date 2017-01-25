package com.obando.mejia.arrendapp.Controlador.Adapter;

//region Librerias
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.obando.mejia.arrendapp.Modelo.Entidades.ClsUsuario;
import com.obando.mejia.arrendapp.Modelo.Utis.ClsServicio;
import com.obando.mejia.arrendapp.R;
import java.util.ArrayList;
//endregion Librerias

/**
 * Created by personal on 13/01/2017.
 */

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.MyvistaHolder> {
    //region Propiedades Adaptador
    private Context fContexto;
    private ArrayList<ClsUsuario> fUsuarios;
    private ClsServicio fServicio;
    //endregion Propiedades Adaptador

    //region Constructor Adaptador
    public UsuariosAdapter(Context paramContext, ArrayList<ClsUsuario> paramUsuarios) {
        this.fContexto = paramContext;
        this.fUsuarios = paramUsuarios;
        this.fServicio = new ClsServicio(this.fContexto);
    }
    //endregion Constructor Adaptador

    //region ViewHolder -- Cada Item

    //region Constructor
    @Override
    public MyvistaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyvistaHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_usuarios, null));
    }
    //endregion Constructor
    //region Metodos Sobrecargados
    @Override
    public void onBindViewHolder(MyvistaHolder holder, final int position) {
        holder.fTxtNombre.setText(fUsuarios.get(position).getNombre());
        holder.fTxtApellido.setText(fUsuarios.get(position).getApellido());
        holder.fTxtNombreUsuario.setText(fUsuarios.get(position).getNombreUsuario());
    }


    @Override
    public int getItemCount() {
        return fUsuarios.size();
    }
    //endregion Metodos Sobrecargados

    public class MyvistaHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        TextView fTxtNombre, fTxtApellido, fTxtNombreUsuario;
        Integer fPosicionItem;

        public MyvistaHolder(View itemView) {
            super(itemView);

            fTxtNombre = (TextView) itemView.findViewById(R.id.Nombre);
            fTxtApellido = (TextView) itemView.findViewById(R.id.Apellido);
            fTxtNombreUsuario = (TextView) itemView.findViewById(R.id.NombreUsuario);
            fPosicionItem =  getAdapterPosition();

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {

                @Override
                public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                    menu.setHeaderTitle("Seleccione ");
                    menu.setHeaderIcon(R.drawable.ic_mode_edit_black_48dp);
                    menu.add("Editar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            return true;
                        }
                    });
                    menu.add("Eliminar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            fServicio.mEliminarUsuario(fUsuarios.get(fPosicionItem));
                            return true;
                        }
                    });
                }
            });
        }


        @Override
        public void onClick(View view) {
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
    //endregion ViewHolder -- Cada Item
}

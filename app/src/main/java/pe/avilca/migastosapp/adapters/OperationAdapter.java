package pe.avilca.migastosapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.avilca.migastosapp.R;
import pe.avilca.migastosapp.models.Operation;

public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.ViewHolder> {

    private List<Operation> operations;

    public void setOperaciones(List<Operation> operations) {
        this.operations = operations;
    }

    public OperationAdapter(){
        this.operations = new ArrayList<>();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView monto, titulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            monto = itemView.findViewById(R.id.monto_transaccion);
            titulo = itemView.findViewById(R.id.titulo_transaccion);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_operations, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Operation operation = this.operations.get(i);
        viewHolder.titulo.setText(operation.getFecha()+ " " + operation.getTipo() );
        viewHolder.monto.setText("S/. "+operation.getMonto()+"                                ");

    }

    @Override
    public int getItemCount() {
        return this.operations.size();
    }
}

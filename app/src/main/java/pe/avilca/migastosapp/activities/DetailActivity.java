package pe.avilca.migastosapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import pe.avilca.migastosapp.R;
import pe.avilca.migastosapp.adapters.OperationAdapter;
import pe.avilca.migastosapp.repositories.OperataionsRepository;

public class DetailActivity extends AppCompatActivity {
    TextView monto,detalle;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detalle = findViewById(R.id.detailTitulo);
        monto = findViewById(R.id.suma);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String valor = getIntent().getExtras().getString("valor");
        OperationAdapter adapter= new OperationAdapter();
        adapter.setOperaciones(OperataionsRepository.getOperations(valor));
        monto.setText(String.valueOf(OperataionsRepository.total(valor)));
        detalle.setText("Saldo Actual "+valor);
        recyclerView.setAdapter(adapter);
    }
}

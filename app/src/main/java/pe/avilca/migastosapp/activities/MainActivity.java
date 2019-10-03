package pe.avilca.migastosapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import pe.avilca.migastosapp.R;
import pe.avilca.migastosapp.repositories.OperataionsRepository;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton agregar;
    private ImageView buscar_ahorro,buscar_credito,buscar_efectivo;
    private TextView montototal1,montototal2,montototal3;
    private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregar=findViewById(R.id.agregar_monto);
        buscar_ahorro=findViewById(R.id.buscar_ahorro);
        buscar_credito=findViewById(R.id.buscar_credito);
        buscar_efectivo=findViewById(R.id.buscar_efectivo);
        montototal1=findViewById(R.id.montototal1);
        montototal2=findViewById(R.id.montototal2);
        montototal3=findViewById(R.id.montototal3);
        progress=findViewById(R.id.progress_bar);

        Double numeros= OperataionsRepository.total_final();
        Log.e("Princpial","Monto :"+numeros);

        progress.setProgress((int)Math.round(numeros));
        montototal1.setText("S/."+String.valueOf(OperataionsRepository.total("Ahorro")));
        montototal2.setText("S/."+String.valueOf(OperataionsRepository.total("Tarjeta de Crédito")));
        montototal3.setText("S/."+String.valueOf(OperataionsRepository.total("Efectivo")));

        buscar_efectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(), DetailActivity.class);
                p.putExtra("valor", "Efectivo");
                startActivity(p);
            }
        });
        buscar_credito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(), DetailActivity.class);
                p.putExtra("valor", "Tarjeta de Crédito");
                startActivity(p);
            }
        });
        buscar_ahorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(), DetailActivity.class);
                p.putExtra("valor", "Ahorro");
                startActivity(p);
            }
        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewOperationActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

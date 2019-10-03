package pe.avilca.migastosapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import pe.avilca.migastosapp.R;
import pe.avilca.migastosapp.repositories.OperataionsRepository;

public class NewOperationActivity extends AppCompatActivity {
    private Spinner tipo;
    private Button registrar;
    private EditText monto;
    private RadioButton ingreso,egreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);
    tipo=findViewById(R.id.tipo);
    registrar=findViewById(R.id.registrar);
    monto=findViewById(R.id.monto);
    ingreso=findViewById(R.id.ingreso);
    egreso=findViewById(R.id.egreso);
    registrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            add();
        }
    });
    }

    private void add(){
        String saldo=tipo.getSelectedItem().toString();
        String cantidad=monto.getText().toString();
        String tipo;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(Calendar.getInstance().getTime());
        if(ingreso.isChecked()){
            tipo="Ingresos";
        }else{
            tipo="Egresos";
        }
        OperataionsRepository.agrega(fecha,tipo, cantidad, saldo);
        Intent e = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(e);
        finish();
    }
}

package ramon.curso_3_tarea_2;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Segundaria extends AppCompatActivity {

    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;

    Button bEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundaria);

        //Obtengo los datos de la otra actividad
        Bundle extras = getIntent().getExtras();

        if (extras != null) {//ver si contiene datos
            nombre = extras.getString("nombre");//Obtengo el nombre
            telefono = extras.getString("telefono");//Obtengo el telefono
            email = extras.getString("email");
            descripcion = extras.getString("descripcion");


            //creo variables de los textview de xml
            TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
            TextView tvTelefono = (TextView) findViewById(R.id.tvVariableTelefono);
            TextView tvEmail = (TextView) findViewById(R.id.tvVariableEmail);
            TextView tvDescripcion = (TextView) findViewById(R.id.tvVariableDescripcion);

            //envio los datos de java al xml
            tvNombre.setText(nombre);
            tvEmail.setText(email);
            tvTelefono.setText(telefono);
            tvDescripcion.setText(descripcion);
        }

    }
        //////////// Respuesta al for result
            public void bEditarDatos_onClick (View v) {

              //  Intent intent = new Intent(Segundaria.this, Principal.class);
                Intent intent = new Intent();
                intent.putExtra("nombre", nombre);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
                setResult(RESULT_OK, intent);
                finish();
            }



}

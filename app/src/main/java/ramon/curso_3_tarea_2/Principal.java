package ramon.curso_3_tarea_2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Principal extends AppCompatActivity {

    private String nombre;
    private String telefono;
    private String fecha;
    private String email;
    private String descripcion;

    // TextInputLayout tieNombre; //declaramos variables xml
    TextInputEditText tieNombre;
    TextInputEditText tieEmail;
    TextInputEditText tieTelefono;
    TextInputEditText tieDescripcion;
    Button bSiguiente;   // //Declaracion de un objeto Button llamado bSiguiente

    //identificador del intent
    private static final int ID = 1;
    int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        ////// asociamos los xml a las variables java
        tieNombre = (TextInputEditText) findViewById(R.id.tieNombre);
        tieTelefono = (TextInputEditText) findViewById(R.id.tieTelefono);
        tieEmail = (TextInputEditText) findViewById(R.id.tieEmail);
        tieDescripcion = (TextInputEditText) findViewById(R.id.tieDescripcion);
        bSiguiente = (Button) findViewById(R.id.bSiguiente);

        // Cuando pulsamos el boton siguiente las valores se pasan a java
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = tieNombre.getText().toString();
                telefono = tieTelefono.getText().toString();
                email = tieEmail.getText().toString();
                descripcion = tieDescripcion.getText().toString();

            ///// hago el intent para ir a la otra actividad. Estoy a la escucha del boton siguiente
                Intent intent = new Intent(Principal.this, Segundaria.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
            //    startActivity(intent);
                startActivityForResult(intent , request_code);
            }
        });

            //envio los datos del formulario al xml
            tieNombre.setText(nombre);
            tieEmail.setText(email);
            tieTelefono.setText(telefono);
            tieDescripcion.setText(descripcion);
        }
    // }

    /// Utilizando el for result para que me devulva los datos una vez que se halla ejecutado una vez la segunda activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == ID) {
            String dataNombre = data.getStringExtra("nombre");
            String dataTelefono = data.getStringExtra("telefono");
            String dataEmail = data.getStringExtra("email");
            String dataDescripcion = data.getStringExtra("descripcion");

            tieNombre.setText(dataNombre);
            tieTelefono.setText(dataTelefono);
            tieEmail.setText(dataEmail);
            tieDescripcion.setText(dataDescripcion);
        }
    }}



// }





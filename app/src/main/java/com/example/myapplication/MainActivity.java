package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static String nomArchivo = Environment.getExternalStorageDirectory().getAbsolutePath() + "/misContactos.txt";
    ArchivoPersona pArchi = new ArchivoPersona(nomArchivo);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnAgregar(View vista) throws FileNotFoundException, IOException {
        String nombreNuevo = ((EditText)findViewById(R.id.editText2)).getText().toString();
        String ciNuevo = ((EditText)findViewById(R.id.editText)).getText().toString();
        try {
            pArchi.agregar(nombreNuevo,ciNuevo);
            Toast.makeText(this, "Agregado",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al agregar",Toast.LENGTH_SHORT).show();
        }
    }
    public void btnListar(View vista) throws FileNotFoundException, IOException {
        TextView t = findViewById(R.id.texto);
        try {
            String res = pArchi.listar();
            t.setText(res);
            Toast.makeText(this, "Listado",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al listar",Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.myapplication;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchivoPersona {
        private String nombre;
        public ArchivoPersona(String nombre) {
            this.nombre = nombre;
        }
        public void agregar(String nombreNuevo, String ciNuevo) throws FileNotFoundException, IOException {
            String ruta = Environment.getExternalStorageDirectory().getAbsolutePath();
            File f1 = new File(this.nombre);
            if(!f1.exists()){
                ObjectOutputStream archivo1 = new ObjectOutputStream(new FileOutputStream(this.nombre));
                archivo1.close();
            }
            ObjectOutputStream copiaArchivo = new ObjectOutputStream( new FileOutputStream(ruta+"/archivoCopia.txt") );
            ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(this.nombre));

            try {
                while(true){
                    Persona p = (Persona) archivo.readObject();
                    copiaArchivo.writeObject(p);
                }
            } catch (Exception e) {
                copiaArchivo.writeObject(new Persona(nombreNuevo,ciNuevo));
                copiaArchivo.close();
                archivo.close();
                File f2 = new File(ruta,"archivoCopia.txt");
                f1.delete();
                f2.renameTo(f1);

            }
        }
        public String listar() throws FileNotFoundException, IOException{
            String res="";
            File f1 = new File(this.nombre);
            if(!f1.exists()){
                ObjectOutputStream archivo1 = new ObjectOutputStream(new FileOutputStream(this.nombre));
                archivo1.close();
            }
            ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(this.nombre));
            try {
                while(true){
                    Persona p = (Persona) archivo.readObject();
                    res += p.getNombre()+" "+p.getCi() + ".\n";
                }
            } catch (Exception e) {
                archivo.close();
            }
            return res;
        }
}

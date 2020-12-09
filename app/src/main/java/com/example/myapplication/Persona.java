package com.example.myapplication;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String ci;
    public Persona(){
        this.nombre="";
        this.ci= "";
    }
    public Persona(String nom, String ci){
        this.nombre= nom;
        this.ci= ci;
    }
    public String  getCi(){
        return this.ci;
    }
    public String getNombre(){
        return this.nombre;
    }
}

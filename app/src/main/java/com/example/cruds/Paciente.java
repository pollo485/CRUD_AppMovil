package com.example.cruds;

public class Paciente {
    private String nombre;
    private int edad;
    private boolean internado;

    private  long id;

    public Paciente(String nombre, int edad, boolean internado){
        this.nombre = nombre;
        this.edad = edad;
        this.internado = internado;
    }
    public Paciente(String nombre, int edad, boolean internado, long id){
        this.nombre = nombre;
        this.edad = edad;
        this.internado = internado;
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public void SetId(long id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }
    public int getEdad(){
        return edad;
    }
    public  void setEdad(int edad){
        this.edad = edad;
    }
    public boolean getInternado(){
        return internado;
    }
    public void setInternado(boolean internado){
        this.internado = internado;
    }

    @Override
    public String toString(){
        return "Paciente{"+
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", internado=" + internado +
                '}';
    }
}

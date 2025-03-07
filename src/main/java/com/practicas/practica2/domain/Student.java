package com.practicas.practica2.domain;

public class Student {
    private int ID;
    private String nombre;
    private String correo;
    private int edad;
    private String curso;

    public Student(int ID, String nombre, String correo, int edad, String curso) {
        this.ID = ID;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.curso = curso;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}

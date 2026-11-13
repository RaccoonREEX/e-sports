package ec.edu.puce.sport.model;

import java.time.LocalDate;

//esta es una clase
public class Juador {

    //son atributos
    private int codigo;
    private String nombre;
    private int edad;
    private LocalDate fecha;
    private  String equipo;

    //gettersand setters con click derecho generate
    //son metodos
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}

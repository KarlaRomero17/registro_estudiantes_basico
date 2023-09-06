/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia4_1;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lissette
 */
public class Estudiante {
    private String nombre;
    private int edad;
    private String genero;
    private double promedio;
    private static List<Estudiante> listaEstudiantes = new ArrayList<>();
    //para calcular los promedios
    private static int sumaEdades = 0;
    private static double sumaPromedios = 0.0;
    private static int cantidadEstudiantes = 0;


    public Estudiante(String nombre, int edad, String genero, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.promedio = promedio;
        //acmuladores
        sumaEdades += edad;
        sumaPromedios += promedio;
        cantidadEstudiantes++;
    }
    public void guardar() {
        listaEstudiantes.add(this);
    }

    public static List<Estudiante> obtenerListaEstudiantes() {
        return listaEstudiantes;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    public static double getPromedioEdad() {
        if (cantidadEstudiantes == 0) {
            return 0.0; // Evitar la división por cero
        }
        return (double) sumaEdades / cantidadEstudiantes;
    }

    public static double getPromedioProm() {
        if (cantidadEstudiantes == 0) {
            return 0.0; // Evitar la división por cero
        }
        return sumaPromedios / cantidadEstudiantes;
    }
}

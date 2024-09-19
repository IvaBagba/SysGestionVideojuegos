package Videojuego;

import java.util.Arrays;
import java.util.Objects;

public abstract class Videojuego {
    private String nombre;

    private double precio;

    private String plataforma;

    private generos genero;

    public Videojuego(String nombre, double precio, String plataforma, generos genero) {
        this.nombre = nombre;
        this.precio = precio;
        this.plataforma = plataforma;
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setGenero(generos genero) {
        this.genero = genero;
    }

    public generos getGenero() {
        return genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return Double.compare(precio, that.precio) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(plataforma, that.plataforma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio, plataforma);
    }



    @Override
    public String toString() {
        return "Videojuego{" + "nombre='" + nombre + '\'' + ", precio=" + precio + ", plataforma='" + plataforma + '\'' + ", genero=" + genero + '}';
    }
}

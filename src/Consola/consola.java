package Consola;

import Videojuego.Videojuego;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public abstract class consola implements IConsola {

    private String plataforma;



    public consola(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        consola consola = (consola) o;
        return Objects.equals(plataforma, consola.plataforma);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plataforma);
    }

    @Override
    public String toString() {
        return "consola{" + "plataforma='" + plataforma + '\'' + '}';
    }

    public abstract void instalarJuego(Videojuego objeto);


}

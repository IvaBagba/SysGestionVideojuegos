package Videojuego;

import Consola.plataformas;

public class VideojuegoFisico extends Videojuego implements IVideojuego{
    private final double gGestion = 5;

    public VideojuegoFisico(String nombre, double precio, plataformas plataforma, generos genero) {
        super(nombre, precio, plataforma, genero);
    }

    public void calcPrecio() {
        setPrecio(getPrecio() + gGestion);
        System.out.println("Nuevo precio = " + getPrecio());
    }




}

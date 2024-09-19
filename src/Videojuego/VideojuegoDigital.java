package Videojuego;

import Consola.plataformas;

public class VideojuegoDigital extends Videojuego implements IVideojuego{
    private final double oferta = 0.8;

    public VideojuegoDigital(String nombre, double precio, plataformas plataforma, generos genero) {
        super(nombre, precio, plataforma, genero);
    }

    public void calcPrecio() {
        setPrecio(getPrecio() * oferta);
        System.out.println("Nuevo precio = " + getPrecio());
    }




}

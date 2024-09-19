package Consola;

import Videojuego.Videojuego;

import java.util.ArrayList;
import java.util.List;

public class nsw extends consola   {

    List<Videojuego> juegosNSW = new ArrayList<Videojuego>();

    public nsw(String plataforma) {
        super(plataforma);
    }

    @Override
    public void encender() {
        System.out.println("Hola Jugador");
    }

    @Override
    public void apagar() {
        System.out.println("Adios Jugador");
    }

    @Override
    public void instalarJuego(Videojuego juego) {

        if (juego.getPlataforma().equals(plataformas.NSW)) {
            juegosNSW.add(juego);
            System.out.println("Juego agregado con exito");

            //Separador
            System.out.println("___");

        } else {
            System.out.println("Juego no agregado");

            //Separador
            System.out.println("___");
        }
    }

    @Override
    public void jugarJuego() {
        System.out.println("""
                Lista de juegos
                ---------------------------------------""");
        for (Videojuego juego : juegosNSW) {
            System.out.println(juego.getNombre()+ " " +juego.getPlataforma()+ " " + juego.getGenero());
        }
    }
}

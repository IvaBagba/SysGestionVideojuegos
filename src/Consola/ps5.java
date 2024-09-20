package Consola;

import Videojuego.Videojuego;

import java.util.ArrayList;
import java.util.List;

public class ps5 extends consola  {
    List<Videojuego> juegosPS5 = new ArrayList<Videojuego>();

    public ps5(String plataforma) {
        super(plataforma);
    }

    @Override
    public void encender() {
        System.out.println("Hola Jugador PS5");
    }

    @Override
    public void apagar() {
        System.out.println("Adios Jugador PS5");
    }

    @Override
    public void instalarJuego(Videojuego juego) {

        if (juego.getPlataforma().equals(plataformas.PS5) && !juegosPS5.contains(juego)) {
            juegosPS5.add(juego);
            System.out.println("Juego agregado con exito " + "(" + juego.getNombre() +")");

            //Separador
            System.out.println("___");

        } else {
            System.out.println("Juego no agregado (Incompatible o Ya Instalado)" );

            //Separador
            System.out.println("___");
        }
    }

    @Override
    public void jugarJuego() {
        System.out.println("""
                Lista de juegos
                ---------------------------------------""");
        for (Videojuego juego : juegosPS5) {
            System.out.println(juego.getNombre()+ " " +juego.getPlataforma()+ " " + juego.getGenero());
        }
    }
}

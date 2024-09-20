package Consola;

import Videojuego.Videojuego;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class nsw extends consola {


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

        if (juego.getPlataforma().equals(plataformas.NSW) && !juegosNSW.contains(juego)) {
            juegosNSW.add(juego);
            System.out.println("Juego agregado con exito " + "(" + juego.getNombre() + ")");


            //Separador
            System.out.println("___");


            try {
                FileWriter guardarJuegos = new FileWriter("C:\\Users\\ivan\\IdeaProjects\\SysGestionVideojuegos\\juegos" + getPlataforma() + ".csv");
                guardarJuegos.write(juego.getNombre() + ',' + juego.getGenero() + ',' + juego.getPlataforma());
                guardarJuegos.append("\n");
                guardarJuegos.close();

                System.out.println("Juego guardado con exito");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else {
            System.out.println("Juego no agregado (Incompatible o Ya Instalado)");

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
            System.out.println(juego.getNombre() + " " + juego.getPlataforma() + " " + juego.getGenero());
        }
    }
}

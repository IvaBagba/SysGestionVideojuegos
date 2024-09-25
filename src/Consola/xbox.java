package Consola;

import Videojuego.Videojuego;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class xbox extends consola {
    List<Videojuego> juegosXBOX = new ArrayList<Videojuego>();

    {
        try {
            FileWriter guardarJuegos = new FileWriter("C:\\Users\\ivan\\IdeaProjects\\SysGestionVideojuegos\\juegos" + getPlataforma() + ".csv");
        } catch (IOException e) {
            System.out.println("Error Filewritter no creado");
        }
    }

    public xbox(String plataforma) {
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

        if (juego.getPlataforma().equals(plataformas.XBOX) && !juegosXBOX.contains(juego)) {
            juegosXBOX.add(juego);
            System.out.println("Juego agregado con exito " + "(" + juego.getNombre() +")");

            //Separador
            System.out.println("___");

            try {
                FileWriter guardarJuegos = new FileWriter("C:\\Users\\ivan\\IdeaProjects\\SysGestionVideojuegos\\juegos" + getPlataforma() + ".csv");
                guardarJuegos.append(juego.getNombre() + ',' + juego.getGenero() + ',' + juego.getPlataforma());
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
        for (Videojuego juego : juegosXBOX) {
            System.out.println(juego.getNombre()+ " " +juego.getPlataforma()+ " " + juego.getGenero());
        }
    }
}


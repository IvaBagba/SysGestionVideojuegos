package Consola;

import Videojuego.Videojuego;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nsw extends consola {


    List<Videojuego> juegosNSW = new ArrayList<Videojuego>();
    List<List<String>> juegosInstalados = new ArrayList<>();

    FileWriter guardarJuegos;

    BufferedReader leerJuego;

    {
        try {
            leerJuego = new BufferedReader(new FileReader("C:\\Users\\ivan\\IdeaProjects\\SysGestionVideojuegos\\juegos" + getPlataforma() + ".csv"));
            String datos;

            while ((datos = leerJuego.readLine()) != null){
                String[] valores = datos.split(",");
                juegosInstalados.add(Arrays.asList(valores));
            }
            System.out.println("Lista leida");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    {
        try {
            guardarJuegos = new FileWriter("C:\\Users\\ivan\\IdeaProjects\\SysGestionVideojuegos\\juegos" + getPlataforma() + ".csv",true);
            System.out.println("Lista creada");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

        boolean instalado = false;

        for (List<String> juegoInstalado : juegosInstalados) {
            if (juegoInstalado.get(0).equals(juego.getNombre())) {
                instalado = true;
            }
        }

        if (instalado == false) {

            if (juego.getPlataforma().equals(plataformas.NSW)) {
                juegosNSW.add(juego);

                try {

                    guardarJuegos.append(juego.getNombre()+","+juego.getGenero()+","+juego.getPlataforma()); //jojo jojo jojo
                    guardarJuegos.append("\n");
                    guardarJuegos.flush();

                    System.out.println(juego.getNombre());
                    System.out.println("Juego guardado con exito");
                } catch (IOException e) {
                    System.out.println("ERROR");
                }


            } else {
                System.out.println("Juego no agregado (Incompatible)");

                //Separador
                System.out.println("___");
            }
        } else {
            System.out.println("Juego no agregado (Ya Instalado)");

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

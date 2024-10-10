package Consola;

import Videojuego.Videojuego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class consola implements IConsola {

    private plataformas plataforma;

    List<Videojuego> juegosConsolas = new ArrayList<Videojuego>();
    List<List<String>> juegosInstalados = new ArrayList<>();

    String rutaCSV = "C:\\Users\\ivan\\IdeaProjects\\SysGestionVideojuegos\\juegos" + getPlataforma() + ".csv";

    FileWriter guardarJuegos;

    BufferedReader leerJuego;

    public consola(plataformas plataforma) {
        this.plataforma = plataforma;
    }

    public plataformas getPlataforma() {
        return plataforma;
    }

    public void crearArchivo(){
        if (Files.exists(Path.of(rutaCSV))) {
            System.out.println("Archivo Ya Creado");
            try {
                guardarJuegos = new FileWriter(rutaCSV,true);
                System.out.println("Lista abierta (Existente)");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Creando archivo");
            try {
                guardarJuegos = new FileWriter(rutaCSV);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Lista abierta (Creacion)");
        }
    }

    public void leerArchivo(){

        try {
            leerJuego = new BufferedReader(new FileReader(rutaCSV));
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


    public void encender() {
        System.out.println("Hola Jugador");
        crearArchivo();
        leerArchivo();
    }

    public void apagar() {
        System.out.println("Adios Jugador");
    }

    public void instalarJuego(Videojuego juego) {

        boolean instalado = false;

        instalado = comprobarJuegoInstalado(juego, instalado);

        guardarJuegoEnMemoria(juego, instalado);

        //Separador
        System.out.println("___");

    }

    private boolean comprobarJuegoInstalado(Videojuego juego, boolean instalado) {
        for (List<String> juegoInstalado : juegosInstalados) {
            if (juegoInstalado.get(0).equals(juego.getNombre())) {
                instalado = true;
            }
        }
        return instalado;
    }

    private void guardarJuegoEnMemoria(Videojuego juego, boolean instalado) {
        if (!instalado) {

            if (juego.getPlataforma().equals(getPlataforma())) {
                juegosConsolas.add(juego);

                try {

                    guardarJuegos.append(juego.getNombre()+","+ juego.getGenero()+","+ juego.getPlataforma()); //jojo jojo jojo
                    guardarJuegos.append("\n");
                    guardarJuegos.flush();

                    System.out.println(juego.getNombre());
                    System.out.println("Juego guardado con exito");
                } catch (IOException e) {
                    System.out.println("ERROR");
                }


            } else {
                System.out.println("Juego no agregado (Incompatible)");


            }
        } else {
            System.out.println("Juego no agregado (Ya Instalado)");

        }
    }

    public void jugarJuego() {
        System.out.println("""
                Lista de juegos
                ---------------------------------------""");
        for (List<String> juego : juegosInstalados) {
            System.out.println(juego.get(0) + " " + juego.get(1) + " " + juego.get(2));
        }
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


}

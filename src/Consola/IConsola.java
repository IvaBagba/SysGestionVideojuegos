package Consola;

import Videojuego.Videojuego;

public interface IConsola {
    public void encender();
    public void apagar();
    public void instalarJuego(Videojuego videojuego);
    public void jugarJuego();
    public String getPlataforma();

}

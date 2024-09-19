import Consola.nsw;
import Videojuego.VideojuegoDigital;
import Videojuego.VideojuegoFisico;
import Videojuego.generos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VideojuegoFisico tlot = new VideojuegoFisico("the legend of torrente",10,"NSW", generos.FPS);
        VideojuegoDigital insatisfactorio = new VideojuegoDigital("insatisfactorio",10,"PS5", generos.FPS);
        
        System.out.println(tlot.toString());
        tlot.calcPrecio();
        System.out.println(tlot.toString());
        tlot.calcPrecio();
        tlot.calcPrecio();
        tlot.calcPrecio();
        tlot.calcPrecio();

        nsw nSwitch = new nsw("NSW");
        nSwitch.instalarJuego(tlot);
        nSwitch.instalarJuego(insatisfactorio);

        nSwitch.jugarJuego();
    }
}
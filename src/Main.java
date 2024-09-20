import Consola.nsw;
import Consola.plataformas;
import Consola.xbox;
import Videojuego.VideojuegoDigital;
import Videojuego.VideojuegoFisico;
import Videojuego.generos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VideojuegoFisico tlot = new VideojuegoFisico("the legend of torrente",10, plataformas.NSW, generos.ACCION);
        VideojuegoDigital insatisfactorio = new VideojuegoDigital("insatisfactorio",10,plataformas.NSW, generos.PUZZLES);
        
        System.out.println(tlot.toString());

        System.out.println(insatisfactorio.toString());


        nsw nSwitch = new nsw("NSW");
        xbox xBox = new xbox("XBOX");

        nSwitch.instalarJuego(tlot);
        //nSwitch.instalarJuego(tlot);
        nSwitch.instalarJuego(insatisfactorio);

        //nSwitch.jugarJuego();
        //xBox.jugarJuego();
    }
}
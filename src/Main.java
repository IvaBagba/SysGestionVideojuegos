import Consola.consola;
import Consola.plataformas;
import Videojuego.VideojuegoDigital;
import Videojuego.VideojuegoFisico;
import Videojuego.generos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VideojuegoFisico tlot = new VideojuegoFisico("the legend of torrente",10, plataformas.NSW, generos.ACCION);
       VideojuegoDigital insatisfactorio = new VideojuegoDigital("insatisfactorio",10,plataformas.XBOX, generos.PUZZLES);
        VideojuegoFisico gtaXXV = new VideojuegoFisico("Grand thief auto 25",150,plataformas.PS5, generos.ROL);
        
        System.out.println(tlot.toString());

        //System.out.println(insatisfactorio.toString());


        consola nSwitch = new consola(plataformas.NSW);
        consola xbox = new consola(plataformas.XBOX);
        consola ps5 = new consola(plataformas.PS5);
        consola ds4 = new consola(plataformas.Ds4);

        nSwitch.encender();
        xbox.encender();
        ps5.encender();

        nSwitch.instalarJuego(tlot);
        nSwitch.instalarJuego(insatisfactorio);

        xbox.instalarJuego(insatisfactorio);
        xbox.instalarJuego(gtaXXV);

        ps5.instalarJuego(gtaXXV);
        ps5.instalarJuego(tlot);


        nSwitch.jugarJuego();
        xbox.jugarJuego();
    }
}

import presentacion.Modelo;

public class Launcher {

    private Modelo miApp;
    private Modelo miApp2;

    public Launcher() {
        miApp = new Modelo(); // composición
        miApp.iniciar();
    }

    public static void main(String[] args) {
        Launcher app = new Launcher();
    }

}

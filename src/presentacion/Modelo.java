package presentacion;

import logica.Semaforo;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import logica.SemaforoPeatonal;
import logica.Tarjeta;

public class Modelo implements Runnable {

    private ArrayList<Tarjeta> tarjetas;
    private Tarjeta tarjetaActiva;

    private Vista ventana;

    private String host = "localhost"; //127.0.0.1  , IP del servidor
    private int puerto = 5000;
    private Socket cliente;

    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;

    private volatile boolean lecturaActiva;
    private Thread hiloLectura;

    public void iniciar() {
        // codigo de inicio de app
        getVentana().setSize(445, 720);
        getVentana().setLocationRelativeTo(null);
        getVentana().setVisible(true);

        tarjetas = new ArrayList<Tarjeta>();

        lecturaActiva = true;
        hiloLectura = new Thread(this);

        try {
            conectar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Vista getVentana() {
        if (ventana == null) {
            ventana = new Vista(this);
        }
        return ventana;
    }

    public Tarjeta getTarjeta() {
        if (tarjetaActiva == null) {
            tarjetaActiva = tarjetas.get(0);
        }
        return tarjetaActiva;
    }

    public void procesarInformacion(String data) {
        // byte recibido tarjeta-|i|r|a|v|i|r|a|v|
        String[] datos = data.split("-");

        tarjetaActiva = tarjetas.get(Integer.parseInt(datos[0]));
        data = Integer.toBinaryString(Integer.parseInt(datos[1]));

        while (data.length() < 8) {
            data = "0" + data;
        }
        System.out.println("Binary data: " + data);

        // todo cambiar estado de leds
        for (int i = 0; i < data.length(); i++) {

            if (i == 0) {
                // TODO intermitente
            } else if (i == 1) {
                tarjetaActiva.cambioEstadoRojo(data.charAt(i));

            } else if (i == 2) {

            } else if (i == 3) {

            } else if (i == 4) {
                tarjetaActiva.changeGrupo(1);
            } else if (i == 5) {

            } else if (i == 6) {

            } else if (i == 7) {

            }
            data.charAt(i);
        }
        tarjetaActiva.changeGrupo(0);

    }

    public void procesarConfiguracion(String confString) {
        String[] conf = confString.split("-");
        for (int i = 0; i < conf.length; i++) {
            String confaux = conf[i];
            final Semaforo gprSemaforico[] = new Semaforo[2];
            if (confaux.charAt(0) == '0') { // Semaforo peatonal
                gprSemaforico[0] = new SemaforoPeatonal();
            } else { // Semaforo
                gprSemaforico[0] = new Semaforo();
            }

            /// TODO AGREGAR LEDS 
            if (confaux.charAt(1) == '0') { // Semaforo peatonal
                gprSemaforico[1] = new SemaforoPeatonal();
            } else { // Semaforo
                gprSemaforico[1] = new Semaforo();
            }

            AgregarSemaforo(i, gprSemaforico);
        }
//        ArrayList<Led> leds1 = new ArrayList<Led>();
//        leds1.add(new Led(getVentana().getLed1(), 0));
//        leds1.add(new Led(getVentana().getLed2(), 0));
//        leds1.add(new Led(getVentana().getLed3(), 0));
//
//        ArrayList<Led> leds2 = new ArrayList<Led>();
//        leds2.add(new Led(getVentana().getLed4(), 0));
//        leds2.add(new Led(getVentana().getLed5(), 0));
//        leds2.add(new Led(getVentana().getLed6(), 0));
//
//        sistema1.setLeds(leds1);
//        sistema2.setLeds(leds2);
    }

    public void AgregarSemaforo(int index, Semaforo[] gprSemaforico) {
        if (tarjetas.size() - 1 < index) {
            tarjetas.add(new Tarjeta(this));
        }
        tarjetas.get(index).setNewGrupo(gprSemaforico);
    }

//    void comprobarEstadoBotones() {
//        ArrayList<Led> leds = sistemaActivo.getLeds();
//
//        if (leds.get(0).getEstado() == 0) {
//            ventana.getBtnRojo().setIcon(ventana.getImgOff());
//        } else {
//            ventana.getBtnRojo().setIcon(ventana.getImgOn());
//        }
//
//        if (leds.get(1).getEstado() == 0) {
//            ventana.getBtnAmarillo().setIcon(ventana.getImgOff());
//        } else {
//            ventana.getBtnAmarillo().setIcon(ventana.getImgOn());
//        }
//
//        if (leds.get(2).getEstado() == 0) {
//            ventana.getBtnVerde().setIcon(ventana.getImgOff());
//        } else {
//            ventana.getBtnVerde().setIcon(ventana.getImgOn());
//        }
//
//    }
    public void conectar() throws IOException {
        //establecer conexion
        cliente = new Socket(host, puerto);

        //capturar los flujos
        datosEntrada = new DataInputStream(cliente.getInputStream());
        datosSalida = new DataOutputStream(cliente.getOutputStream());

        // COMUNICACION
        hiloLectura.start();
    }

    @Override
    public void run() {
        // Para almacenar lo que llegue del servidor
        byte buffer[];
        String conf;
        String data;
        String binaryData;

        while (lecturaActiva) {
            try {
                // lee lo que envía el server
                System.out.println("Esperando mensaje...");
                // Se queda acá, hasta que el servidor envíe algo
                conf = datosEntrada.readUTF();
                procesarConfiguracion(conf);

                for (;;) {
                    data = datosEntrada.readUTF();

                    procesarInformacion(data);

                    if (data == "-1") {
                        lecturaActiva = false;
                        break;
                    }
                }
            } catch (IOException ex) {
                System.out.println("error en la comunicación");
            }
        }

        // Finalizar
        try {
            datosEntrada.close();
            datosSalida.close();
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

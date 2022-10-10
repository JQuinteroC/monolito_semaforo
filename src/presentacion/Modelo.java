package presentacion;

import logica.Semaforo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import logica.Led;
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
        String[] datos = data.split(":");

        tarjetaActiva = tarjetas.get(Integer.parseInt(datos[0]));
        data = Integer.toBinaryString(Integer.parseInt(datos[1]));

        while (data.length() < 8) {
            data = "0" + data;
        }
        System.out.println("Binary data: " + data);

        // todo cambiar estado de leds
        for (int i = 0; i < data.length(); i++) {

            if (i == 0) {
                tarjetaActiva.intermitente(data.charAt(i), data.charAt(i + 1), data.charAt(i + 2), data.charAt(i + 3));
            } else if (i == 1) {
                tarjetaActiva.cambioEstadoRojo(data.charAt(i));
            } else if (i == 2) {
                tarjetaActiva.cambioEstadoAmarillo(data.charAt(i));
            } else if (i == 3) {
                tarjetaActiva.cambioEstadoVerde(data.charAt(i));
            } else if (i == 4) {
                tarjetaActiva.changeGrupo(1);
                tarjetaActiva.intermitente(data.charAt(i), data.charAt(i + 1), data.charAt(i + 2), data.charAt(i + 3));
            } else if (i == 5) {
                tarjetaActiva.cambioEstadoRojo(data.charAt(i));
            } else if (i == 6) {
                tarjetaActiva.cambioEstadoAmarillo(data.charAt(i));
            } else if (i == 7) {
                tarjetaActiva.cambioEstadoVerde(data.charAt(i));
            }
        }
        tarjetaActiva.changeGrupo(0);

    }

    public void procesarConfiguracion(String confString) {
        String[] conf = confString.split("-");
        int index = 0;
        int indexPeatonal = 0;
        for (int i = 0; i < conf.length; i++) {
            String confaux = conf[i];
            final Semaforo gprSemaforico[] = new Semaforo[2];
            if (confaux.charAt(0) == '0') { // Semaforo peatonal
                gprSemaforico[0] = new SemaforoPeatonal();

                ArrayList<Led> leds1 = new ArrayList<Led>();
                leds1.add(new Led(getVentana().getSemaforos().get(indexPeatonal).get(0), 0));
                leds1.add(new Led(getVentana().getSemaforos().get(indexPeatonal).get(1), 0));

                gprSemaforico[0].setLeds(leds1);
                indexPeatonal++;
            } else { // Semaforo
                gprSemaforico[0] = new Semaforo();

                ArrayList<Led> leds1 = new ArrayList<Led>();
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(0), 0));
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(1), 0));
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(2), 0));

                gprSemaforico[0].setLeds(leds1);
                index++;
            }

            /// TODO AGREGAR LEDS 
            if (confaux.charAt(1) == '0') { // Semaforo peatonal
                gprSemaforico[1] = new SemaforoPeatonal();

                ArrayList<Led> leds1 = new ArrayList<Led>();
                leds1.add(new Led(getVentana().getSemaforos().get(indexPeatonal).get(0), 0));
                leds1.add(new Led(getVentana().getSemaforos().get(indexPeatonal).get(1), 0));

                gprSemaforico[0].setLeds(leds1);
                indexPeatonal++;
            } else { // Semaforo
                gprSemaforico[1] = new Semaforo();

                ArrayList<Led> leds1 = new ArrayList<Led>();
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(0), 0));
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(1), 0));
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(2), 0));

                gprSemaforico[0].setLeds(leds1);
                index++;
            }

            AgregarSemaforo(i, gprSemaforico);
        }
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

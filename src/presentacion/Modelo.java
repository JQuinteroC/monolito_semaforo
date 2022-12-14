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
        getVentana().setSize(445, 630);
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

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public Tarjeta getTarjeta(int index) {
        return tarjetas.get(index);
    }

    public String procesarInformacion(String data) {
        // byte recibido tarjeta-|i|r|a|v|i|r|a|v|
        String[] datos = data.split("-");

        // tarjetaActiva = tarjetas.get(Integer.parseInt(datos[0]));
        // data = Integer.toBinaryString(datos[1]);
        // data = datos[1];
        // String[] datos = data.split(":");

         for (int j = 0; j < datos.length; j++) {
             String a = datos[j];
             String[] instruccion = a.split(":");
             tarjetaActiva = tarjetas.get(Integer.parseInt(instruccion[0]) - 1);
             tarjetaActiva.changeGrupo(0);
             data = instruccion[1];
             while (data.length() < 8) {
                 data = "0" + data;
             }
             for (int i = 0; i < data.length(); i++) {
                 if (i == 0) {
                     tarjetaActiva.intermitente(Character.getNumericValue(data.charAt(i)),
                             Character.getNumericValue(data.charAt(i + 1)),
                             Character.getNumericValue(data.charAt(i + 2)),
                             Character.getNumericValue(data.charAt(i + 3)));
                 } else if (i == 1) {
                     tarjetaActiva.cambioEstadoRojo(Character.getNumericValue(data.charAt(i)));
                 } else if (i == 2) {
                     tarjetaActiva.cambioEstadoAmarillo(Character.getNumericValue(data.charAt(i)));
                 } else if (i == 3) {
                     tarjetaActiva.cambioEstadoVerde(Character.getNumericValue(data.charAt(i)));
                 } else if (i == 4) {
                     tarjetaActiva.changeGrupo(1);
                     tarjetaActiva.intermitente(Character.getNumericValue(data.charAt(i)),
                                                Character.getNumericValue(data.charAt(i + 1)),
                                                Character.getNumericValue(data.charAt(i + 2)),
                                                Character.getNumericValue(data.charAt(i + 3)));
                 } else if (i == 5) {
                     tarjetaActiva.cambioEstadoRojo(Character.getNumericValue(data.charAt(i)));
                 } else if (i == 6) {
                     tarjetaActiva.cambioEstadoAmarillo(Character.getNumericValue(data.charAt(i)));
                 } else if (i == 7) {
                     tarjetaActiva.cambioEstadoVerde(Character.getNumericValue(data.charAt(i)));
                 }
             }
         }


        return calcularLedsEncendidos();
    }

    private String calcularLedsEncendidos() {
        String totalLedsEncendidos = "";
        for (Tarjeta tar : tarjetas) {
            totalLedsEncendidos += identificarLedsXGp(tar.getGprSemaforico1()) + ":" + identificarLedsXGp(tar.getGprSemaforico2()) + "/";
        }
        return totalLedsEncendidos;
    }

    private String identificarLedsXGp(ArrayList<Semaforo> semaforosGp) {
        int cantLedsRojos = 0;
        int cantLedsAmarillos = 0;
        int cantLedsVerdes = 0;
        for (Semaforo semaforo : semaforosGp) {
            ArrayList<Led> leds = semaforo.getLeds();
            if (leds.get(0).getEstado() == 1) {
                cantLedsRojos++;
            }
            if (leds.size() < 3) {
                if (leds.get(1).getEstado() == 1) {
                    cantLedsVerdes++;
                }
            } else {
                if (leds.get(1).getEstado() == 1) {
                    cantLedsAmarillos++;
                }
                if (leds.get(2).getEstado() == 1) {
                    cantLedsVerdes++;
                }
            }
        }
        return cantLedsRojos + "-" + cantLedsAmarillos + "-" + cantLedsVerdes;
    }

    public String procesarConfiguracion(String confString) {
        String[] conf = confString.split("-");
        int index = 0;
        int indexPeatonal = 0;
        int cantLedsRojos = 0;
        int cantLedsAmarillos = 0;
        int cantLedsVerdes = 0;
        String cantLedsCruce = "";

        for (int i = 0; i < conf.length; i++) {
            String confaux = conf[i];
            final Semaforo gprSemaforico[] = new Semaforo[2];
            if (confaux.charAt(0) == '0') { // Semaforo peatonal
                gprSemaforico[0] = new SemaforoPeatonal();

                ArrayList<Led> leds1 = new ArrayList<Led>();
                leds1.add(new Led(getVentana().getSemaforosPeatonales().get(indexPeatonal).get(0), 0));
                cantLedsRojos++;
                leds1.add(new Led(getVentana().getSemaforosPeatonales().get(indexPeatonal).get(1), 0));
                cantLedsVerdes++;

                gprSemaforico[0].setLeds(leds1);
                indexPeatonal++;
            } else { // Semaforo
                gprSemaforico[0] = new Semaforo();

                ArrayList<Led> leds1 = new ArrayList<Led>();
                // Led rojo
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(0), 0));
                cantLedsRojos++;
                // Led amarillo
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(1), 0));
                cantLedsAmarillos++;
                // Led verde
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(2), 0));
                cantLedsVerdes++;

                gprSemaforico[0].setLeds(leds1);
                index++;
            }
            cantLedsCruce += cantLedsRojos + "-" + cantLedsAmarillos + "-" + cantLedsVerdes + "-";
            cantLedsRojos = 0;
            cantLedsAmarillos = 0;
            cantLedsVerdes = 0;

            if (confaux.charAt(1) == '0') { // Semaforo peatonal
                gprSemaforico[1] = new SemaforoPeatonal();
                if(i == 2)
                    System.out.println("Semaforo peatonal asdasd");
                ArrayList<Led> leds1 = new ArrayList<Led>();
                leds1.add(new Led(getVentana().getSemaforosPeatonales().get(indexPeatonal).get(0), 0));
                cantLedsRojos++;
                leds1.add(new Led(getVentana().getSemaforosPeatonales().get(indexPeatonal).get(1), 0));
                cantLedsVerdes++;
                /*leds1.add(new Led(getVentana().getSemaforos().get(indexPeatonal).get(0), 0));
                leds1.add(new Led(getVentana().getSemaforos().get(indexPeatonal).get(1), 0));*/

                gprSemaforico[1].setLeds(leds1);
                indexPeatonal++;
            } else { // Semaforo
                gprSemaforico[1] = new Semaforo();

                ArrayList<Led> leds1 = new ArrayList<Led>();
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(0), 0));
                cantLedsRojos++;
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(1), 0));
                cantLedsAmarillos++;
                leds1.add(new Led(getVentana().getSemaforos().get(index).get(2), 0));
                cantLedsVerdes++;

                gprSemaforico[1].setLeds(leds1);
                index++;
            }
            cantLedsCruce += cantLedsRojos + "-" + cantLedsAmarillos + "-" + cantLedsVerdes + "-";
            cantLedsRojos = 0;
            cantLedsAmarillos = 0;
            cantLedsVerdes = 0;
            AgregarSemaforo(i, gprSemaforico);
        }
        return cantLedsCruce;
    }

    public void AgregarSemaforo(int index, Semaforo[] gprSemaforico) {
        if (tarjetas.size() - 1 < index) {
            tarjetas.add(new Tarjeta(this));
        }
        tarjetas.get(index).setNewGrupo(gprSemaforico);
    }

    public void conectar() throws IOException {
        try {
            // establecer conexion
            cliente = new Socket(host, puerto);

            // capturar los flujos
            datosEntrada = new DataInputStream(cliente.getInputStream());
            datosSalida = new DataOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error conectando");
            throw new RuntimeException(e);
        }

        try {
            String conf = null;
            // recibir configuracion
            conf = datosEntrada.readUTF();
            datosSalida.writeUTF(procesarConfiguracion(conf));
        } catch (IOException e) {
            System.out.println("Error en la comunicacion de configuracion.");
            throw new RuntimeException(e);
        }

        // COMUNICACION
        hiloLectura.start();
    }

    @Override
    public void run() {
        // Para almacenar lo que llegue del servidor
        String data;

        while (lecturaActiva) {
            try {
                // lee lo que env??a el server
                // Se queda ac??, hasta que el servidor env??e algo
                data = datosEntrada.readUTF();
                String infoProcesada = procesarInformacion(data);
                datosSalida.writeUTF(infoProcesada);

                if (data == "-1") {
                    lecturaActiva = false;
                    //break;
                }

            } catch (IOException ex) {
               // System.out.println("error en la comunicaci??n");
            }
        }

        desconectar();
    }

    private void desconectar() {
        // Finalizar
        try {
            datosEntrada.close();
            datosSalida.close();
            cliente.close();
        } catch (IOException e) {
            System.out.println("Error desconectando.");
            throw new RuntimeException(e);
        }
    }
}

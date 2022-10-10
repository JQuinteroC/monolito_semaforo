package logica;

import java.awt.Color;
import presentacion.Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Tarjeta {

    private Modelo modelo;

    private final ArrayList<Semaforo> gprSemaforico1;
    private final ArrayList<Semaforo> gprSemaforico2;
    private ArrayList<Semaforo> gprActivo;
    private int identificador;
    
    private Thread hilo;

    public Tarjeta(Modelo modelo) {
        this.modelo = modelo;
        gprSemaforico1 = new ArrayList<Semaforo>();
        gprSemaforico2 = new ArrayList<Semaforo>();
        gprActivo = gprSemaforico1;
    }

    public ArrayList<Semaforo> getGrupo() {
        return gprActivo;
    }

    public void changeGrupo(int index) {
        if (index == 0) {
            gprActivo = gprSemaforico1;
        } else if (index == 1) {
            gprActivo = gprSemaforico2;
        }
    }

    public void setNewGrupo(Semaforo[] gprSemaforico) {
        if (gprSemaforico1.isEmpty()) {
            for (int i = 0; i < gprSemaforico.length; i++) {
                Semaforo semaforo = gprSemaforico[i];
                gprSemaforico1.add(semaforo);
            }
        } else if (gprSemaforico2.isEmpty()) {
            for (int i = 0; i < gprSemaforico.length; i++) {
                Semaforo semaforo = gprSemaforico[i];
                gprSemaforico2.add(semaforo);
            }
        }
    }

    public void cambioEstadoRojo(int estado) {
        for (Iterator<Semaforo> iterator = gprActivo.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();
            semaforoActivo.cambioEstadoRojo(estado);
        }
    }

    public void cambioEstadoAmarillo(int estado) {
        for (Iterator<Semaforo> iterator = gprActivo.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();
            semaforoActivo.cambioEstadoAmarillo(estado);

        }
    }

    public void cambioEstadoVerde(int estado) {
        for (Iterator<Semaforo> iterator = gprSemaforico1.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();
            semaforoActivo.cambioEstadoVerde(estado);
        }
    }

    public void intermitente(int accion, int primerEstado, int segundoEstado, int tercerEstado) {
        System.out.println("Accion:" + accion);

        for (Iterator<Semaforo> iterator = gprSemaforico1.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();

            // Definir los objetos Runnable
            Runnable runnableRojo = new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (true) {
                        try {
                            Thread.sleep(100);
                            if (i == 0) {
                                semaforoActivo.cambioEstadoRojo(1);
                                System.out.println("Intermitencia Rojo: encendido");
                                i = 1;
                            } else {
                                semaforoActivo.cambioEstadoRojo(0);
                                System.out.println("Intermitencia Rojo: apagado");
                                i = 0;
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            // Definir los objetos Runnable
            Runnable runnableAmarillo = new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (true) {
                        try {
                            Thread.sleep(250);
                            if (i == 0) {
                                semaforoActivo.cambioEstadoAmarillo(1);
                                System.out.println("Intermitencia Amarillo: encendido");
                                i = 1;
                            } else {
                                semaforoActivo.cambioEstadoAmarillo(0);
                                System.out.println("Intermitencia Amarillo: apagado");
                                i = 0;
                            }
                            
                            break;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            // Definir los objetos Runnable
            Runnable runnableVerde = new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (true) {
                        try {
                            Thread.sleep(250);
                            if (i == 0) {
                                semaforoActivo.cambioEstadoVerde(1);
                                System.out.println("Intermitencia Verde: encendido");
                                i = 1;
                            } else {
                                semaforoActivo.cambioEstadoVerde(0);
                                System.out.println("Intermitencia Verde: apagado");
                                i = 0;
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            // Si es intermitente, definir que LED encender y apagar
            if (accion == 1) {
                System.out.println("Intermitente");
                if (primerEstado == 1) {
                    System.out.println("Rojo");

                    hilo = new Thread(runnableRojo);
                    hilo.start();
                    
                } else if (segundoEstado == 1) {
                    System.out.println("Amarillo");
                    hilo = new Thread(runnableAmarillo);
                    hilo.start();

                } else if (tercerEstado == 1) {
                    System.out.println("Verde");
                    hilo = new Thread(runnableVerde);
                    hilo.start();

                } else {
                    // DO NOTHING
                }

            } else {
                
                System.out.println("No es intermitente");
                hilo.stop();

            }

        }

    }
}

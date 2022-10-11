package logica;

import presentacion.Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Tarjeta {

    private Modelo modelo;

    public ArrayList<Semaforo> getGprSemaforico1() {
        return gprSemaforico1;
    }

    public ArrayList<Semaforo> getGprSemaforico2() {
        return gprSemaforico2;
    }

    private final ArrayList<Semaforo> gprSemaforico1;
    private final ArrayList<Semaforo> gprSemaforico2;
    private ArrayList<Semaforo> gprActivo;
    private int identificador;

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
        for (int i = 0; i < gprSemaforico.length; i++) {
            if (gprSemaforico1.isEmpty()) {
                Semaforo semaforo = gprSemaforico[i];
                gprSemaforico1.add(semaforo);

            } else if (gprSemaforico2.isEmpty()) {
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
        for (Iterator<Semaforo> iterator = gprActivo.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();
            semaforoActivo.cambioEstadoVerde(estado);
        }
    }

    public void intermitente(int accion, int primerEstado, int segundoEstado, int tercerEstado) {

        for (Iterator<Semaforo> iterator = gprActivo.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();

            // Definir los objetos Runnable
            Runnable runnableRojo = new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (true) {
                        try {
                            Thread.sleep(250);
                            if (i == 0) {
                                semaforoActivo.cambioEstadoRojo(1);
                                i = 1;
                            } else {
                                semaforoActivo.cambioEstadoRojo(0);
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
                                i = 1;
                            } else {
                                semaforoActivo.cambioEstadoAmarillo(0);
                                i = 0;
                            }

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
                                i = 1;
                            } else {
                                semaforoActivo.cambioEstadoVerde(0);
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
                if (primerEstado == 1) {
                    semaforoActivo.setHilo(new Thread(runnableRojo));
                    semaforoActivo.getHilo().start();
                } else if (segundoEstado == 1) {
                    semaforoActivo.setHilo(new Thread(runnableAmarillo));
                    semaforoActivo.getHilo().start();
                } else if (tercerEstado == 1) {
                    semaforoActivo.setHilo(new Thread(runnableVerde));
                    semaforoActivo.getHilo().start();
                } else {
                    // DO NOTHING
                }
            } else {
                semaforoActivo.setHilo(new Thread());
            }

        }

    }
}

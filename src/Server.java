import com.sun.source.tree.ArrayAccessTree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Server {

    private ServerSocket server;
    private Socket cliente;
    private int puerto;
    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;
    private boolean conectarActivo;
    private ArrayList<ArrayList<int []>> allCardsLeds = new ArrayList<>();

    public Server() {
        puerto = 5000;
        conectarActivo = true;
    }

    public void conectar() {

        // Crear el servidor
        try {
            server = new ServerSocket(puerto);
            while(conectarActivo){
                // Esperar a que alguien se conecte
                cliente = server.accept();
                // Alguien se conectó
                datosEntrada = new DataInputStream(cliente.getInputStream());
                datosSalida = new DataOutputStream(cliente.getOutputStream());
                datosSalida.writeUTF("11-11");
                String cantLeds = datosEntrada.readUTF();
                System.out.println("El server recibe:" + cantLeds);
                String[] leds = cantLeds.split("-");
                int[] ledsInt = null;
                ArrayList<int []> cardLeds = new ArrayList<>();
                for (int i = 0, j=0; i < leds.length; i++, j++) {
                    if (i % 3 == 0) {
                        if (i != 0) {
                            cardLeds.add(ledsInt);
                            if(cardLeds.size() == 2) {
                                allCardsLeds.add(cardLeds);
                                cardLeds = new ArrayList<>();
                            }
                        }
                        ledsInt = new int[3];
                        j = 0;
                    }
                    ledsInt[j] = Integer.parseInt(leds[i]);
                }
                    datosSalida.writeUTF("1:10100100");
                String ledsFuncionando = datosEntrada.readUTF();
                datosSalida.writeUTF("1:10100100");
                String ledsFuncionando3 = datosEntrada.readUTF();
                System.out.println("Server recibe: " + ledsFuncionando);
                // Deberia llergar 1-1-1:2-0-2
                String ledsFuncionando2 = "1-1-1:1-1-1";
                String ledsTarjeta[] = ledsFuncionando.split(":");
                int[] gpAux;
                int i = 0;
                int nroTarjeta = 0;
                boolean ledsWorks;
                for (String gp : ledsTarjeta) {
                    gpAux = Arrays.stream(gp.split("-")).mapToInt(num -> Integer.parseInt(num)).toArray();
                    System.out.println("Cant leds: ");
                    imp(allCardsLeds.get(nroTarjeta).get(i));
                    ledsWorks = Arrays.equals(allCardsLeds.get(nroTarjeta).get(i), gpAux);
                    System.out.println("Store cant leds: ");
                    imp(gpAux);
                    if (!ledsWorks) {
                        System.out.println("Led danado");
                        break;
                    }
                }

                datosSalida.close();
                server.close();
                System.out.println("Conexion terminada");
            }
        } catch (IOException e) {
            throw new RuntimeException(e + "Error en la conexion");
        }
    }

    public void imp(int[] array) {
        System.out.println("An array: ");
        for (int n : array) {
            System.out.println(n);
        }
    }
}
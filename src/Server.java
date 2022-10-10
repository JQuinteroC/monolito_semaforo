import com.sun.source.tree.ArrayAccessTree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
                System.out.println("Size" + leds.length);
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
                datosSalida.close();
                server.close();
                System.out.println("Conexion terminada");
            }
        } catch (IOException e) {
            throw new RuntimeException(e + "Error en la conexion");
        }



    }
}
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server;
    private Socket cliente;
    private int puerto;
    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;
    private boolean conectarActivo;

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
                datosSalida.writeUTF("1:10100100");
                String lectura = datosEntrada.readUTF();
                System.out.println("El server recibe:" + lectura);
                datosSalida.close();
                server.close();
                System.out.println("Conexion terminada");
            }
        } catch (IOException e) {
            throw new RuntimeException(e + "Error en la conexion");
        }



    }
}
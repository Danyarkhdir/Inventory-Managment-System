package Controller.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerMain {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5002)){
            while (true){
                new Server(serverSocket.accept()).start();
            }
        }catch (IOException e){
            System.out.println("Server Exception "+e.getMessage());
        }
    }
}

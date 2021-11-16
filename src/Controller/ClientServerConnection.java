package Controller;

import Model.Packet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientServerConnection {
    public static Socket socket;
    public static ObjectInputStream objectIn;
    public static ObjectOutputStream objectOut;
    public static void startConnection(){
        try{
            socket = new Socket("localhost",5002);
            socket.setTcpNoDelay(true);
            objectIn = new ObjectInputStream(socket.getInputStream());
            objectOut = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Connecting to server Successful");
        } catch (FileNotFoundException e) {
            System.out.println("File not found SocketController*");
        } catch (IOException e) {
            System.out.println("Error initializing stream"+e.getMessage());
        }
    }

    public static void stopConnection() {
        try {
            objectOut.writeObject(new Packet(0));
            objectOut.close();
            objectIn.close();
            socket.close();
        }catch (IOException e){
            System.out.println("IOException ClientServerController*stopConnection");
        }
    }

}

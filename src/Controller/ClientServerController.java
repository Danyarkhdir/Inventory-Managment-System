package Controller;

import Model.Packet;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ClientServerController<T> {

    public Packet<T> get(Packet<T> packet) {
        try{
            ClientServerConnection.objectOut.writeObject(packet);
            ClientServerConnection.objectOut.flush();
            Packet<T> response = (Packet<T>) ClientServerConnection.objectIn.readObject();
            int message = response.getMessage();
            if(message!=1){
                System.out.println("Error: " + message);
                return null;
            }
            return response;

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + packet.getMessage());
        } catch (IOException e) {
            System.out.println("Error initializing stream"+e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("NullPointerException #ClientServerController*openList");
        }
        return null;

    }

}

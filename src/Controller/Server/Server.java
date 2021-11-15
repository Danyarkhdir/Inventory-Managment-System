package Controller.Server;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

import Model.Costumer;
import Model.Item;
import Model.Packet;

public class Server extends Thread{
    private Socket socket;
    public Server(Socket socket){
        this.socket=socket;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void run() {

        try{
            System.out.println("Client Connected");
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            socket.setTcpNoDelay(true);
            Packet packet;

            while(true) {
                System.out.println("1");
                packet = (Packet) input.readObject();
                int packetMessage = packet.getMessage();
                System.out.println("Received Client input: " + packetMessage);
                if (packetMessage == 0) {
                    packet = new Packet(2);
                    break;
                } else {
                    packet = processPacket(packet);
                }
                System.out.println("Before OutputStream");
                outStream.writeObject(packet);
                outStream.flush();
            }
            outStream.writeObject(packet);
            outStream.close();
            input.close();
            socket.close();

        }catch (IOException e){
            System.out.println("IOException: "+e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Class Not Found Exception: "+e.getMessage());
        }
        System.out.println("Disconnected");

    }

    private Packet processPacket(Packet packet) {
        int packetMessage = packet.getMessage();
        if (packetMessage == 1) {
            SaveListToFile<Costumer> costumerSaveListToFile = new SaveListToFile<>("File/costumers.txt");
            LinkedList<Costumer> costumers = costumerSaveListToFile.openList();
            if (costumers.isEmpty()) {
                packet = new Packet(0);
            } else {
                packet = new Packet<Costumer>(1);
                packet.setItems(costumers);
            }
        } else if (packetMessage == 2) {
            SaveListToFile<Costumer> costomerSaveData = new SaveListToFile<>("File/costumers.txt");
            if (costomerSaveData.saveListToFile(packet.getItems())) {
                packet = new Packet<Costumer>(1);
            } else {
                packet = new Packet<Costumer>(0);
            }
        } else if (packetMessage == 3) {
            SaveListToFile<Item> itemsSaveListToFile = new SaveListToFile<>("File/items.txt");
            LinkedList<Item> items = itemsSaveListToFile.openList();
            if (items.isEmpty()) {
                packet = new Packet(0);
            } else {
                packet = new Packet<Item>(1);
                packet.setItems(items);
            }
        } else if (packetMessage == 4) {
            SaveListToFile<Item> itemsSaveListToFile = new SaveListToFile<>("File/items.txt");
            if (itemsSaveListToFile.saveListToFile(packet.getItems())) {
                packet = new Packet<Costumer>(1);
            } else {
                packet = new Packet<Costumer>(0);
            }
        } else if (packetMessage == 5) {
            SaveListToFile<Item> ordersSaveListToFile = new SaveListToFile<>("File/orders.txt");
            LinkedList<Item> orders = ordersSaveListToFile.openList();
            if (orders.isEmpty()) {
                packet = new Packet(0);
            } else {
                packet = new Packet<Costumer>(1);
                packet.setItems(orders);
            }
        } else if (packetMessage == 6) {
            SaveListToFile<Item> ordersSaveListToFile = new SaveListToFile<>("File/orders.txt");
            if (ordersSaveListToFile.saveListToFile(packet.getItems())) {
                packet = new Packet<Costumer>(1);
            } else {
                packet = new Packet<Costumer>(0);
            }
        }
        return packet;
    }
    
}
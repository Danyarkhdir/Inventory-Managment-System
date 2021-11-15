package Controller;
import Model.Costumer;
import Model.Item;
import Model.Order;

import java.util.*;
import java.io.*;
public class DataFile {

    public LinkedList<Order> orders =new LinkedList<>();
    public  boolean writeCostumerInFile(Costumer costumer){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\BAWAR CENTER\\Desktop\\javaProject\\Inventory-Managment-System\\Files\\costumers.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(costumer);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e){
            System.out.println("file not found.");
            return false;
        } catch (IOException e){
            System.out.println("initializing the stream failed for outputting.");
            return false;
        }
        return true;
    }

    public  boolean readCostumerFromFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\BAWAR CENTER\\Desktop\\javaProject\\Inventory-Managment-System\\Files\\costumers.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (true) {
                    try {
                        Costumer costumer = (Costumer) objectInputStream.readObject();
                        if (costumer != null) {
                            Costumers.costumers.add(costumer);
                        }
                    } catch (EOFException e){
                        return true;
                    }
                    objectInputStream.close(); 
                }
                
        } catch (FileNotFoundException e){
            System.out.println("file not found.");
            return false;
        } catch (IOException e){
            System.out.println("initializing the stream failed.");
            return false;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public  boolean writeOrderInFile(Order order){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\BAWAR CENTER\\Desktop\\javaProject\\Inventory-Managment-System\\Files\\orders.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(order);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e){
            System.out.println("file not found.");
            return false;
        } catch (IOException e){
            System.out.println("initializing the stream failed for outputting.");
            return false;
        }
        return true;
    }

    public  boolean readOrderFromFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\BAWAR CENTER\\Desktop\\javaProject\\Inventory-Managment-System\\Files\\orders.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (true) {
                    try {
                        Order order = (Order) objectInputStream.readObject();
                        if (order != null) {
                            orders.add(order);
                        }
                    } catch (EOFException e){
                        return true;
                    }
                    objectInputStream.close();
                }

        } catch (FileNotFoundException e){
            System.out.println("file not found.");
            return false;
        } catch (IOException e){
            System.out.println("initializing the stream failed.");
            return false;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public  boolean writeItemInFile(Item item){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\BAWAR CENTER\\Desktop\\javaProject\\Inventory-Managment-System\\Files\\item.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(item);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e){
            System.out.println("file not found.");
            return false;
        } catch (IOException e){
            System.out.println("initializing the stream failed for outputting.");
            return false;
        }
        return true;
    }

    public  boolean readItemFromFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\BAWAR CENTER\\Desktop\\javaProject\\Inventory-Managment-System\\Files\\items.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (true) {
                    try {
                        Item item = (Item) objectInputStream.readObject();
                        if (item != null) {
                            Items.items.add(item);
                        }
                    } catch (EOFException e){
                        return true;
                    }
                    objectInputStream.close();
                }

        } catch (FileNotFoundException e){
            System.out.println("file not found.");
            return false;
        } catch (IOException e){
            System.out.println("initializing the stream failed.");
            return false;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }



}


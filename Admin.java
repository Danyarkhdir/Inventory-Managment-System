import java.util.*;
import java.io.*;
public class Admin {
    private String username;
    private String password;
    LinkedList<Costumer> costumers =new LinkedList<>();
    LinkedList<Items> items =new LinkedList<>();
    LinkedList<Order> orders =new LinkedList<>();
    public Admin(){
        username="Admin";
        password="Admin";
    }
    public Admin(String username,String password){
        this.username=username;
        this.password=password;
    }
    public void addCostumer(Costumer costumer){
        int costumerindex = findCostumer(costumer.getCostumerId());
        if (costumerindex > -1) {
            System.out.println("costumer with  id [ "+costumer.getCostumerId()+" ] is already exist , cannot add");
        }
        else{
        System.out.println("costumer with id [ "+costumer.getCostumerId()+" ] added");
        if(writeCostumerInFile(costumer)){
            System.out.println("data saved to file successfully.");
        }
    
        if(readCostumerFromFile()){
            System.out.println("data read from file successfully.");
        }
    
        }
        
    }
    public void deleteCostumer(int costumerId) {
        int costumerindex = findCostumer(costumerId);
        if (costumerindex == -1) {
            System.out.println("no costumer with Id  : " + costumerId + " is available.\ndeleting costumer failed.");
        }
        else{
        costumers.remove(costumerindex);
        System.out.println("costumer with Id : " + costumerId + " was successfully deleted.");
        }

    }
    public void updateCostumer(Costumer costumer,Costumer updatedinfo){
        costumers.set(costumers.indexOf(costumer), updatedinfo);
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
   

    private int findCostumer(int costumerId){
    for (int i = 0; i < costumers.size(); i++) {
        Costumer costumer=costumers.get(i);
        if (costumer.getCostumerId()==costumerId) {
           return i; 
        }
    }
        return -1;
    }

    public  boolean writeCostumerInFile(Costumer costumer){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\costumers.txt");
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
            FileInputStream fileInputStream = new FileInputStream("D:\\costumers.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (true) {
                    try {
                        Costumer costumer = (Costumer) objectInputStream.readObject();
                        if (costumer != null) {
                            costumers.add(costumer);
                        }
                    } catch (EOFException e){
                        return true;
                    }
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



    public void addOrder(Order order){
        int orderIndex = findOrder(order.getOrderId());
        if (orderIndex > -1) {
            System.out.println("order with  id [ "+order.getOrderId()+" ] is already exist , cannot add");
        }
        else{
        System.out.println("order with id [ "+order.getOrderId()+" ] added");
        if(writeOrderInFile(order)){
            System.out.println("data saved to file successfully.");
        }
    
        if(readOrderFromFile()){
            System.out.println("data read from file successfully.");
        }
    
        }
        
    }
    public void deleteOrder(int orderId) {
        int orderIndex = findOrder(orderId);
        if (orderIndex == -1) {
            System.out.println("no Order with Id  : " + orderId + " is available.\ndeleting Order failed.");
        }
        else{
        costumers.remove(orderIndex);
        System.out.println("Order with Id : " + orderId + " was successfully deleted.");
        }

    }


    
    public  boolean writeOrderInFile(Order order){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\orders.txt");
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
            FileInputStream fileInputStream = new FileInputStream("D:\\orders.txt");
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

    private int findOrder(int orderId){
        for (int i = 0; i < orders.size(); i++) {
            Order order=orders.get(i);
            if (order.getOrderId()==orderId) {
               return i; 
            }
        }
            return -1;
        }

        
    public void addItem(Items item){
        int itemIndex = findItem(item.getItemId());
        if (itemIndex > -1) {
            System.out.println("Item with  id [ "+item.getItemId()+" ] is already exist , cannot add");
        }
        else{
        System.out.println("Item with id [ "+item.getItemId()+" ] added");
        if(writeItemInFile(item)){
            System.out.println("data saved to file successfully.");
        }
    
        if(readItemFromFile()){
            System.out.println("data read from file successfully.");
        }
    
        }
        
    }
    public void deleteItem(int itemId) {
        int itemIndex = findItem(itemId);
        if (itemIndex == -1) {
            System.out.println("no Item with Id  : " + itemId + " is available.\ndeleting Item failed.");
        }
        else{
        costumers.remove(itemIndex);
        System.out.println("Item with Id : " + itemId + " was successfully deleted.");
        }

    }


    
    public  boolean writeItemInFile(Items item){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\items.txt");
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
            FileInputStream fileInputStream = new FileInputStream("D:\\items.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (true) {
                    try {
                        Items item = (Items) objectInputStream.readObject();
                        if (item != null) {
                            items.add(item);
                        }
                    } catch (EOFException e){
                        return true;
                    }
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

    private int findItem(int itemId){
        for (int i = 0; i < items.size(); i++) {
            Items item=items.get(i);
            if (item.getItemId()==itemId) {
               return i; 
            }
        }
            return -1;
        }
    
    
   
    public String toString() {
        return "[ Username : "+username+" ] is Admin Now";
    }
}
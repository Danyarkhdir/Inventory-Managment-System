package Controller;
import Model.Costumer;
import Model.Item;
import Model.Order;
import Model.Packet;

import java.util.*;


public class Orders {
    public static LinkedList<Item> orderedItems =new LinkedList<>();
    public static ClientServerController<Item> orderController = new ClientServerController<>();

    public void fetchAndSetOrders(){
        Packet<Item> packet = orderController.get(new Packet<>(5));
        orderedItems= packet.getItems();
    }
    public void setOrders(){
        Packet<Item> packet = new Packet<>(6);
        packet.setItems(orderedItems);
        orderController.get(packet);
    }

    public static void addItemtoOrder(Item item){
        if (Items.findItem(item.getItemId())==-1) {
            System.out.println("No Item Found ");
        } else {
            orderedItems.add(item);
        }
        
    }
    public static void deleteItemFromOrder(Item item){
        if (findItemInOrder(item.getItemId())==-1) {
            System.out.println("Costumer was not order that Item");
        }
        else{
            orderedItems.add(item);
        }
    }

    public static void totalPrice(){
        double totalprice =0;
        for (int i = 0; i < orderedItems.size(); i++) {
            totalprice+= orderedItems.get(i).getItemPrice();
        }
        System.out.println("Total price = "+totalprice+" IQD");

    }

    public static int findItemInOrder(int itemId){
        for (int i = 0; i < orderedItems.size(); i++) {
            Item item = orderedItems.get(i);
            if (item.getItemId()==itemId) {
               return i; 
            }
        }
            return -1;
        }
}
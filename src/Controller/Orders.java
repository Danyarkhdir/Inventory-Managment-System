package Controller;
import Model.Item;
import Model.Packet;

import java.util.*;


public class Orders {
    public static LinkedList<Item> orderedItems =new LinkedList<>();
    public static ClientServerController<Item> orderController = new ClientServerController<>();

    public static void fetchAndSetOrders(){
        Packet<Item> packet = orderController.get(new Packet<>(5));
        orderedItems= packet.getItems();
    }
    public static  void saveOrders(){
        Packet<Item> packet = new Packet<>(6);
        packet.setItems(orderedItems);
        orderController.get(packet);
    }

    public static void addItemtoOrder(Item item){
        fetchAndSetOrders();
        if (Items.findItem(item.getItemId())==-1) {
            System.out.println("No Item Found ");
        } else {
            orderedItems.add(item);
            saveOrders();
        }
        
    }
    public static void deleteItemFromOrder(Item item){
        fetchAndSetOrders();
        if (findItemInOrder(item.getItemId())==-1) {
            System.out.println("Costumer was not order that Item");
        }
        else{
            orderedItems.remove(item);
            saveOrders();
        }
    }

    public static void totalPrice(){
        fetchAndSetOrders();
        double totalprice =0;
        for (Item orderedItem : orderedItems) {
            totalprice += orderedItem.getItemPrice();
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
package Controller;
import Model.Costumer;
import Model.Item;
import Model.Packet;

import java.util.*;

public class Items {
    public static ClientServerController<Item> itemController = new ClientServerController<>();
    public static LinkedList<Item> items =new LinkedList<>();
    public static boolean additem;
    public static boolean delitem;

    public void fetchAndSetItems(){
        Packet<Item> packet = itemController.get(new Packet<>(3));
        items= packet.getItems();
    }

    public void setItems(){
        Packet<Item> packet = new Packet<>(4);
        packet.setItems(items);
        itemController.get(packet);
    }




    public static void addItem(Item item){
        int itemIndex = findItem(item.getItemId());
        if (itemIndex > -1) {
            System.out.println("Item with  id [ "+ item.getItemId()+" ] is already exist , cannot add");
            additem=false;
        }
        else{
        Items.items.add(item);
        System.out.println("Item with id [ "+ item.getItemId()+" ] added");
        additem=true;
        }
        
    }
    public static void deleteItem(int itemId) {
        int itemIndex = findItem(itemId);
        if (itemIndex == -1) {
            System.out.println("no Item with Id  : " + itemId + " is available.\ndeleting Item failed.");
            delitem=false;
        }
        else{
        System.out.println("Item with Id : " + itemId + " was successfully deleted.");
        items.remove(itemIndex);
        delitem=true;
        }

    }
    public static Item updateItem(Item itm){
        return items.set(findItem(itm.getItemId()), itm);
    }
    public static int findItem(int itemId){
        for (int i = 0; i < items.size(); i++) {
            Item item = Items.items.get(i);
            if (item.getItemId()==itemId) {
               return i; 
            }
        }
            return -1;
        }
    
}

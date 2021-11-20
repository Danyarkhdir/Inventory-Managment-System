package Controller;
import Model.Item;
import Model.Packet;

import java.util.*;

public class Items {
    public static ClientServerController<Item> itemController = new ClientServerController<>();
    public static LinkedList<Item> items =new LinkedList<>();
    public static boolean additem;
    public static boolean delitem;

    public static void fetchAndSetItems(){
        Packet<Item> packet = itemController.get(new Packet<>(3));
        if(packet!=null)
        items= packet.getItems();
    }

    public static void saveItems(){
        Packet<Item> packet = new Packet<>(4);
        packet.setItems(items);
        itemController.get(packet);
    }




    public static void addItem(Item item){
        fetchAndSetItems();
        int itemIndex = findItem(item.getItemId());
        if (itemIndex > -1) {
            System.out.println("Item with  id [ "+ item.getItemId()+" ] is already exist , cannot add");
            additem=false;
        }
        else{
        items.add(item);
        System.out.println("Item with id [ "+ item.getItemId()+" ] added");
        additem=true;
        saveItems();
        }
        
    }
    public static void deleteItem(int itemId) {
        fetchAndSetItems();
        int itemIndex = findItem(itemId);
        if (itemIndex == -1) {
            System.out.println("no Item with Id  : " + itemId + " is available.\ndeleting Item failed.");
            delitem=false;
        }
        else{
        System.out.println("Item with Id : " + itemId + " was successfully deleted.");
        items.remove(itemIndex);
        delitem=true;
        saveItems();
        }

    }
    public static Item updateItem(Item itm){
        return items.set(findItem(itm.getItemId()), itm);
    }
    public static int findItem(int itemId){
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getItemId()==itemId) {
               return i; 
            }
        }
            return -1;
        }
    
}

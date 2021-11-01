package Controller;
import java.util.*;
import Models.Items;


public class Orders {
    public static LinkedList<Items> OrderedItems=new LinkedList<>();

    public static void addItemtoOrder(Items item){
        if (Item.findItem(item.getItemId())==-1) {
            System.out.println("No Item Found ");
        } else {
            OrderedItems.add(item);
        }
        
    }
    public static void deleteItemFromOrder(Items item){
        if (findItemInOrder(item.getItemId())==-1) {
            System.out.println("Costumer was not order that Item");
        }
        else{
            OrderedItems.add(item);
        }
    }

    public static void totalPrice(){
        double totalprice =0;
        for (int i = 0; i < OrderedItems.size(); i++) {
            totalprice+=OrderedItems.get(i).getItemPrice();
        }
        System.out.println("Total price = "+totalprice+" IQD");

    }

    public static int findItemInOrder(int itemId){
        for (int i = 0; i < OrderedItems.size(); i++) {
            Items item=OrderedItems.get(i);
            if (item.getItemId()==itemId) {
               return i; 
            }
        }
            return -1;
        }
}
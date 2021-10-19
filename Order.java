import java.util.ArrayList;
import java.io.*;
public class Order implements Serializable{
    private int orderId;
    private Items itemInfo;
    ArrayList<Items> items=new ArrayList<>();
    public Order(){
        orderId=0;
        itemInfo=new Items();
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getOrderId() {
        return orderId;
    }
    public Order(int orderId,Items itemInfo){
        this.orderId=orderId;
        this.itemInfo=itemInfo;
        
    }
    public void setItemInfo(Items itemInfo) {
        this.itemInfo = itemInfo;
    }
    public Items getItemInfo() {
        return itemInfo;
    }
    public void addItemToOrder(Items item){
        items.add(item);
    }
    public void deleteItemFromOrder(int itemId){
        int itemIndex=findItem(itemId);
        if (itemIndex == -1) {
            System.out.println("no item with Id  : " + itemId + " is available in this order.");
        }
        else{
        items.remove(itemIndex);
        System.out.println("item with Id : " + itemId + " was successfully removed from order.");
        }

    }
    public void updateItemInOrder(int itemId,Items updatedinfo){
        items.set(items.indexOf(itemId), updatedinfo);
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
        double itemsprices=0;
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
            itemsprices+=items.get(i).getItemPrice();
        }
        return "\nTotal Price  = "+itemsprices;
        
    }
}

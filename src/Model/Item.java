package Model;
import java.io.Serializable;

public class Item implements Serializable {
    private int itemId;
    private String itemName;
    private double itemPrice;

    public Item(){
    }
    public Item(int itemId, String itemName, double itemPrice){
        this.itemId=itemId;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }
    public String toString() {
        return "Item Id : "+itemId+"\nItem Name : "+itemName+"\nItem Price : "+itemPrice+"\n\n";
    }
    
        
    
    


    
}

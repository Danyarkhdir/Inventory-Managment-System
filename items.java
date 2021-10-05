public class items {
    private int itemId;
    private String itemName;
    private String itemBrand;
    private double itemPrice;
    public items(){
        itemId=0;
        itemName="No Name";
        itemBrand
="No Brunch";
        itemPrice=0.0;
    }
    public items(int itemId,String itemName,String itemBrand,double itemPrice){
        this.itemId=itemId;
        this.itemName=itemName;
        this.itemBrand=itemBrand;
        this.itemPrice=itemPrice;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemBrunch(String itemBrand) {
        this.itemBrand
 = itemBrand
;
    }
    public String getItemBrunch() {
        return itemBrand
;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public String toString() {
        return "Item Id : "+itemId+"\nItem Name : "+itemName+"\nBrand : "+itemBrand+"\nItems Price : "+itemPrice;
    }
    


    
}

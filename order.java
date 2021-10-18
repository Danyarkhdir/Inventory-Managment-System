public class Order {
    private Costumer costumerInfo;
    private Items itemInfo;
    private int numOfItems;
    public Order(){
        costumerInfo=new Costumer();
        itemInfo=new Items();
    }
    public Order(Costumer CostumerInfo,Items itemInfo,int numberOfItems){
        this.costumerInfo=CostumerInfo;
        this.itemInfo=itemInfo;
        this.numOfItems=numberOfItems;
    }
    public void setcostumerInfo(Costumer costumerInfo) {
        this.costumerInfo = costumerInfo;
    }
    public Costumer getcostumerInfo() {
        return costumerInfo;
    }
    public void setItemInfo(Items itemInfo) {
        this.itemInfo = itemInfo;
    }
    public Items getItemInfo() {
        return itemInfo;
    }
    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
    public int getNumOfItems() {
        return numOfItems;
    }
    
    public String toString() {
        return costumerInfo.toString()+"\n"+itemInfo.toString()+"\nNumber of Items : "+numOfItems;
    }
}

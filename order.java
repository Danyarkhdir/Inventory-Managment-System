public class order {
    private costumer cosntumerInfo;
    private items itemInfo;
    private int numOfItems;
    public order(){
        cosntumerInfo=new costumer();
        itemInfo=new items();
    }
    public order(costumer costumerInfo,items itemInfo,int numberOfItems){
        this.cosntumerInfo=costumerInfo;
        this.itemInfo=itemInfo;
        this.numOfItems=numberOfItems;
    }
    public void setCosntumerInfo(costumer cosntumerInfo) {
        this.cosntumerInfo = cosntumerInfo;
    }
    public costumer getCosntumerInfo() {
        return cosntumerInfo;
    }
    public void setItemInfo(items itemInfo) {
        this.itemInfo = itemInfo;
    }
    public items getItemInfo() {
        return itemInfo;
    }
    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
    public int getNumOfItems() {
        return numOfItems;
    }
    
    public String toString() {
        return cosntumerInfo.toString()+"\n"+itemInfo.toString()+"\nNumber of Items : "+numOfItems;
    }
}

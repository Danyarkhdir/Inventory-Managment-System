
public class Admin {
    private String username;
    private String password;

    DataFile dataFile = new DataFile();
    public Admin(){
        username="Admin";
        password="Admin";
    }
    public Admin(String username,String password){
        this.username=username;
        this.password=password;
    }
    public void addCostumer(Costumer costumer){
        int costumerindex = findCostumer(costumer.getCostumerId());
        if (costumerindex > -1) {
            System.out.println("costumer with  id [ "+costumer.getCostumerId()+" ] is already exist , cannot add");
        }
        else{
        System.out.println("costumer with id [ "+costumer.getCostumerId()+" ] added");
        if(dataFile.writeCostumerInFile(costumer)){
            System.out.println("data saved to file successfully.");
        }
    
        if(dataFile.readCostumerFromFile()){
            System.out.println("data read from file successfully.");
        }
    
        }
        
    }
    public void deleteCostumer(int costumerId) {
        int costumerindex = findCostumer(costumerId);
        if (costumerindex == -1) {
            System.out.println("no costumer with Id  : " + costumerId + " is available.\ndeleting costumer failed.");
        }
        else{
        dataFile.costumers.remove(costumerindex);
        System.out.println("costumer with Id : " + costumerId + " was successfully deleted.");
        }

    }
    public void updateCostumer(Costumer costumer,Costumer updatedinfo){
        dataFile.costumers.set(dataFile.costumers.indexOf(costumer), updatedinfo);
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
   
    private int findCostumer(int costumerId){
    for (int i = 0; i < dataFile.costumers.size(); i++) {
        Costumer costumer=dataFile.costumers.get(i);
        if (costumer.getCostumerId()==costumerId) {
           return i; 
        }
    }
        return -1;
    }

    public void addOrder(Order order){
        int orderIndex = findOrder(order.getOrderId());
        if (orderIndex > -1) {
            System.out.println("order with  id [ "+order.getOrderId()+" ] is already exist , cannot add");
        }
        else{
        System.out.println("order with id [ "+order.getOrderId()+" ] added");
        if(dataFile.writeOrderInFile(order)){
            System.out.println("data saved to file successfully.");
        }
    
        if(dataFile.readOrderFromFile()){
            System.out.println("data read from file successfully.");
        }
    
        }
        
    }
    public void deleteOrder(int orderId) {
        int orderIndex = findOrder(orderId);
        if (orderIndex == -1) {
            System.out.println("no Order with Id  : " + orderId + " is available.\ndeleting Order failed.");
        }
        else{
        dataFile.costumers.remove(orderIndex);
        System.out.println("Order with Id : " + orderId + " was successfully deleted.");
        }

    }

    private int findOrder(int orderId){
        for (int i = 0; i < dataFile.orders.size(); i++) {
            Order order=dataFile.orders.get(i);
            if (order.getOrderId()==orderId) {
               return i; 
            }
        }
            return -1;
        }

    public void addItem(Items item){
        int itemIndex = findItem(item.getItemId());
        if (itemIndex > -1) {
            System.out.println("Item with  id [ "+item.getItemId()+" ] is already exist , cannot add");
        }
        else{
        System.out.println("Item with id [ "+item.getItemId()+" ] added");
        if(dataFile.writeItemInFile(item)){
            System.out.println("data saved to file successfully.");
        }
    
        if(dataFile.readItemFromFile()){
            System.out.println("data read from file successfully.");
        }
    
        }
        
    }
    public void deleteItem(int itemId) {
        int itemIndex = findItem(itemId);
        if (itemIndex == -1) {
            System.out.println("no Item with Id  : " + itemId + " is available.\ndeleting Item failed.");
        }
        else{
        dataFile.costumers.remove(itemIndex);
        System.out.println("Item with Id : " + itemId + " was successfully deleted.");
        }

    }
    private int findItem(int itemId){
        for (int i = 0; i < dataFile.items.size(); i++) {
            Items item=dataFile.items.get(i);
            if (item.getItemId()==itemId) {
               return i; 
            }
        }
            return -1;
        }
    public String toString() {
        return "[ Username : "+username+" ] is Admin Now";
    }
}
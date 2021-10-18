public class Bill {
    Order order;
    public double totalPrice;
    public Bill(){
        order=new Order();
        totalPrice=0;
    }
    public Bill(Order order){
        this.order=order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Order getOrder() {
        return order;
    }
    public double totalCalc(){
        return order.getNumOfItems()*order.getItemInfo().getItemPrice();
    }

    public String toString() {
        return order.toString()+"\nTotal Price = "+totalCalc()+" IQD";
    }
}

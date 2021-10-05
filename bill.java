public class bill {
    order Order;
    public double totalPrice;
    public bill(){
        Order=new order();
        totalPrice=0;
    }
    public bill(order Order){
        this.Order=Order;
    }
    public void setOrder(order order) {
        Order = order;
    }
    public order getOrder() {
        return Order;
    }
    public double totalCalc(){
        return Order.getNumOfItems()*Order.getItemInfo().getItemPrice();
    }

    public String toString() {
        return Order.toString()+"\nTotal Price = "+totalCalc()+" IQD";
    }
}

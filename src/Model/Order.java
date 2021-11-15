package Model;
import java.io.*;
public class Order implements Serializable{
    private int orderId;
    public Order(){
    }  
    public Order(int orderId){
        this.orderId=orderId;
    }
    
    public int getOrderId() { return orderId; }
   
  
    
    public String toString() {
       return "Order Id : "+orderId;
        
    }
}

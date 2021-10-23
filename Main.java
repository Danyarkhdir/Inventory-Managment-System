import java.util.*;
public class Main{
    public static void main(String[] args) {
    Admin admin1=new Admin("arman","132435");
    Order order1=new Order();
    admin1.addItem(new Items(13, "USB", 10000));
    admin1.addCostumer(new Costumer(11, "ahmad", "122343", "bile"));
    admin1.addOrder(order1);
    order1.addItemToOrder(new Items(1, "Pc", 200000));
    order1.addItemToOrder(new Items(13,"headset",25000));
    System.out.println(admin1);
    System.out.println(order1);
    
    

    }
}

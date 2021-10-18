import java.util.*;
public class Main{
    public static void main(String[] args) {
    Admin admin1=new Admin("Shadya","132435");
    Order order1=new Order();
    admin1.addOrder(order1);
    order1.addItemToOrder(new Items(1, "Pc", 200000));
    order1.addItemToOrder(new Items(13,"headset",25000));
    System.out.println(admin1);
    System.out.println(order1);
    
    

    }
}

package View;
import Controller.*;
import java.util.Scanner;
public class OrderView {
static Scanner sc = new Scanner(System.in);
public static void orderView(){
    boolean bol=true;
    while (bol) {
    System.out.print("Choose an Option : ");
    int choice=sc.nextInt();
    switch (choice) {
        case 1->addItemtoOrder();
        case 2->deleteItemFromOrder();
        case 3->AdminView.availableItems(); 
        case 4 -> showOrder();
        case 5 ->Orders.totalPrice();
        case 6 ->options();
        case 0 -> bol=false;
        default -> System.out.println("No Options with this number"); 
    }
}
}
    public static void options() {
        System.out.println("1. Add item to Order");
        System.out.println("2. remove item from Order");
        System.out.println("3. show available items");
        System.out.println("4. show current order");
        System.out.println("5. TotalPrice");
        System.out.println("6. Options");
        System.out.println("0. Exit");
    }
    public static void addItemtoOrder(){
        System.out.println("Enter Item Id : ");
        int itemId=sc.nextInt();
        if(Item.findItem(itemId)!=-1)
        Orders.addItemtoOrder(Item.items.get(Item.findItem(itemId))); 
        else
        System.out.println("No Item with this ID");
    }

    public static void deleteItemFromOrder() {
        System.out.println("Enter Item Id : ");
        int itemId=sc.nextInt();
        if(Item.findItem(itemId)!=-1)
        Orders.deleteItemFromOrder(Item.items.get(Item.findItem(itemId)));
        else
        System.out.println("No Item with this ID");
        
    }

    public static void showOrder() {
        System.out.println(Orders.OrderedItems);
    }

}

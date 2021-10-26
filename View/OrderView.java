package View;
import Models.*;

import java.util.Scanner;

import Controller.*;
public class OrderView {
static Scanner sc = new Scanner(System.in);
public static void orderView(){
    boolean bol=true;
    while (bol) {
    System.out.print("Choose an Option : ");
    int choice=sc.nextInt();
    switch (choice) {
        case 1:
            addItemtoOrder();
            break;
        case 2:
            deleteItemFromOrder();
            break;
        case 3:
            AdminView.availableItems();
            break;
        case 4:
            showOrder();
            break;
        case 5:
            options();
            break;
        case 0:
            bol=false;
            break;
        default:
        System.out.println("No Options with this number");
            break;
    }
}
}
    public static void options() {
        System.out.println("1. Add item to Order");
        System.out.println("2. remove item from Order");
        System.out.println("3. show available items");
        System.out.println("4. show current order");
        System.out.println("5. Options");
        System.out.println("0. Exit");
    }
    public static void addItemtoOrder(){
        System.out.println("Enter Item Id : ");
        int itemId=sc.nextInt();
        Orders.addItemtoOrder(Item.items.get(Item.findItem(itemId))); 
    }

    public static void deleteItemFromOrder() {
        System.out.println("Enter Item Id : ");
        int itemId=sc.nextInt();
        Orders.deleteItemFromOrder(Item.items.get(Item.findItem(itemId)));
    }

    public static void showOrder() {
        System.out.println(Orders.OrderedItems);
    }

}

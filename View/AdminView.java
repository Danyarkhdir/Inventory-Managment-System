package View;
import java.util.Scanner;
import Controller.*;
import Models.Costumer;
import Models.Items;

public class AdminView {
    public AdminView(){

    }
    
   public static Scanner scanner=new Scanner(System.in);

   public  static void login (){
    boolean bol=true;
    int choice;
       while (bol) {
           System.out.print("Choose a Choice : ");
           choice=scanner.nextInt();
           switch (choice) {
              case 1 -> actions();
              case 2 -> addNewCostumer();
              case 3 -> deleteCostumer();
              case 4 -> updateCostumer();
              case 5 -> viewCostumers();
              case 6 -> addItem();
              case 7 -> deleteItem();
              case 8 -> updateCostumer();
              case 9 -> availableItems();
              case 0 -> System.exit(0);
              default -> System.out.println("Please choose from 0 to 9");
           }
       }


   }

   public static void actions() {
       System.out.println("1. Actions");
       System.out.println("2. Add New Costumer");
       System.out.println("3. Delete Costumer");
       System.out.println("4. Update Costumer Info");
       System.out.println("5. View Costumers");
       System.out.println("6. Add new Item");
       System.out.println("7. Delete Item ");
       System.out.println("8. Update Costumer Info");
       System.out.println("9. View Available Items ");
       System.out.println("0. Quit");
   }

   public static void addNewCostumer(){
     System.out.print("Enter Id : ");
     int id = scanner.nextInt();
     System.out.print("Enter Name : ");
     String name = scanner.next();
     System.out.print("Enter Phone Number : ");
     String phone = scanner.next();
     System.out.print("Enter Address : ");
     String address = scanner.next();
     Costumers.addCostumer(new Costumer(id,name,phone,address));
     OrderView.orderView();
   }
   public static void deleteCostumer(){
       System.out.print("Enter Id of Costumer : ");
       int costumerId=scanner.nextInt();
       Costumers.deleteCostumer(costumerId);
   }
   public static void updateCostumer() {
       System.out.print("Enter Costumer Id that you want to change : ");
       int costumerId=scanner.nextInt();
       if(Costumers.findCostumer(costumerId)==-1){
        System.out.println("Costumer with id [ "+costumerId+" ] not found.");
       }
       else{
        System.out.print("Enter Name : ");
        String name = scanner.next();
        System.out.print("Enter Phone Number : ");
        String phone = scanner.next();
        System.out.print("Enter Address : ");
        String address = scanner.next();
        Costumer costumer=new Costumer(costumerId, name, phone, address);
         Costumers.updateCostumer(costumer);
       }
       
       
   }
   public static void viewCostumers() {
      System.out.println(Costumers.costumers.clone());
   }

   public static void addItem(){
    System.out.print("Enter Id : ");
    int id = scanner.nextInt();
    System.out.print("Enter Name : ");
    String name = scanner.next();
    System.out.print("Enter Price : ");
    double price=scanner.nextDouble();
    Item.addItem(new Items(id,name,price));
   }
   public static void deleteItem(){
    System.out.print("Enter Item Id : ");
    int id = scanner.nextInt();
    Item.deleteItem(id);
   }
   public static void updateItem(){
    System.out.print("Enter Item Id that you want to change : ");
    int id=scanner.nextInt();
    if (Item.findItem(id)==-1) {
        System.out.println("No item with this id [ "+id+" ]");
    }
    else{
        System.out.print("Enter Name : ");
        String name = scanner.next();
        System.out.print("New Price : ");
        Double price = scanner.nextDouble();
         Item.updateItem(new Items(id, name, price));
    }
   } 
   public  static void availableItems(){
    System.out.println(Item.items.clone());
   }

} 

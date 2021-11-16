package View;
import java.util.Scanner;
import Controller.*;
import Model.Costumer;
import Model.Item;

public class AdminView {
    public AdminView(){

    }
    
   public static Scanner scanner=new Scanner(System.in);

   public  static void login (){
    boolean bol=true;
    int choice;
       while (bol) {
           actions();
           System.out.print("Choose a Choice : ");
           choice=scanner.nextInt();
           switch (choice) {
               case 1:
                   actions();
                   break;
               case 2:
                   addNewCostumer();
                   break;
               case 3:
                   deleteCostumer();
                   break;
               case 4:
                   updateCostumer();
                   break;
               case 5:
                   viewCostumers();
                   break;
               case 6:
                   addItem();
                   break;
               case 7:
                   deleteItem();
                   break;
               case 8:
                   updateItem();
                   break;
               case 9:
                   availableItems();
                   break;
               case 0:
                   bol = false;
                   break;
               default:
                   System.out.println("Please choose from 0 to 9");
                   break;
           }
       }


   }
   public static void Actions() {
    System.out.println("1. Add New Costumer");
    System.out.println("2. Delete Costumer");
    System.out.println("3. Add new Item");
    System.out.println("4. Delete Item ");
    System.out.println("0. Quit");
}
   public static void actions() {
       System.out.println("\n\n");
       System.out.println("1. Actions");
       System.out.println("2. Add New Costumer");
       System.out.println("3. Delete Costumer");
       System.out.println("4. Update Costumer Info");
       System.out.println("5. View Costumers");
       System.out.println("6. Add new Item");
       System.out.println("7. Delete Item ");
       System.out.println("8. Update Item Info");
       System.out.println("9. View Available Item ");
       System.out.println("0. Quit");
   }

   public static void addNewCostumer(){
     System.out.print("Enter Id : ");
     int id = scanner.nextInt();
     scanner.nextLine();
     System.out.print("Enter Name : ");
     String name = scanner.next();
     scanner.nextLine();
     System.out.print("Enter Phone Number : ");
     String phone = scanner.next();
     scanner.nextLine();
     System.out.print("Enter Address : ");
     String address = scanner.next();
     scanner.nextLine();
     Costumers.addCostumer(new Costumer(id,name,phone,address));
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
    scanner.nextLine();
    System.out.print("Enter Name : ");
    String name = scanner.nextLine();
    System.out.print("Enter Price : ");
    double price=scanner.nextDouble();
    scanner.nextLine();
    Items.addItem(new Item(id,name,price));
   }
   public static void deleteItem(){
    System.out.print("Enter Item Id : ");
    int id = scanner.nextInt();
    if(Items.findItem(id)!=-1) {
        System.out.println("No Item with this ID");
        Items.deleteItem(id);
    }
    else
        System.out.println("No Item with this ID");
    
   }
   public static void updateItem(){
    System.out.print("Enter Item Id that you want to change : ");
    int id=scanner.nextInt();
    if (Items.findItem(id)==-1) {
        System.out.println("No item with this id [ "+id+" ]");
    }
    else{
        System.out.print("Enter Name : ");
        String name = scanner.next();
        System.out.print("New Price : ");
        double price = scanner.nextDouble();
         Items.updateItem(new Item(id, name, price));
    }
   } 
   public  static void availableItems(){
    System.out.println(Items.items.clone()+"\n");
   }

} 

package View;
import java.util.Scanner;
import Controller.*;
import Model.Costumer;
import Model.Item;
import Model.Order;

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
                   addNewCostumer();
                   break;
               case 2:
                   deleteCostumer();
                   break;
               case 3:
                   updateCostumer();
                   break;
               case 4:
                   viewCostumers();
                   break;
               case 5:
                   addItem();
                   break;
               case 6:
                   deleteItem();
                   break;
               case 7:
                   updateItem();
                   break;
               case 8:
                   availableItems();
                   break;
               case 9:
                   updateAdmin();
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

}
   public static void actions() {
       System.out.println("\n");
       System.out.println("1. Add New Costumer");
       System.out.println("2. Delete Costumer");
       System.out.println("3. Update Costumer Info");
       System.out.println("4. View Costumers");
       System.out.println("5. Add new Item");
       System.out.println("6. Delete Item ");
       System.out.println("7. Update Item Info");
       System.out.println("8. View Available Item ");
       System.out.println("9. Change My Password");
       System.out.println("0. Log Out");

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
     if(Costumers.addcostumer) {
         System.out.println("Enter Items That Costumer Ordered :");
         OrderView.orderView();
     }
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
         Costumers.saveCostomers();
       }
       
       
   }
   public static void viewCostumers() {
       Costumers.fetchAndSetCustomer();
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
       System.out.println("Item Deleted successfully");
    
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
         Items.saveItems();
    }
   }
    public static void updateAdmin() {
        int adminIndex=Admins.findAdmin(MainView.Username);
            System.out.println("Enter Old Password : ");
            String oldPassword=scanner.next();
            scanner.nextLine();
            int count=0;
            if (Admins.admins.get(adminIndex).getPassword().equals(oldPassword)) {
                System.out.println("Enter New Password : ");
                String newPassword = scanner.next();
                scanner.nextLine();
                System.out.println("Confirm New Password again : ");
                String newPasswordagain = scanner.next();
                scanner.nextLine();
                if (newPassword.equals(newPasswordagain)){
                    Admins.admins.get(adminIndex).setPassword(newPassword);
                Admins.saveAdmins();
                }
                else { count++;
                    System.out.println("Entered two Passwords not equal");
                }

            }else System.out.println("Old Password Incorrect");
        }

   public  static void availableItems(){
    Items.fetchAndSetItems();
       System.out.println(Items.items.clone());
   }

} 

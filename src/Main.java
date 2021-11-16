import java.util.*;

import Controller.ClientServerConnection;
import Model.Costumer;
import Model.Item;
import Model.Order;
import View.AdminView;

import static Controller.Costumers.*;
import static Controller.Items.*;


public class Main{
    public static void main(String []args){
        ClientServerConnection.startConnection();
//        items.add(new Item(12,"coca-cola",500));
//        items.add(new Item(13,"capachino",2000));
//        items.add(new Item(14,"Chips",1000));
//        items.add(new Item(15,"Patoz",250));
//        costumers.add(new Costumer(1,"danyar","001","Bahirka"));
//        costumers.add(new Costumer(2,"ahuz","002","Pirmam"));
//        costumers.add(new Costumer(3,"shadya","003","Bahirka"));
//        costumers.add(new Costumer(5,"shamil","004","Hawler"));
//
//        saveCostomers();
//        saveItems();
//        fetchAndSetCustomer();
//        fetchAndSetItems();
////        System.out.println(costumers.toString());
//        System.out.println(items.toString());

        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.print("Enter USERNAME : ");
            String username=sc.next();
            System.out.print("Enter PASSWORD : ");
            String password=sc.next();
            if (username.equals("inventory")||password.equals("inventory")) {
                AdminView.login();
            }
            System.out.println("username or password is incorrect");
            System.out.println("Do You want Exit Whole program ? \nType \n-yes\n-no");
            String exit=sc.next();
            if (exit.equalsIgnoreCase("yes")) {
                sc.close();
               break;
            }
        }
       

    }

}

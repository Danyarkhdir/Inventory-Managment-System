import java.util.*;

import View.AdminView;
public class Main{
    public static void main(String []args){
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
            if (exit.toLowerCase().equals("yes")) {
                sc.close();
               break; 
            }  
        }
       

    }

}

import java.util.*;

import View.AdminView;
public class Main{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter USERNAME : ");
        String username=sc.nextLine();
        System.out.print("Enter PASSWORD : ");
        String password=sc.nextLine();
        if (!username.equals("inventory")||!password.equals("inventory")) {
            System.out.println("username or password is incorrect");
            return;
        }
        AdminView.login();


    }

}

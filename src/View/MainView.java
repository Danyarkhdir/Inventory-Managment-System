package View;

import Controller.Admins;
import Model.Admin;

import java.util.Scanner;


public class MainView {
    public static Scanner scanner=new Scanner(System.in);
    private static String adminstratorCode="InveNtorY";
    public static String Username;

    public  static void logIn () {
        boolean bol = true;
        int choice;
        while (bol) {
            actions();
            System.out.print("Choose a Choice : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    logInView();
                    break;
                case 3:
                    viewAllAdmins();
                    break;
                case 4:
                    deleteAdmin();
                    break;
                case 0:
                    bol = false;
                    break;
                default:
                    System.out.println("Please choose from 0 to 4");
                    break;
            }
        }
    }
    public static void actions() {
        System.out.println("\n");
        System.out.println("1. Sign Up");
        System.out.println("2. Log In");
        System.out.println("3. View Admins");
        System.out.println("4. Delete Admin");
        System.out.println("0. Quit");
    }
    public static void signUp() {
        System.out.print("Enter Administrator Code : ");
        String code = scanner.next();
        scanner.nextLine();
        if (code.equals(adminstratorCode)) {
            System.out.print("Enter Username : ");
            String userName = scanner.next();
            scanner.nextLine();
            System.out.print("Enter Password : ");
            String password = scanner.next();
            scanner.nextLine();
            Admin newAdmin = new Admin(userName, password);
            Admins.addAdmin(newAdmin);
            if (Admins.addAdmin) {
                AdminView.login();
            } else
                System.out.println("Code is Incorrect");
        }
    }
    public static void logInView(){
        Admins.fetchAndSetAdmins();
    boolean in=true;
        while (in) {
            System.out.print("Enter USERNAME : ");
            String username=scanner.next();
            System.out.print("Enter PASSWORD : ");
            String password=scanner.next();
            if (isPreset(username,password)) {
                Username=username;
                AdminView.login();
                break;
            }
            else{
            System.out.println("Admin with this Username or Password not Exist");
            System.out.println("Do You want Exit the Program ?\n Type Yes to Exit");
            String exit=scanner.next();
            if (exit.equalsIgnoreCase("yes")) {
                in=false;
                break;
            }
            }
        }

    }
    public static boolean isPreset(String username , String password){
        for (int i = 0; i < Admins.admins.size(); i++) {
            Admin admin = Admins.admins.get(i);
            if (admin.getUsername().equals(username)&&admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void viewAllAdmins() {
        Admins.fetchAndSetAdmins();
        System.out.print("Enter Administrator Code : ");
        String code = scanner.next();
        scanner.nextLine();
        if (code.equals(adminstratorCode)) {
            System.out.println(Admins.admins.clone());
        }
        else
            System.out.println("Incorrect Code");
    }
    public static void deleteAdmin(){
        System.out.print("Enter Admin Username : ");
        String username = scanner.next();
        if(Admins.findAdmin(username)!=-1) {
            System.out.println("Admin with username " +username+" Deleted");
            Admins.deleteAdmin(username);
        }
        else
            System.out.println("No Admin with this Username");

    }
}





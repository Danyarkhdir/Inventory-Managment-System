package Controller;
import Model.Admin;
import Model.Costumer;
import Model.Packet;

import java.util.*;


public class Admins {
    public static LinkedList<Admin> admins =new LinkedList<>();
    public static ClientServerController<Admin> adminController = new ClientServerController<>();
    public static boolean addAdmin=true;
    public static boolean delAdmin=true;

    public static void fetchAndSetAdmins(){
        Packet<Admin> packet = adminController.get(new Packet<>(7));
        if (packet==null){
            saveAdmins();
            admins= packet.getItems();
        }
        admins= packet.getItems();


    }
    public static  void saveAdmins(){
        Packet<Admin> packet = new Packet<>(8);
        packet.setItems(admins);
        adminController.get(packet);
    }

    public static void addAdmin(Admin admin){
        int adminIndex = findAdmin(admin.getUsername());
        if (adminIndex!=-1) {
            System.out.println("Another Admin with this Username Exist");
            addAdmin=false;
        } else {
            fetchAndSetAdmins();
            admins.add(admin);
            addAdmin=true;
            saveAdmins();
        }

    }
    public static void deleteAdmin(String username) {
        int adminIndex = findAdmin(username);
        if (adminIndex == -1) {
            System.out.println("Admin with This Username not Exist");
            delAdmin=false;
        }
        else{
            fetchAndSetAdmins();
            admins.remove(adminIndex);
            System.out.println("Admin " + username + " was successfully deleted.");
            delAdmin=true;
            saveAdmins();
        }

    }

    public static int findAdmin(String Username) {
        for (int i = 0; i < admins.size(); i++) {
            String name = admins.get(i).getUsername();
            if (name!=null) {
                if (name.equals(Username)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static Admin updateAdmin(Admin admin){
        fetchAndSetAdmins();
        return admins.set(findAdmin(admin.getUsername()), admin);
    }
}

package Controller; 
import Model.Costumer;
import Model.Packet;

import java.util.*;
public class Costumers {
 public static LinkedList<Costumer> costumers =new LinkedList<>();
public static boolean addcostumer;
public static boolean delcostumer;
public static ClientServerController<Costumer> customerController = new ClientServerController<>();


    public static void fetchAndSetCustomer(){
        Packet<Costumer> packet = customerController.get(new Packet<>(1));
        if (packet!=null)
        costumers= packet.getItems();
    }
    public static void saveCostomers(){
        Packet<Costumer> packet = new Packet<>(2);
        packet.setItems(costumers);
        customerController.get(packet);

    }

        public static void addCostumer(Costumer costumer){

            int costumerindex = findCostumer(costumer.getCostumerId());
            if (costumerindex > -1) {
                System.out.println("Costumer with  id [ "+costumer.getCostumerId()+" ] is already exist , cannot add");
                addcostumer=false;
            }
            else{
                fetchAndSetCustomer();
            costumers.add(costumer);
            System.out.println("Costumer with id [ "+costumer.getCostumerId()+" ] added");
            addcostumer=true;
            saveCostomers();
            }
            
        }
        public static void deleteCostumer(int costumerId) {

            int costumerindex = findCostumer(costumerId);
            if (costumerindex == -1) {
                System.out.println("no costumer with Id  [ " + costumerId + " ] is available.\ndeleting costumer failed.");
                delcostumer=false;
            }
            else{
                fetchAndSetCustomer();
            costumers.remove(costumerindex);
            System.out.println("costumer with Id : " + costumerId + " was successfully deleted.");
            delcostumer=true;
            saveCostomers();
            }
    
        }
        public static Costumer updateCostumer(Costumer costumer){
            return costumers.set(findCostumer(costumer.getCostumerId()), costumer);
        }
        public static int findCostumer(int costumerId){
            for (int i = 0; i < costumers.size(); i++) {
                Costumer costumer=costumers.get(i);
                if (costumer.getCostumerId()==costumerId) {
                   return i; 
                }
            }
                return -1;
            }
       
        
        
}
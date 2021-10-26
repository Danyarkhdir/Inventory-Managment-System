package Controller; 
import Models.*;
import java.util.*;
public class Costumers {
public DataFile dataFile =new DataFile();
 public static LinkedList<Costumer> costumers =new LinkedList<>();
Costumer costumer;
        public static void addCostumer(Costumer costumer){
            int costumerindex = findCostumer(costumer.getCostumerId());
            if (costumerindex > -1) {
                System.out.println("costumer with  id [ "+costumer.getCostumerId()+" ] is already exist , cannot add");
            }
            else{
            costumers.add(costumer);
            System.out.println("costumer with id [ "+costumer.getCostumerId()+" ] added");
            }
            
        }
        public static void deleteCostumer(int costumerId) {
            int costumerindex = findCostumer(costumerId);
            if (costumerindex == -1) {
                System.out.println("no costumer with Id  [ " + costumerId + " ] is available.\ndeleting costumer failed.");
            }
            else{
            costumers.remove(costumerindex);
            System.out.println("costumer with Id : " + costumerId + " was successfully deleted.");
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
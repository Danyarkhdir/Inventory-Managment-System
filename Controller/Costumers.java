package Controller; 
import Models.*;
import java.util.*;
public class Costumers {
public DataFile dataFile =new DataFile();
 public static LinkedList<Costumer> costumers =new LinkedList<>();
Costumer costumer;
public static boolean addcostumer;
public static boolean delcostumer;
        public static void addCostumer(Costumer costumer){
            int costumerindex = findCostumer(costumer.getCostumerId());
            if (costumerindex > -1) {
                System.out.println("costumer with  id [ "+costumer.getCostumerId()+" ] is already exist , cannot add");
                addcostumer=false;
            }
            else{
            costumers.add(costumer);
            System.out.println("costumer with id [ "+costumer.getCostumerId()+" ] added");
            addcostumer=true;
            }
            
        }
        public static void deleteCostumer(int costumerId) {
            int costumerindex = findCostumer(costumerId);
            if (costumerindex == -1) {
                System.out.println("no costumer with Id  [ " + costumerId + " ] is available.\ndeleting costumer failed.");
                delcostumer=false;
            }
            else{
            costumers.remove(costumerindex);
            System.out.println("costumer with Id : " + costumerId + " was successfully deleted.");
            delcostumer=true;
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
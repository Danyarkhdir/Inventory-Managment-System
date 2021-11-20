package Model;
import java.io.Serializable;

public class Costumer implements Serializable {
    private int costumerId;
    private String name;
    private String phoneNumber;
    private String address; 
    public Costumer(){
    }
    public  Costumer(int costumerId,String name,String phoneNumber,String address) {
        this.costumerId=costumerId;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }
    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getCostumerId() { return costumerId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    
    public String toString() {
        return "\ncostumerId : "+costumerId+"\nCostumer Name : "+name+"\nPhone Number : +964"+phoneNumber+"\naddress : "+address+"\n\n";
    }
}

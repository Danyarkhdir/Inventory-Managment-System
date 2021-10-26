import java.io.Serializable;

public class Costumer implements Serializable {
    private int costumerId;
    private String name;
    private String phoneNumber;
    private String address; 
    public Costumer(){
        costumerId=0;
        name="undefined";
        phoneNumber="0";
        address="undefined";

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
    public int getCostumerId() {
        return costumerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    
    public String toString() {
        return "\ncostumerId : "+costumerId+"\nCostumer Name : "+name+"\nPhone Number : +964"+phoneNumber+"\naddress : "+address;
    }
}

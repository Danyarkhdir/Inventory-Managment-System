public class Costumer {
    private String name;
    private long phoneNumber;
    private String address; 
    public  Costumer() {
        name="unknown";
        phoneNumber=0000000000l;
        address="no Address";
    }
    public  Costumer(String name,long phoneNumber,String address) {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    
    public String toString() {
        return "Costumer Name : "+name+"\nPhone Number : +964"+phoneNumber+"\naddress : "+address;
    }
}

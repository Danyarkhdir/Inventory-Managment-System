public class Main{
    public static void main(String[] args) {
            Costumer costumer1=new Costumer("muhamad",07501234567,"Barzan-Erbil-Kurdistan");
        Items item1=new Items(12, "Coca Cola", "Coca Company",5000);
       Order order1=new Order(costumer1,item1,3);
       Bill bill1=new Bill(order1);
       System.out.println(bill1);

      
    }
}

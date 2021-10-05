public class Main{
    public static void main(String[] args) {
            costumer costumer1=new costumer("muhamad",07501234567,"Barzan-Erbil-Kurdistan");
        items item1=new items(12, "Coca Cola", "Coca Company",5000);
       order order1=new order(costumer1,item1,3);
       bill bill1=new bill(order1);
       System.out.println(bill1);

      
    }
}

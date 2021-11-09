package Controller;
import java.io.*;
import java.net.*;

import Models.Costumer;
import Models.Items;

public class Server {

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        try {
        serverSocket = new ServerSocket(4444);
        System.out.println("Server started...");
        System.out.println("Waiting for a Client...");
        } catch (IOException e) {
        System.err.println("Could not listen on port: 4444.");
        System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client Accepted");
            } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
            }
            PrintWriter out = new PrintWriter(
            clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new
            InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            out.println("Welcome to Inventory server , Enter: (1) for actions (0) for exit");
            while ((inputLine = in.readLine()) != null) {
                outputLine=inputLine;
            if (outputLine.toLowerCase().equals("bye")) System.exit(0);
            switch (inputLine) {
                case "1":
                Costumer newCostumer=new Costumer();
                out.println("Enter Costumer id : ");
                inputLine=in.readLine();
                newCostumer.setCostumerId(Integer.parseInt(inputLine));
                out.println("Enter Costumer name : ");
                inputLine=in.readLine();
                newCostumer.setName(inputLine);
                out.println("Enter Costumer Phone : ");
                inputLine=in.readLine();
                newCostumer.setPhoneNumber(inputLine);
                out.println("Enter Costumer address : ");
                inputLine=in.readLine();
                newCostumer.setAddress(inputLine);
                Costumers.addCostumer(newCostumer);
                if(Costumers.addcostumer) out.println("Costumer added");
                else out.println("Adding costumer failed , maybe Costumer exist");
                    break;
                case "2":
                    out.println("Enter Costumer Id : ");
                    inputLine=in.readLine();
                    Costumers.deleteCostumer(Integer.parseInt(inputLine));
                    if(Costumers.delcostumer) out.println("Deleting Costumer successed");
                    else out.println("deleting costumer failed , Costumer not exist");
                        break;
                case "3":
                Items newItem=new Items();
                out.println("Enter item id : ");
                inputLine=in.readLine();
                newItem.setItemId(Integer.parseInt(inputLine));
                out.println("Enter name name : ");
                inputLine=in.readLine();
                newItem.setItemName(inputLine);
                out.println("Enter Price Phone : ");
                inputLine=in.readLine();
                newItem.setItemPrice(Double.parseDouble(inputLine));
                Item.addItem(newItem);
                if(Item.additem) out.println("Item added successfuly");
                else out.println("Adding item failed , maybe Costumer exist");
                    break;
                case "4":
                out.println("Enter Item Id : ");
                inputLine=in.readLine();
                Item.deleteItem(Integer.parseInt(inputLine));
                if(Item.delitem) out.println("Deleting Item successed");
                else out.println("deleting item failed , item not exist");
                break;
                case "0":
                out.println("Enter Bye to Exit.");
                break;
                default:
                out.println("Please Enter number from ( 0 to 4 ) : ");
                    break;
            }
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
            }
    
}
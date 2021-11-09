package View;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
        socket = new Socket("192.168.100.79", 25);
        System.out.println("Succesfully connected to server");
        out = new PrintWriter(socket.getOutputStream(), true);
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know host: Inventory.");
            System.exit(1);
            } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
            + "the connection to: Inventory.");
            System.exit(1);
            }
            BufferedReader In = new BufferedReader(
            new InputStreamReader(System.in));
            String userInput;
            System.out.println(in.readLine());
            System.out.println("Enter :");
            AdminView.Actions();
            while ((userInput=In.readLine())!=null) {
            out.println(userInput);
            System.out.println(in.readLine());
            }
            out.close();
            out.flush();
            in.close();
            In.close();
            socket.close();
            }
            }
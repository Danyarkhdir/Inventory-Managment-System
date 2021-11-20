
import Controller.ClientServerConnection;
import View.MainView;


public class Main{
    public static void main(String []args){
        ClientServerConnection.startConnection();
        MainView.logIn();
    }

}

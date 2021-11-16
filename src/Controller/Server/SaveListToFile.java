package Controller.Server;

import java.io.*;
import java.util.*;

public class SaveListToFile<T> {

    String path ;
    public SaveListToFile(String path){
        this.path=path;
    }

    @SuppressWarnings("unchecked")
    public LinkedList<T> openList() {
        LinkedList<T> list = new LinkedList<>();
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream get = new ObjectInputStream(file);
            list = (LinkedList<T>)get.readObject();

            file.close();
            get.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + path);
        } catch (IOException e) {
            System.out.println("Error initializing stream"+e.getMessage()+path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean saveListToFile(LinkedList<T> items){
        try{
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(items);
            o.close();
            f.close();

        } catch (FileNotFoundException e){
            System.out.println("Saved failed 1");
            return false;
        } catch (IOException e){
            System.out.println("Saved failed 2");

            return false;
        }
        System.out.println("Saved Success");
        return true;
    }

}

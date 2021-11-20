package Model;

import java.io.Serializable;

public class Admin implements Serializable {
    public  String username;
    public  String password;

    public Admin(){
    }
    public Admin(String username,String password){
        this.username=username;
        this.password=password;
    }
    public  String getUsername() {
        return username;
    }
    public  String getPassword() {
        return password;
    }

    public  void setUsername(String username) {
        this.username = username;
    }

    public  void setPassword(String password) {
        this.password = password;
    }


    public  String toString() {
        return "Username : [ "+username+" ] \nPassword : [ "+password+" ] \n" ;
    }
}
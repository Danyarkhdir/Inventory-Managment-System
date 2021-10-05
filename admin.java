public class admin {
    private String username;
    private String password;
    public admin(){
        username="Admin";
        password="Admin";
    }
    public admin(String username,String password){
        this.username=username;
        this.password=password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String toString() {
        return "[ Username : "+username+" ] is Admin Now";
    }

}

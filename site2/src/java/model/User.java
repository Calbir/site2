package model;

public class User {
    private String userName;
    private String userPass;

    public User (String name, String pass){
        this.userName = name;
        this.userPass = pass;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getUserPass(){
        return this.userPass;
    }
    
    public void setUserName(String name2){
        this.userName = name2;
    }
    
    public void setUserPass(String pass2){
        this.userPass = pass2;
    }
    
    @Override
    public String toString(){
        return "Nome:" + this.userName +
                   "<br> Senha:" + this.userPass;
    }
    
    public boolean isLogged(){
        return(this.userName.equals("lucas") &&
                   this.userPass.equals("1234"));
    }
    
}


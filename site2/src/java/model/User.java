package model;

import java.sql.SQLException;

public class User {
    private int userId;
    private String userName;
    private String userPass;
    private String userEmail;    

    public User(){}
    
    public User (String name, String pass, String email){
        this.userName = name;
        this.userPass = pass;
        this.userEmail = email;
    }
    
    public int getUserId(){
        return userId;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getUserPass(){
        return this.userPass;
    }
    
    public String getUserEmail(){
        return this.userEmail;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    public void setUserName(String name2){
        this.userName = name2;
    }
    
    public void setUserPass(String pass2){
        this.userPass = pass2;
    }
    
    public void setUserEmail(String email2){
        this.userEmail = email2;
    }
    
    @Override
    public String toString(){
        return "Nome:" + this.userName +
                   "<br> Senha:" + this.userPass +
                           "<br> Eamil:" + this.userEmail;
    }
    
    public boolean isLogged() throws ClassNotFoundException, SQLException{
        UserDAO udao = new UserDAO();
        
        User name3 = udao.listOneUserint(this.getUserName());
        
        if(name3.getUserName() != null) {
                return (this.userName.equals(name3.getUserPass()));
        } else {
            return false;
        }
        
        //return(this.userName.equals("lucas") &&
                   //this.userPass.equals("1234"));
    }
    
}


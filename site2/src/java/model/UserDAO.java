package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static Connection conn;
    
    public UserDAO() throws ClassNotFoundException, SQLException{
        conn = MyConnection.getConnection();
    }
    
    public User listOneUserint (String nome) throws SQLException{
        String query ="SELECT * FROM usuarios WHERE nome = ?";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, nome);
        ResultSet result = prep.executeQuery();
        
        User user = new User();
        
        if(result.next()){
                    user.setUserId(result.getInt("id_usuario"));
                    user.setUserName(result.getString("nome"));
                    user.setUserPass(result.getString("senha"));
        }
        return user;
    }

 public void insertUser(User user) throws SQLException{
    String sql = "INSERT INTO usuarios(nome, senha, email)" 
                 + "VALUES (?, ?, ?)";
    
    PreparedStatement prep = conn.prepareStatement(sql);
    
    prep.setString(1, user.getUserName());
    prep.setString(2, user.getUserPass());
    prep.setString(3, user.getUserEmail());
    
    prep.execute(); 
    prep.close();
    
    }
    
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistroDAO {
    private static Connection conn;
    
    public RegistroDAO() throws ClassNotFoundException, SQLException{
        conn = MyConnection.getConnection();
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
    
    public ArrayList<User> listUser() throws SQLException{
        ArrayList<User> list = new ArrayList<User>();
        
        String sql = "SELECT *  FROM usuarios";
        PreparedStatement prep = conn.prepareStatement(sql);
        
        ResultSet result = prep.executeQuery();
        
        while(result.next()){
            User reg = new User ();
            
            reg.setUserId(result.getInt("id_usuario"));
            reg.setUserName(result.getString("nome"));
            reg.setUserPass(result.getString("senha"));
            reg.setUserEmail(result.getString("email"));
            
            list.add(reg);
            
        }
        
        return list;
            
    }
    
    public void deleteMapa(int id) throws SQLException{
        String sql = "DELETE FROM mapas WHERE id_usuario = " + id;
        
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.execute();
        prep.close();
        
    }
    
    public User listOneUser(int cod) throws SQLException{
        String query ="SELECT * FROM usuarios WHERE id_usuario =" + cod;
        PreparedStatement prep = conn.prepareStatement(query);
        ResultSet result = prep.executeQuery();
        User mapa = new User();
        if(result.next()){
                    mapa.setUserId(result.getInt("id_usuario"));
                    mapa.setUserName(result.getString("nome"));
                    mapa.setUserPass(result.getString("senha"));
                    mapa.setUserEmail(result.getString("email"));
        }
        return mapa;
    }
    
    public void updateUser (User user) throws SQLException{
        String query ="UPDATE usuarios SET nome = ?, " + "senha = ?, email = ?" + "WHERE id_usuario = ?";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.setString(1, user.getUserName());
        prep.setString(2, user.getUserPass());
        prep.setString(3, user.getUserEmail());
        prep.setInt(4, user.getUserId());
        
        prep.execute();
        prep.close();
    
    }
    
}
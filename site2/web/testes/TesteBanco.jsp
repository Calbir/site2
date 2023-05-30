<%@page import="java.sql.SQLException" %>
<%@page import="model.MyConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
        if(MyConnection.getConnection()!= null){
    out.print("Conexão bem sucedida");
    out.print("<br>Nome do banco de dados: " + MyConnection.getConnection().getCatalog());
        } 
    } catch(SQLException erro){
        out.print("Ocorreu um erro:/ <hr>" + erro);
    }
%>

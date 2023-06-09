package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import model.User;
import model.UserDAO;

@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {
    
    private int id;
    private String nome;
    private String senha;
    private String email;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if(request.getParameter("id_usuario") != null){
            this.id = Integer.parseInt(request.getParameter("id_usuario"));
        }
        
        this.nome = request.getParameter("name");
        this.senha = request.getParameter("pass");
        this.email = request.getParameter("email");
        
        try (PrintWriter out = response.getWriter()) {
                    
            User objetoMapa = new User (this.nome, this.senha, this.email);

            UserDAO dao = new UserDAO();
            dao.insertUser(objetoMapa);
            response.sendRedirect("telaPrincipal.jsp");
                       
        } catch (ClassNotFoundException | SQLException erro){
        
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>QIso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ocorreu algum erro :/</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

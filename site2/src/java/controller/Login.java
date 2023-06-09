package controller;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import model.User;

@WebServlet(name = "Login", urlPatterns = {"/login_controller"})
public class Login extends HttpServlet {
    
    private String name;
    private String pass;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        this.name = request.getParameter("name");
        this.pass = request.getParameter("pass");
        
        User name3 = new User();
        name3.setUserName(this.name);
        name3.setUserPass(this.pass);
        
        try {
            if(name3.isLogged()){
            HttpSession session = request.getSession();
            session.setAttribute("userSession", name3);
            //request.setAttribute("userLogged", name3);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>QIso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<script>");
            out.println("alert('Você errou')");
            out.println("window.location.replace('telaPrincipal.jsp')");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
            }
        }
    } catch(SQLException | ClassNotFoundException erro) {
                PrintWriter out = response.getWriter();
                out.print(erro);
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

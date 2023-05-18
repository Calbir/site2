package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    private String name;
    private String pass;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        this.name = request.getParameter("name");
        this.pass = request.getParameter("pass");
        
        User name3 = new User(this.name, this.pass);
        
        if(name3.isLogged()){
        HttpSession session = request.getSession();
        session.setAttribute("userSession", name3);
        request.setAttribute("userLogged", name3);
        request.getRequestDispatcher("telaPrincipal.jsp").forward(request, response);
        } else {
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<script>");
            out.println("alert('Você errou')");
            out.println("window.locationreplace('index.jsp')");
            out.println("</script>");
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

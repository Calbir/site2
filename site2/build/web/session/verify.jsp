<%@page import="model.User"%>
<%
    User userSession = (User)session.getAttribute("userSession");
    //out.print(userSession)
    if(userSession == null){
        response.sendRedirect(request.getContextPath());
    }
%>

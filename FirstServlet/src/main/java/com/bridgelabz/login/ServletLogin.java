package com.bridgelabz.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String useName=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        String unamePattern="[A-Z]{1}[A-Za-z0-9]{3,}";
        String pwdPattern="^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()]){1}[a-zA-Z0-9]{8,}";

        if(useName.equalsIgnoreCase("Sairam")&&pwd.equalsIgnoreCase("Sairam@12345")
        && Pattern.matches(unamePattern,useName)&&Pattern.matches(pwdPattern,pwd)){
            response.sendRedirect("loginSuccess.jsp");
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }
}

package Servelt;

import Mannager.productMannager;
import ProductModel.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/remove")
public class removeProduct extends HttpServlet {
    private Mannager.productMannager productMannager = new productMannager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add Product</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Remove Product</h1>");
        out.println("<form action=\"remove\" method=\"post\">");
        out.println("<label for=\"name\">Product Name:</label>");
        out.println("<input type=\"text\" id=\"name\" name=\"name\" required>");
        out.println("<br><br>");
        out.println("<button type=\"submit\">Remove Product</button>");
        out.println("</form>");
        out.println("<br><br>");
        out.println("</body>");
        out.println("</html>");


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try{
         String name=request.getParameter("name");
         productMannager.DeleteProduct(name);
         response.sendRedirect("/getAllProduct");
     }
     catch (Exception e)
     {
         response.sendRedirect("error?message=" + e.getMessage());
     }
    }
}


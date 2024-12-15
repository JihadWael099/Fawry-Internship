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

@WebServlet("/update")
public class updateProduct extends HttpServlet {
    private Mannager.productMannager productMannager = new productMannager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Product</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Update Product</h1>");
            out.println("<form action=\"update\" method=\"post\">");
            out.println("<label for=\"Oldname\">Old Name:</label>");
            out.println("<input type=\"text\" id=\"Oldname\" name=\"Oldname\" required>");
            out.println("<br><br>");

        out.println("<label for=\"Newname\">New Name:</label>");
        out.println("<input type=\"text\" id=\"Newname\" name=\"Newname\" required>");
        out.println("<br><br>");
            out.println("<label for=\"price\">Product Price:</label>");
            out.println("<input type=\"number\" id=\"price\" name=\"price\" required>");
            out.println("<br><br>");
            out.println("<button type=\"submit\">update Product</button>");
            out.println("</form>");
            out.println("<br><br>");
            out.println("</body>");
            out.println("</html>");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Oldname = request.getParameter("Oldname");
        String Newname = request.getParameter("Newname");
        String priceString = request.getParameter("price");

        try {
            double price = Double.parseDouble(priceString);
            productMannager.updateProduct(Oldname,Newname,price);
            response.sendRedirect("getAllProduct");
        } catch (RuntimeException e) {
            response.sendRedirect("error?message=" + e.getMessage());
        }
    }
}

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

@WebServlet("/search")
public class SearchProduct extends HttpServlet
{
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
        out.println("<h1>Search about Product</h1>");
        out.println("<form action=\"search\" method=\"post\">");
        out.println("<label for=\"name\">Product Name:</label>");
        out.println("<input type=\"text\" id=\"name\" name=\"name\" required>");
        out.println("<br><br>");
        out.println("<button type=\"submit\">search</button>");
        out.println("</form>");
        out.println("<br><br>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        Product foundProduct = productMannager.getProductByName(name);
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Product Search Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Product Search Result</h1>");

            if (foundProduct != null) {
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
                out.println("<tr>");
                out.println("<td>" + foundProduct.getId() + "</td>");
                out.println("<td>" + foundProduct.getName() + "</td>");
                out.println("<td>" + foundProduct.getPrice() + "</td>");
                out.println("</tr>");
                out.println("</table>");
            }
            else
            {
                out.println("<p style='color:red;'>No product found with the name: " + name + "</p>");
            }

            out.println("<br><a href=\"search\">Search Again</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

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

@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
    private productMannager productMannager = new productMannager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Product</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Add a New Product</h1>");
            out.println("<form action=\"addProduct\" method=\"post\">");
            out.println("<label for=\"name\">Product Name:</label>");
            out.println("<input type=\"text\" id=\"name\" name=\"name\" required>");
            out.println("<br><br>");
            out.println("<label for=\"price\">Product Price:</label>");
            out.println("<input type=\"number\" id=\"price\" name=\"price\" required>");
            out.println("<br><br>");
            out.println("<button type=\"submit\">Add Product</button>");
            out.println("</form>");
            out.println("<br><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String priceString = request.getParameter("price");

        try {

            int price = Integer.parseInt(priceString);

            if (price < 0) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head><title>Error</title></head>");
                out.println("<body>");
                out.println("<h1>Error: Price cannot be negative!</h1>");
                out.println("<a href=\"addProduct\">Go back and try again</a>");
                out.println("</body>");
                out.println("</html>");
                return; // Stop further processing if price is negative
            }


            productMannager.addProduct(new Product(name, price, productMannager.getAllProducts().size() + 1));
            response.sendRedirect("getAllProduct");

        } catch (NumberFormatException e) {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Error</title></head>");
            out.println("<body>");
            out.println("<h1>Error: Please enter a valid number for the price.</h1>");
            out.println("<a href=\"addProduct\">Go back and try again</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

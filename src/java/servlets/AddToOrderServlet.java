/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mirji507
 */
@WebServlet(name = "AddToOrderServlet", urlPatterns = {"/AddToOrderServlet"})
public class AddToOrderServlet extends HttpServlet {

   /**
    * Processes requests for both HTTP
    * <code>GET</code> and
    * <code>POST</code> methods.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      //retrieve Order object from the session
      HttpSession session = request.getSession();
      Order item = (Order)session.getAttribute("order");
      Integer quantity = new Integer(request.getParameter("quantity"));
      Product product = (Product)session.getAttribute("product");
      
      //create a new orderItem based on the book ordered by users
      OrderItem items = new OrderItem(item, product, quantity);
      if(quantity > product.getQuantity()){
         response.sendError(422, 
                 "Available quantity too low for request {" + product.getName() + "}");
      }
      else{
      System.out.println("Product " + product);
      
      //add the new orderItem to the order
      item.addItem(items);
      
      //remove the product that was added to the session earlier
      session.removeAttribute("product");
      
      //redirect to Checkout.jsp
      response.sendRedirect("/shopping/restricted/Checkout.jsp");
      }
      
   }

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   /**
    * Handles the HTTP
    * <code>GET</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      processRequest(request, response);
   }

   /**
    * Handles the HTTP
    * <code>POST</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      processRequest(request, response);
   }

   /**
    * Returns a short description of the servlet.
    *
    * @return a String containing servlet description
    */
   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>
}

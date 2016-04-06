/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author mirji507
 */
public class OrderJdbcDAO implements OrderDAO{

   @Override
   public void save(Order order) {

	Connection con = null;
	PreparedStatement insertOrderStmt = null;
	PreparedStatement insertOrderItemStmt = null;
	PreparedStatement updateProductStmt = null;

	try {
		con = JdbcConnection.getConnection();

		insertOrderStmt = con.prepareStatement(
					"insert into orders(orderdate, customer) values (?,?)",
					Statement.RETURN_GENERATED_KEYS);

		insertOrderItemStmt = con.prepareStatement(
					"insert into orderitems(orderid, productid, quantity) values(?,?,?)");

		updateProductStmt = con.prepareStatement(
					"update products set quantity=? where productid=?");

		// since saving and order involves multiple statements across
		// multiple tables we need to control the transaction ourselves
		// to ensure our DB remains consistent

		// turn off auto-commit which effectively starts a new transaction
		con.setAutoCommit(false);


		// -- save the order --

		// convert the order's java.util.Date into a java.sql.Timestamp
		Timestamp timestamp = new Timestamp(order.getOrderDate().getTime());

		// get the customer's username since it is the FK that links order and customer
		String username = order.getCustomer().getUsername();
            
		// ****
		// write code here that saves the timestamp and username in the order table
		// using the insertOrderStmt prepared statement
		// ****
            insertOrderStmt.setTimestamp(1, timestamp);
            insertOrderStmt.setString(2, username);
            
            insertOrderStmt.executeUpdate();
		// get the auto-generated order ID from the database
		ResultSet rs = insertOrderStmt.getGeneratedKeys();

		Integer orderId = null;

		if (rs.next()) {
			orderId = rs.getInt(1);
		} else {
			throw new DAOException("Problem getting generated Order ID");
		}

		// -- save the order items --

		Collection<OrderItem> items = order.getOrderItems();

		// ****
		// write code here that iterates through the order items and saves
		// them using the insertOrderItemStmt prepared statement.
		// ****
            
            for(OrderItem item : items){
               insertOrderItemStmt.setInt(1, orderId);
               insertOrderItemStmt.setString(2, item.getProduct().getProductID());
               insertOrderItemStmt.setInt(3, item.getPurchasedQuantity());
               
               insertOrderItemStmt.executeUpdate();
            }

		// -- update the product quantities --

		for (OrderItem item : items) {

			Product product = item.getProduct();
                  updateProductStmt.setInt(1, item.getProduct().getQuantity()- item.getPurchasedQuantity());
                  updateProductStmt.setString(2, product.getProductID());
                  
                  updateProductStmt.executeUpdate();
			// *******************************************************************
			// write code here that updates the product quantity using the
			// using the updateProductStmt prepared statement.
			// *******************************************************************

		}


		// -- commit and clean-up --

		// commit the transaction
		con.commit();

		// turn auto-commit back on
		con.setAutoCommit(true);

		// close the statements and connection
		insertOrderStmt.close();
		insertOrderItemStmt.close();
		updateProductStmt.close();
		con.close();

	} catch (SQLException ex) {

		// something went wrong so rollback the entire transaction
		try {
			con.rollback();
		} catch (SQLException ex1) {
			ex1.printStackTrace();
		}

		// and throw an exception to tell the user what happened
		throw new DAOException(ex.getMessage());
	}
}
   
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author mirji507
 */
public class CustomerJdbcDAO implements CustomerDAO{

   @Override
   public void save(Customer customer) {
      try (
            //get connection to database
            Connection connection = JdbcConnection.getConnection();
  
            //create the SQL statement
            PreparedStatement stmt = connection.prepareStatement(
                "merge into customers (username,name,address,creditcard,password) values (?,?,?,?,?)");
        ) {

            //copy the data from the student domain object into the statement
            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getCreditcard());
            stmt.setString(5, customer.getPassword());

            stmt.executeUpdate();
        } catch (SQLException ex) {
               throw new DAOException(ex.getMessage(), ex);
        }
   }

   @Override
   public void delete(Customer customer) {
      try(
          Connection connection = JdbcConnection.getConnection();
          PreparedStatement stmt = connection.prepareStatement(
                  "delete from customers where username = ?");
          ) {
         stmt.setString(1, customer.getUsername());
         stmt.executeUpdate();
      } catch(SQLException ex){
          throw new DAOException(ex.getMessage(), ex);
      }
   }
   @Override
   public Customer getByUsername(String username){
      try(
          Connection connection = JdbcConnection.getConnection();
          PreparedStatement stmt = connection.prepareStatement(
                  "select * from customers where username=?");
              ){
              stmt.setString(1, username);
          ResultSet rs = stmt.executeQuery();
         
         Customer customer = null;
         if (rs.next()){
            String userid = rs.getString("username");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String creditcard = rs.getString("creditcard");
            String password = rs.getString("password");
            
            customer = new Customer(userid, name, address, creditcard, password);
         }
         return customer;
      } catch (SQLException ex){
         throw new DAOException(ex.getMessage(), ex);
      }
   }
   @Override
   public Customer logIn(String username, String pword){
      try(
          Connection connection = JdbcConnection.getConnection();
          PreparedStatement stmt = connection.prepareStatement(
                  "select * from customers where username=? and password=?");
          ){
              stmt.setString(1, username);
              stmt.setString(2, pword);
          ResultSet rs = stmt.executeQuery();
         
         Customer customer = null;
         if (rs.next()){
            
            String userid = rs.getString("username");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String creditcard = rs.getString("creditcard");
            String password = rs.getString("password");
            
            customer = new Customer(userid, name, address, creditcard, password);
         }
         return customer;
      } catch (SQLException ex){
         throw new DAOException(ex.getMessage(), ex);
      }
   }
   
}

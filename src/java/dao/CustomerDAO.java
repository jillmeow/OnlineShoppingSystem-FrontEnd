/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Product;
import java.util.*;

/**
 *
 * @author mirji507
 */
public interface CustomerDAO {
   public void save(Customer customer);
   
   public void delete (Customer customer);
   
   public Customer getByUsername(String username);
   
   public Customer logIn(String username, String password);
}

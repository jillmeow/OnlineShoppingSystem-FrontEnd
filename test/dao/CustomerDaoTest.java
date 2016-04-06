/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirji507
 */
public class CustomerDaoTest {
   private CustomerDAO dao = new CustomerJdbcDAO();
   
   private String username1 = "jillmirandilla";
   private Customer customer1;
   
   private String username2 = "williamcat";
   private Customer customer2;
   
   @Before
   public void setUp() {
      customer1 = new Customer(username1, "Jill", "2 Alva St", "6353-2321-4234-3231", "helloworld");
      customer2 = new Customer(username2, "William", "47A Maitland St", "4542-3240-3432-1354", "meowmeow");
      
      dao.save(customer1);
      dao.save(customer2);
   }
   
   @After
   public void tearDown() {
      dao.delete(customer1);
      dao.delete(customer2);
   }
   
   @Test
   public void testDaoSaveAndDelete(){
      //create customer for testing
      Customer customer3 = new Customer("polkadots", "Jane", "5 Middleton Rd", "4562-4757-5758-4510", "thisispassword");
      
      //save the customer using DAO
      dao.save(customer3);
      
      //retrieve the same customer via DAO
      Customer retrieved = dao.getByUsername("polkadots");
      
      //ensure that the customer we saved is the one we got back
      assertEquals("Retrieved customer should be the same as the saved one",
              customer3, retrieved);
      
      //delete the customer via the DAO
      dao.delete(customer3);
      
      //try to retrieved the deleted customer
      retrieved = dao.getByUsername("polkadots");
      
      //ensure that the customer was not retrieved(should be null)
      assertNull("Customer should no longer exist", retrieved);
   }
}

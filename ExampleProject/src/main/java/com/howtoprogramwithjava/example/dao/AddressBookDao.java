package com.howtoprogramwithjava.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howtoprogramwithjava.example.persistence.AddressBook;  
  
@Repository  
@Transactional  
public class AddressBookDao  
{  
  @Autowired  
  SessionFactory sessionFactory;  
    
  /** 
   * Save an AddressBook object to the database 
   */  
  public void save(AddressBook addressBook)  
  {  
    Session currentSession = sessionFactory.getCurrentSession();  
    currentSession.saveOrUpdate(addressBook);  
  }  
}
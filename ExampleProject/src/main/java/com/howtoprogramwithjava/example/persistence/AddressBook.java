package com.howtoprogramwithjava.example.persistence;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  
  
@Table(name="address_book")  
@Entity  //Debe ser del paquete javax.persistence
public class AddressBook  
{  
  private Long id;   //Será la llave primaria y se indica la anotación en el getter 
  private String name;  
  private String phoneNumber;  
  private String streetAddress;  
  private String zipCode;  
  private String city;  
  private String region;  
  private String country;  
    
  @Id  
  @GeneratedValue(strategy=GenerationType.AUTO)  
    public Long getId()  
    {  
        return id;  
    }  
    public void setId(Long id)  
    {  
        this.id = id;  
    }  
    public String getName()  
    {  
        return name;  
    }  
    public void setName(String name)  
    {  
        this.name = name;  
    }  
      
    @Column(name="phone_number") 		//para dar el nombre a la columna en base de datos 
    public String getPhoneNumber()  
    {  
        return phoneNumber;  
    }  
    public void setPhoneNumber(String phoneNumber)  
    {  
        this.phoneNumber = phoneNumber;  
    }  
      
    @Column(name="street_address")  
    public String getStreetAddress()  
    {  
        return streetAddress;  
    }  
    public void setStreetAddress(String streetAddress)  
    {  
        this.streetAddress = streetAddress;  
    }  
      
    @Column(name="zip_code")  
    public String getZipCode()  
    {  
        return zipCode;  
    }  
    public void setZipCode(String zipCode)  
    {  
        this.zipCode = zipCode;  
    }  
    public String getCity()  
    {  
        return city;  
    }  
    public void setCity(String city)  
    {  
        this.city = city;  
    }  
    public String getRegion()  
    {  
        return region;  
    }  
    public void setRegion(String region)  
    {  
        this.region = region;  
    }  
    public String getCountry()  
    {  
        return country;  
    }  
    public void setCountry(String country)  
    {  
        this.country = country;  
    }  
}  
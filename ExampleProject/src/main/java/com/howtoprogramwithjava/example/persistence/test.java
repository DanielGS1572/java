package com.howtoprogramwithjava.example.persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.howtoprogramwithjava.example.dao.AddressBookDao;

@Controller
public class test {
	@RequestMapping("test")
	public String Prueba(ModelMap map) {
		System.out.println("Gets in");
		AddressBook ab = new AddressBook();
		AddressBookDao abDao = new AddressBookDao();
		ab.setId(1L);
		ab.setCity("Toronto");
		ab.setCountry("Canada");
		ab.setName("Trevor Page");
		ab.setPhoneNumber("555-555-1234");
		ab.setRegion("Ontario");
		ab.setStreetAddress("123 Fake St");
		abDao.save(ab);
		return "showMessage";
	}

}

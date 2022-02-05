package com.bridgelabz.addressbook;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.ContactRepository;
import com.bridgelabz.addressbook.services.AddressBookService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AddressBookApplicationTests {
	
	@Autowired
	private AddressBookService addressBookService;
	
	@MockBean
	private ContactRepository contactRepository;

	
	List<Contact> contactList = null;
	ContactDTO contactDTO;
	Contact contact;
	
	
	@BeforeEach
	public void getUser(){
		contactDTO = new ContactDTO("Brijesh", "kulal", "brijeshKulal5@gmail.com","Jai-hind road", "Mangalore", "karnataka", "71323", "82898300");
		contact = new Contact(contactDTO);
		contactList = Arrays.asList(contact);
	}
	
	@Test
	public void getContactTest() {
		Mockito.when(contactRepository.findAll()).thenReturn(contactList);
		assertEquals(contactList,addressBookService.getContact());
	}
	
	@Test
	public void getContact_ReturnSizeTest() {
		Mockito.when(contactRepository.findAll()).thenReturn(contactList);
		assertEquals(1,addressBookService.getContact().size());
	}
	
	@Test
	public void createContactTest() {
		Mockito.when(contactRepository.save(contact)).thenReturn(contact);
        assertEquals(contact,addressBookService.createContact(contactDTO));
	}
	
	@Test
	public void getContactByIdTest() {
		Mockito.when(contactRepository.findById(1)).thenReturn(Optional.of(contact));
		assertEquals(contact,addressBookService.getContactById(1));
	}
	
	
	@Test
	public void deleteContactByIdTest() {
		when(contactRepository.existsById(1)).thenReturn(true);
		assertEquals(true,contactRepository.existsById(1));
	}

}

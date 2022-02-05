package com.bridgelabz.addressbook.services;

import java.util.List;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

public interface IAddressBookService {
	
	List<Contact> getContact();
	
	Contact getContactById(int contactId);
	
	Contact createContact(ContactDTO contactDTO);

	Contact updateContact(int contactId, ContactDTO contactDTO);

	String deleteContact(int contactId);

}

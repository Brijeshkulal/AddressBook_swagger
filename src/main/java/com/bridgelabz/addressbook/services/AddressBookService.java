package com.bridgelabz.addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.ContactRepository;

@Service
public class AddressBookService implements IAddressBookService {
	
	@Autowired
	ContactRepository contactRepository; 
	

	@Override
	public List<Contact> getContact() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(int contactId) {
		return contactRepository.findById(contactId)
				.orElseThrow(() -> new AddressBookException("Contact with id " + contactId + " does not exist..!"));
		
	}

	@Override
	public Contact createContact(ContactDTO contactDTO) {
		Contact contact= new Contact(contactDTO);
        return contactRepository.save(contact);
	}

	@Override
	public Contact updateContact(int contactId, ContactDTO contactDTO) {
		Contact contact = this.getContactById(contactId);
        contact.updateContact(contactDTO);
        return contactRepository.save(contact);
	}
		
	@Override
	public void deleteContact(int contactId) {
		Contact contact = this.getContactById(contactId);
        contactRepository.delete(contact); 
	}

}

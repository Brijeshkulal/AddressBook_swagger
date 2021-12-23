package com.bridgelabz.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbook.dto.ContactDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "addressbook")
public class Contact {
	@Id
	@Column(name="contactId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	@Column(name="phone_number")
	private String phone_number;
	
	public Contact(ContactDTO contactDTO) {	
		this.updateContact(contactDTO);
	}

    public void updateContact(ContactDTO contactDTO)  {
		this.firstName = contactDTO.firstName;
		this.lastName = contactDTO.lastName;
		this.address = contactDTO.address;
		this.state = contactDTO.state;
		this.city = contactDTO.city;
		this.zip = contactDTO.zip;
		this.phone_number = contactDTO.phone_number;
	}
	
	public Contact() {
		
	}
	
	
	

}

package com.mrdfood.demo.boot.model;
/**
 * 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
 
@Document(collection="person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
    @Id
    @Field
    private String id;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String email;
    @Field
    private String password;
    @Field
    private String mobileNumber;
    @Field
    private String alternateNumber;
    @Field
    private String gender;
    
    private List<Address> addresses;
            

    public Person() {
    }

    public Person(String id, String firstName, String lastName, String password, String mobileNumber, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
    }
   /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
 
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
  
    public String getLastName() {
        return lastName;
    }
 

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 

    public String getMobileNumber() {
        return mobileNumber;
    }
 
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

	public String getId() {
            return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getAlternateNumber() {
        return alternateNumber;
    }

    public void setAlternateNumber(String alternateNumber) {
        this.alternateNumber = alternateNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address...address) {
        if(this.addresses == null) this.addresses = new ArrayList<>();
        this.addresses.addAll(Arrays.asList(address));
    } 
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", mobileNumber=" + mobileNumber + ", alternateNumber=" + alternateNumber + ", gender=" + gender + '}';
    }

	
	
    
}

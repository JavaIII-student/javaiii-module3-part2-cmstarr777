package mvc_demo;

public class Contacts_Model implements Comparable <Contacts_Model> {
		
	    private String firstname;
	    private String lastname;
	    private String homeaddr;
	    private String phonenumber;
	    private int id;
	    
	    Contacts_Model (String firstName, String lastName, String homeAddr, String phoneNumber )
	    {
	    	this.firstname = firstName;
	    	this.lastname = lastName;
	    	this.homeaddr = homeAddr;
	    	this.phonenumber = phoneNumber;
	    }
	    
	    Contacts_Model () 
	    {
	    	this.firstname = "firstName";
	    	this.lastname = "lastName";
	    	this.homeaddr = "homeAddr";
	    	this.phonenumber = "phoneNumber";
	    }
	       
	       
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getFirstname() {
	        return firstname;
	    }
	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }
	    public String getLastname() {
	        return lastname;
	    }
	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }
	    public String gethomeAddress() {
	        return homeaddr;
	    }
	    public void sethomeAddress(String homeAddr) {
	        this.homeaddr = homeAddr;
	    }
	    public String getphoneNumber() {
	        return phonenumber;
	    }
	    public void setphoneNumber(String phoneNumber) {
	        this.phonenumber = phoneNumber;
	    }
	      
	    @Override
	    public int compareTo(Contacts_Model other)
	    {
	      return this.firstname.compareTo(other.firstname);
	    }
}

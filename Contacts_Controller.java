package mvc_demo;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Contacts_Controller 
{
	   private Contacts_View theView;
	   private Contacts_Model theModel;
	
	   public static void main(String[] args)
	    {
	        //Schedule a job for the event dispatching thread:
	        //creating and showing this application's GUI.
	        SwingUtilities.invokeLater(new Runnable()
	        {
	            public void run() {
	                 //Turn off metal's use of bold fonts
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
	        createAndShowGUI();
	            }
	        });
	    }
	    
	    private static void createAndShowGUI() 
	    {
	        //Create and set up the window.
	        JFrame frame = new JFrame("ContactSubmit");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Add content to the window.
	        frame.add(new Contacts_View());
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	    
	    public void actionPerformed(ActionEvent e) 
	    {

	    	if(e.getActionCommand().equals("Submit"))
	    	{
	    		 String firstNameRaw=theView.firstNameField.getText();
	    		 String firstNameIn=firstNameRaw.toUpperCase();
	    		 String lastNameRaw=theView.lastNameField.getText();
	    		 String lastNameIn=lastNameRaw.toUpperCase();
	    		 System.out.println("lastNameIn: " + lastNameIn);
	    		 String homeAddressRaw=theView.homeAddressField.getText();
	    		 String homeAddressIn=homeAddressRaw.toUpperCase();
	    		 String phoneNumberIn=theView.phoneNumberField.getText();
	    		 
	    		 if (firstNameIn.length() > 0) 
	    		 {
	    			   		     		 
	    			 theView.firstNameField.setText("");
	    			 theView.lastNameField.setText("");
	    			 theView.homeAddressField.setText("");
	    			 theView.phoneNumberField.setText("");
	    		     		 
	    			 String firstNameOut = "\nContact for:"+"\n" + "First Name: " + firstNameIn;
	    			 String lastNameOut = "Last Name: " + lastNameIn;
	    			 System.out.println("lastNameOut: " + lastNameOut);
	    			 String homeAddressOut = "Home Address: " + homeAddressIn;
	    			 String phoneNumberOut = "Phone Number: " + phoneNumberIn;
	    		    		 
	    			 Contacts_Model contractEntry= new Contacts_Model(firstNameOut, lastNameOut, homeAddressOut, phoneNumberOut );
	    			 //Contacts_Model tempContact= new Contacts_Model();

	    			 theView.contractEntries.add(contractEntry);
	    		 
	    			 int size = theView.contractEntries.size(); 
	    			 System.out.println("contractEntries.size" + size);

	    			 /* 
	    			  * Remove duplicate Contacts
	    			  */
	    			 
	    			 ArrayList<Contacts_Model> contactsNoDups=contactsRemoveDups(theView.contractEntries);
	    			 
	    			 /* 
	    			  * Sort Contacts list
	    			  */
	    			 
	    			 ArrayList<Contacts_Model> contactSorted=sortContacts( contactsNoDups);
	    			     			 
	    			 theView.textArea.setText(null);
	    		   		 
	    			 for ( int i=0; i<contactSorted.size(); i++) 
	    			 {
	    				 System.out.println( "contactSorted["+ i + "] :" + contactSorted.get(i).getFirstname());
	    			 
	    				 theView.textArea.append(contactSorted.get(i).getFirstname() + "/n");
	    				 theView.textArea.append(contactSorted.get(i).getLastname() + "/n");
	    				 theView.textArea.append(contactSorted.get(i).gethomeAddress() + "/n");
	    				 theView.textArea.append(contactSorted.get(i).getphoneNumber() + "/n");    	
	    				 theView.textArea.setEditable(false);
	    			 }
	    		 }
	    		 else 
	    		 {
	    			 theView.textArea.setText(null);
	    			 theView.textArea.append("\n\nFirst Name is REQUIRED!!\n");
	    		 }
	    	}
	    }
	    
	    private static ArrayList<Contacts_Model> sortContacts( ArrayList<Contacts_Model> contacts)
	    {
	    	Contacts_Model tempContact= new Contacts_Model();
		 
			 int size = contacts.size(); 
	 
			 if (contacts.size()>1)
			 {
				for(int i = 0; i<size-1; i++)   
				{ 
					
					for (int j = i+1; j<contacts.size(); j++)   
					{  
						//compares each elements of the array to all the remaining elements  
						int result =contacts.get(i).getFirstname().compareTo(contacts.get(j).getFirstname());
						System.out.println("result: " + result );
						if(result>=1)   
						{  
							//swapping array elements
							tempContact = contacts.get(i); 
							contacts.set(i,contacts.get(j));
							contacts.set(j,tempContact);							
						}  
					}  
				} 
			 }   	
	    	 return contacts;
	    }
	 
	    private static ArrayList<Contacts_Model> contactsRemoveDups( ArrayList<Contacts_Model> contacts)
	    {			 
	    	int size = contacts.size();
	    	 for(int i = 0; i<size-1; i++)   
			 { 
					
				for (int j = i+1; j<contacts.size(); j++)   
				{  
					//compares each elements string value to all the remaining elements string values  

					int result0 =contacts.get(i).getFirstname().compareTo(contacts.get(j).getFirstname());
					System.out.println("result0: " + result0 );
					int result1 =contacts.get(i).getLastname().compareTo(contacts.get(j).getLastname());
					System.out.println("result1: " + result1 );
					int result2 =contacts.get(i).gethomeAddress().compareTo(contacts.get(j).gethomeAddress());
					System.out.println("result2: " + result2 );
					int result3 =contacts.get(i).getphoneNumber().compareTo(contacts.get(j).getphoneNumber());
					System.out.println("resul3t: " + result3 );
					if(result0==0 && result1==0 && result2==0 && result3==0)   
					{  
						//Remove duplicate element						
						contacts.remove(j); ;							
					} 
				}  
			}
	    	 return contacts;
	    }	
}

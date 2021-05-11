package mvc_demo;
 
import javax.swing.*;
import java.util.ArrayList; 
import java.awt.*;              //for layout managers and more
import java.awt.event.*; 		 //for action events
import java.awt.Container;
import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

 
public class Contacts_View extends JPanel
                             implements ActionListener 
{
    String newline = "\n";
    static String firstName = "First Name";
    JTextField firstNameField = new JTextField(10);
    static String lastName = "Last Name";
    JTextField lastNameField = new JTextField(10);
    static String homeAddress = "Home Address";
    JTextField homeAddressField = new JTextField(10);
    static String phoneNumber = "Phone Number";
    JFormattedTextField phoneNumberField = new JFormattedTextField();
    

    /*JFrame f = new JFrame();*/
    
    //Create a text area.
    JTextArea textArea = new JTextArea();
    
	// initialize  Contact Arraylist
	 ArrayList<Contacts_Model> contractEntries = new ArrayList<>(10);
	 ArrayList<Contacts_Model> tempEntries = new ArrayList<>(10);
    
    static String buttonString = "Submit";
 
    JLabel actionLabel;
 
    public Contacts_View() {
        setLayout(new BorderLayout());
 
        //Create a firstName text field.
        firstNameField.setActionCommand(firstName);
        firstNameField.addActionListener(this);
        
        //Create label for the field.
        JLabel firstNameLabel = new JLabel(firstName + ": ");
        firstNameLabel.setLabelFor(firstNameField);
 
        //Create a lastName text field.
        lastNameField.setActionCommand(lastName);
        lastNameField.addActionListener(this);
        
        //Create label for the field.
        JLabel lastNameLabel = new JLabel(lastName + ": ");
        lastNameLabel.setLabelFor(lastNameField);
                
      //Create a homeAddress text field.
       // JTextField homeAddressField = new JTextField(10);
        homeAddressField.setActionCommand(homeAddress);
        homeAddressField.addActionListener(this);
        
        //Create label for the field.
        JLabel homeAddressLabel = new JLabel(homeAddress + ": ");
        homeAddressLabel.setLabelFor(homeAddressField);
        
 
        //Create a formatted phoneNumber field.
        phoneNumberField.setActionCommand(phoneNumber);
        phoneNumberField.addActionListener(this);
        
        //Create label for the field.
        JLabel phoneNumberlabel = new JLabel(phoneNumber + ": ");
        phoneNumberlabel.setLabelFor(phoneNumberField);
              
        //Create a label to put messages during an action event.
        actionLabel = new JLabel("Type text in a field and press Enter.");
        actionLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
 
        //Lay out the text controls and the labels.
        JPanel textControlsPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
 
        textControlsPane.setLayout(gridbag);
         
        JLabel[] labels = {firstNameLabel, lastNameLabel, homeAddressLabel, phoneNumberlabel};
        JTextField[] textFields = {firstNameField, lastNameField, homeAddressField, phoneNumberField};
        addLabelTextRows(labels, textFields, gridbag, textControlsPane);
 
        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        textControlsPane.add(actionLabel, c);
        textControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Text Fields"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
 
        //add stuff for text area
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(450, 250));
        areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Plain Text"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));
         
        //Put everything together.
        JPanel leftPane = new JPanel(new BorderLayout());
        JButton SubmitButton = new JButton("Submit");
        SubmitButton.addActionListener(this);        
        leftPane.add(textControlsPane, 
                     BorderLayout.PAGE_START);
        leftPane.add(areaScrollPane,
                     BorderLayout.CENTER);
        leftPane.add(SubmitButton,
                BorderLayout.SOUTH);
        add(leftPane, BorderLayout.LINE_START);   

    }
    
    private void addLabelTextRows(JLabel[] labels,
                                  JTextField[] textFields,
                                  GridBagLayout gridbag,
                                  Container container) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        int numLabels = labels.length;
 
        for (int i = 0; i < numLabels; i++) {
            c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
            c.fill = GridBagConstraints.NONE;      //reset to default
            c.weightx = 0.0;                       //reset to default
            container.add(labels[i], c);
 
            c.gridwidth = GridBagConstraints.REMAINDER;     //end row
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1.0;
            container.add(textFields[i], c);
        }
    }

    public void actionPerformed(ActionEvent e) 
    {

    	if(e.getActionCommand().equals("Submit"))
    	{
    		 ;
    	}
    }
}


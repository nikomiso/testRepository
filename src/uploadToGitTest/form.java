package uploadToGitTest;

import java.text.*;
import java.util.Date;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import package formTest;

public class form {
	
	private static String date = "20/10/2014";
	static String name;
	static String surname;
	
	public static void main(String[] args) {
		
		//arxikopoiisi tou frame
		JFrame frame = new JFrame("Forma");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		frame.setVisible(true);		
		
	}
		
//i methodos ayti dimiourgei to GUI k prosthetei ta antikeimena sto panel mas
	private static void placeComponents(JPanel panel) {
		
		panel.setLayout(null);
		JLabel onomaLabel = new JLabel("Onoma");
		onomaLabel.setBounds(10, 10, 80, 25);
		panel.add(onomaLabel);

		final JTextField onomaText = new JTextField(20);
		onomaText.setBounds(100, 10, 160, 25);
		panel.add(onomaText);
		
		//kathe fora pou o xristis pliktrologei sto onomaText ginete elegxos k epitrepei ston xristi
		//mono ti xrisi grammaton
		onomaText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(!Character.isLetter(c)){
					Toolkit.getDefaultToolkit().beep();
					System.out.println("Only letters please");
					e.consume();
				}
			}
			});
		
		JLabel epithetoLabel = new JLabel("Epitheto");
		epithetoLabel.setBounds(10, 40, 80, 25);
		panel.add(epithetoLabel);

		//to idio me onomaText
		final JTextField epithetoText = new JTextField(20);
		epithetoText.setBounds(100, 40, 160, 25);
		panel.add(epithetoText);
		epithetoText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(!Character.isLetter(c)){
					Toolkit.getDefaultToolkit().beep();
					System.out.println("Only letters please");
					e.consume();
				}
			}
			});
		
		JLabel dateLabel = new JLabel("Imerominia");
		dateLabel.setBounds(10, 70, 80, 25);
		panel.add(dateLabel);

		final JTextField dateText = new JTextField(date);
		dateText.setBounds(100, 70, 160, 25);
		panel.add(dateText);
		
		//kathe fora pou o xristis pliktrologei sto dateText ginete elegxos k den epitrepei
		//ti xrisi grammaton
		dateText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(Character.isLetter(c)){
					Toolkit.getDefaultToolkit().beep();
					System.out.println("Not accepting letters");
					e.consume();
				}
			}
			});

		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(100, 120, 80, 25);
		panel.add(confirmButton);
		
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				date = dateText.getText();
				isValidDate(date);
				System.out.println("clicked");
				name = onomaText.getText();
				surname = epithetoText.getText();
				isValidName(name);
				isValidName(surname);
				System.out.println(name + " " + surname + " " + date);
			}
		});
		
		
	}
	
	public static boolean isValidName(String name)
	{
		String[] RestrictedSymbols = {"!","@","#","$","%","^","&","*","(",")","-","_","+","*","/"};
		if(name.isEmpty())
            return false;
        for(int i=0; i<=9; i++){
            if(name.contains(i+""))
                return false;
        }
        for(int i=0; i<RestrictedSymbols.length; i++){
            if(name.contains(RestrictedSymbols[i]))
                return false;
            }
           
		return true;
	}
	
	public static boolean isValidDate(String date)
	
	{
		//orismos tou format pou theloume
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date testDate = null;
	    
	    //testaroume to format an einai ayto pou theloume
	    //an den einai petaei exception
	    try
	    {
	      testDate = sdf.parse(date);
	    }
	    catch (ParseException e)
	    {
	      String errorMessage = "the date you provided is in an invalid date" + " format.";
	      System.out.println(errorMessage);
	      return false;
	    }
	    
	    //efoson einai sosto to format koitame an i imerominia iparxei
	    //px to 32/13/2014 den pernaei ton elegxo
	    
	    if (!sdf.format(testDate).equals(date))
	    {
	      String errorMessage = "The date that you provided is invalid.";
	      System.out.println(errorMessage);
	      return false;
	    }
	    return true;
	}
	

	
}
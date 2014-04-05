package bookCheck1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AddStdntPanel extends JPanel implements ActionListener{
	private JPanel logo;
	private JTextField fNameTxfld;
	private JTextField lNameTxFld;
	private JTextField pNameTxFld;
	private JTextField addrTxFld;
	private JTextField cityTxFld;
	private JTextField zipTxFld;
	private JTextField grpTxFld;
	
	public AddStdntPanel() {
		gui();
	}
	public void gui(){
		Layout layout=new Layout();

		setBackground(new Color(0, 0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);		
		
		JPanel panel=layout.panelBackground();
		add(panel);

		JPanel logo = new JPanel();
		logo.setBounds(295, 26, 164, 151);
		panel.add(logo);

		JLabel title = new JLabel("Add Student");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title.setForeground(Color.BLACK);
		title.setBounds(290, 188, 200, 60);
		panel.add(title);

		final JLabel fNameLbl = new JLabel("First Name : ");
		fNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fNameLbl.setBounds(158, 269, 98, 14);
		panel.add(fNameLbl);

		JLabel lNameLbl = new JLabel("Last Name : ");
		lNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lNameLbl.setBounds(158, 307, 98, 14);
		panel.add(lNameLbl);

		JLabel pNameLbl = new JLabel("Parent's Name :");
		pNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pNameLbl.setBounds(158, 348, 118, 14);
		panel.add(pNameLbl);

		JLabel addrLbl = new JLabel("Address : ");
		 addrLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 addrLbl.setBounds(158, 388, 98, 14);
		panel.add(addrLbl);

		JLabel cityLbl = new JLabel("City : ");
		cityLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cityLbl.setBounds(158, 413, 46, 40);
		panel.add(cityLbl);

		JLabel zipLbl = new JLabel("Zip : ");
		zipLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zipLbl.setBounds(158, 464, 46, 25);
		panel.add(zipLbl);

		JLabel grpLbl = new JLabel("Group : ");
		grpLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grpLbl.setBounds(158, 500, 67, 25);
		panel.add(grpLbl);

		fNameTxfld = new JTextField();
		fNameTxfld .setBounds(295, 268, 175, 20);
		panel.add(fNameTxfld );
		fNameTxfld .setColumns(10);

		lNameTxFld = new JTextField();
		lNameTxFld.setBounds(295, 306, 175, 20);
		panel.add(lNameTxFld);
		lNameTxFld.setColumns(10);

		pNameTxFld= new JTextField();
		pNameTxFld.setBounds(295, 347, 175, 20);
		panel.add(pNameTxFld);
		pNameTxFld.setColumns(10);

		addrTxFld= new JTextField();
		addrTxFld.setBounds(295, 387, 175, 20);
		panel.add(addrTxFld);
		addrTxFld.setColumns(10);

		cityTxFld= new JTextField();
		cityTxFld.setBounds(295, 425, 175, 20);
		panel.add(cityTxFld);
		cityTxFld.setColumns(10);

		zipTxFld = new JTextField();
		zipTxFld.setBounds(295, 468, 175, 20);
		panel.add(zipTxFld);
		zipTxFld.setColumns(10);

		grpTxFld = new JTextField();
		grpTxFld.setBounds(295, 504, 175, 20);
		panel.add(grpTxFld);
		grpTxFld.setColumns(10);

		JButton submitBttn = new JButton("Submit");
		submitBttn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		submitBttn.setBounds(335, 569, 90, 25);
		panel.add(submitBttn);

		JButton cancelBttn = new JButton("Cancel");
		cancelBttn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelBttn.setBounds(335, 603, 90, 25);
		panel.add(cancelBttn);
		
		//listens to buttons
		submitBttn.setActionCommand("Submit");
		submitBttn.addActionListener(this);
		cancelBttn.setActionCommand("Cancel");
		cancelBttn.addActionListener(this);	
	}
	//listens to buttons and gives info to fireEvent
    public void actionPerformed(ActionEvent e) {
    	fireEvent(e.getActionCommand());
    }
	//These 3 methods talk to BoookCheckWindow and PanelListener
	public void fireEvent(String event){
		Object[] listeners=listenerList.getListenerList();
		for(int i=0;i<listeners.length;i+=2){
			if(listeners[i]==PanelListener.class){
				((PanelListener)listeners[i+1]).eventHappen(event);
			}
		}
	}
	public void addDetailListener(PanelListener listener){
		listenerList.add(PanelListener.class, listener);
	}
	public void rmDetailListener(PanelListener listener){
		listenerList.remove(PanelListener.class, listener);
	}
}

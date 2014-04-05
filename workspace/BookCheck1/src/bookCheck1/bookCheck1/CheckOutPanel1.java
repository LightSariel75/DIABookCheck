package bookCheck1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CheckOutPanel1 extends JPanel implements ActionListener{
	private JTextField textField;
	public String[] itemLabel={"FirstName","LastName","Reading Level: ##","Books Checked Out: ##"};
	public String viewMode="Students";
	public JPanel panel=new JPanel();
	
	public CheckOutPanel1(){
		gui();
	}
	public void gui() {	
		String addMess="";
		String[] orgList;
		String[] orgList1 = { "First Name", "Last Name","Reading Level","Books Checked Out"};
		String[] orgList2 = { "Title", "Checked Out","Available"};
		String[] bkStdntList = {"Students","Books"};
		ListItem listItem=new ListItem();
		
		if(viewMode=="Students"){
			orgList=orgList1;
			addMess="Add Student";
		}
		else{			
			orgList=orgList2;
			addMess="Add Book";			
		}	
		
		setBackground(new Color(0, 0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		//JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 30, 875, 130);
		add(panel);
		panel.setLayout(null);
			
		//menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 895, 20);
		add(menuBar);	
		//File
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);			
		JMenu checkMItem = new JMenu("Check Book");
		fileMenu.add(checkMItem);	
		JMenuItem inMItem=new JMenuItem("In");
		checkMItem.add(inMItem);
		JMenuItem outMItem=new JMenuItem("Out");
		checkMItem.add(outMItem);
		JMenu addMItem = new JMenu("Add");
		fileMenu.add(addMItem);
		JMenuItem bookMItem=new JMenuItem("Book");
		addMItem.add(bookMItem);
		JMenuItem studMItem=new JMenuItem("Student");
		addMItem.add(studMItem);
		fileMenu.addSeparator();
		JMenuItem exitMItem = new JMenuItem("Exit");
		fileMenu.add(exitMItem);
		//Options
		JMenu optionMenu = new JMenu("Options");
		menuBar.add(optionMenu);
		//Help
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		//page title
		JLabel title = new JLabel("Book Check");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title.setBounds(362, 0, 164, 49);
		panel.add(title);		

		//Search things
		JButton submitBttn = new JButton("Submit");
		submitBttn.setBounds(208, 100, 89, 23);
		panel.add(submitBttn);		
		JLabel srchLbl = new JLabel("Search:");
		srchLbl.setBounds(10, 76, 46, 14);
		panel.add(srchLbl);
		textField = new JTextField();
		textField.setBounds(82, 73, 116, 20);
		panel.add(textField);
		textField.setColumns(10);		
		JLabel searchByLbl = new JLabel("Search By: ");
		searchByLbl.setBounds(10, 104, 70, 14);
		panel.add(searchByLbl);		
		JComboBox searchByCBox = new JComboBox(orgList);
		searchByCBox.setBounds(82, 100, 116, 20);
		panel.add(searchByCBox);
		
		//view things		
		JLabel viewLbl = new JLabel("View:");
		viewLbl.setBounds(700, 75, 46, 14);
		panel.add(viewLbl);		
		JComboBox viewCBox = new JComboBox(bkStdntList);
		viewCBox.setBounds(750, 75, 116, 20);
		panel.add(viewCBox);		
		JLabel sortLbl = new JLabel("Sort By:");
		sortLbl.setBounds(700, 100, 46, 14);
		panel.add(sortLbl);		
		JComboBox sortCBox = new JComboBox(orgList);
		sortCBox.setBounds(750, 100, 116, 20);
		panel.add(sortCBox);
		final JButton addBttn = new JButton(addMess);
		addBttn.setBounds(565, 94, 116, 29);
		panel.add(addBttn);
		
		//List 		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 170, 894, 500);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);	
		
		JPanel sPanel=new JPanel();
		sPanel.setBounds(0,0,900,550);
		sPanel.setLayout(new GridBagLayout());
		//list layout
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.NORTHWEST;
		constraint.fill = GridBagConstraints.NONE;
		constraint.gridx = 1;
		constraint.gridy = GridBagConstraints.RELATIVE;
		constraint.weightx = 1.0f;
		constraint.weighty = 1.0f;
		
		//query();
		//sort();
		//populate list
		for(int i=0;i<10;i++){
			JPanel itemList=listItem.listGui(itemLabel);
			sPanel.add(itemList,constraint);
			}	
		
		scrollPane.setViewportView(sPanel);
		add(scrollPane);
		
		//Action Lsiteners
		//Menu Items
		inMItem.setActionCommand("In");
		inMItem.addActionListener(this);
		outMItem.setActionCommand("Out");
		outMItem.addActionListener(this);
		bookMItem.setActionCommand("Add Book");
		bookMItem.addActionListener(this);
		studMItem.setActionCommand("Add Student");
		studMItem.addActionListener(this);
		exitMItem.setActionCommand("Exit");
		exitMItem.addActionListener(this);
		//Search Things
		//searchByCBox.setActionCommand("");
		//searchByCBox.addActionListener(this);
		submitBttn.setActionCommand("Submit");
		submitBttn.addActionListener(this);
		//View Things
		viewCBox.setActionCommand("combo");
		viewCBox.addActionListener(this);
		//sortCBox.setActionCommand("");
		//sortCBox.addActionListener(this);
		addBttn.setActionCommand(addMess);
		addBttn.addActionListener(this);
	}
    public void reformat(){
    	panel.removeAll();
    	panel.revalidate();
    	panel.repaint();
    	gui();
    }
    public void actionPerformed(ActionEvent e) {    
    	System.out.println(e.getSource());
    	if(e.getActionCommand()=="combo"){
            JComboBox cb = (JComboBox)e.getSource();
            String newSelection = (String)cb.getSelectedItem();
            viewMode=newSelection;
            reformat();}
    	else{fireEvent(e.getActionCommand());}
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
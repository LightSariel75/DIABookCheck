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

public class AddBookPanel extends JPanel implements ActionListener{
	private JPanel logo;
	private JTextField titleTxfld;
	private JTextField lvlofbkTxFld;
	private JTextField isbnTxFld;
	private JTextField conditionofbkTxFld;
	private JTextField langofbkTxFld;
	private JTextField numofcopiesTxFld;

	public AddBookPanel() {
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

		JLabel title = new JLabel("Add Book");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title.setForeground(Color.BLACK);
		title.setBounds(295, 188, 164, 60);
		panel.add(title);

		JLabel titleLbl = new JLabel("Title :");
		titleLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleLbl.setBounds(158, 269, 150, 20);
		panel.add(titleLbl);

		JLabel rLvlLbl = new JLabel("Reading Level : ");
		rLvlLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rLvlLbl.setBounds(158, 307, 150, 20);
		panel.add(rLvlLbl);

		JLabel isbnLbl = new JLabel("ISBN : ");
		isbnLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		isbnLbl.setBounds(158, 348, 150, 14);
		panel.add(isbnLbl);

		JLabel condLbl = new JLabel("Condition : ");
		condLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		condLbl.setBounds(158, 388, 150, 14);
		panel.add(condLbl);

		JLabel langLbl = new JLabel("Language : ");
		langLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		langLbl.setBounds(158, 413, 150, 40);
		panel.add(langLbl);
		
		JLabel setLbl = new JLabel("Number of Copies:");
		setLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setLbl.setBounds(158, 464, 150, 25);
		panel.add(setLbl);


		titleTxfld = new JTextField();
		titleTxfld .setBounds(295, 268, 174, 20);
		panel.add(titleTxfld );
		titleTxfld .setColumns(10);

		lvlofbkTxFld= new JTextField();
		lvlofbkTxFld.setBounds(295, 306, 174, 20);
		panel.add( lvlofbkTxFld);
		lvlofbkTxFld.setColumns(10);

		isbnTxFld= new JTextField();
		isbnTxFld.setBounds(295, 347, 174, 20);
		panel.add(isbnTxFld);
		isbnTxFld.setColumns(10);

		conditionofbkTxFld= new JTextField();
		conditionofbkTxFld.setBounds(295, 387, 174, 20);
		panel.add(conditionofbkTxFld);
		conditionofbkTxFld.setColumns(10);

		langofbkTxFld= new JTextField();
		langofbkTxFld.setBounds(295, 425, 174, 20);
		panel.add(langofbkTxFld);	
		langofbkTxFld.setColumns(10);

		numofcopiesTxFld = new JTextField();
		numofcopiesTxFld.setBounds(295, 468, 174, 20);
		panel.add(numofcopiesTxFld);
		numofcopiesTxFld.setColumns(10);


		JButton submitBttn = new JButton("Submit");
		submitBttn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		submitBttn.setBounds(335, 569, 89, 23);
		panel.add(submitBttn);

		JButton cancelBttn = new JButton("Cancel");
		cancelBttn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelBttn.setBounds(335, 603, 89, 23);
		panel.add(cancelBttn);
		
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
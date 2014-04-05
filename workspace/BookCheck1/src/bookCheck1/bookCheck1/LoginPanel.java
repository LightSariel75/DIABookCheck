package bookCheck1;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPanel extends JPanel implements ActionListener{
	private JTextField pswrdField;
	private JTextField unameField;
	private JLabel unameLabel;
	private JLabel pswrdLabel;
	
	public LoginPanel() {
		gui();
	}
	public void gui(){
		String path=Globals.smilePic;
		Layout layout=new Layout();

		setBackground(new Color(0, 0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);		
		
		JPanel panel=layout.panelBackground();
		add(panel);
		
		JButton loginBttn = new JButton("Login");
		loginBttn.setBounds(325, 500, 150, 50);
		panel.add(loginBttn);
		
		JButton ccBttn = new JButton("Create Account");
		ccBttn.setBounds(325, 560, 150, 23);
		panel.add(ccBttn);
		
		pswrdField = new JPasswordField();
		pswrdField.setBounds(325, 469, 150, 20);
		panel.add(pswrdField);
		pswrdField.setColumns(10);
		
		unameField = new JTextField();
		unameField.setBounds(325, 438, 150, 20);
		panel.add(unameField);
		unameField.setColumns(10);
		
		unameLabel = new JLabel();
		unameLabel.setBounds(229, 438, 86, 20);
		panel.add(unameLabel);
		unameLabel.setForeground(Color.BLACK);
		unameLabel.setBackground(Color.ORANGE);
		unameLabel.setText("Username: ");
		
		pswrdLabel = new JLabel();
		pswrdLabel.setBounds(229, 469, 86, 20);
		panel.add(pswrdLabel);
		pswrdLabel.setForeground(Color.BLACK);
		pswrdLabel.setText("Password: ");
		pswrdLabel.setBackground(Color.ORANGE);

		Image image=layout.getImage(path);
		JLabel picPanel = new JLabel(new ImageIcon(image));
		//JPanel picPanel = new JPanel();
		picPanel.setBounds(250, 75, 300, 300);
		panel.add(picPanel);
		
		//listens to buttons
		loginBttn.setActionCommand("Login");
		loginBttn.addActionListener(this);
		ccBttn.setActionCommand("Register");
		ccBttn.addActionListener(this);	
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

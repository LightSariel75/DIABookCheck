package bookCheck1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class TestPanel extends JPanel {

	public TestPanel() {
		gui();
	}
	public void gui(){
		setLayout(null);
		
		JButton Bttn = new JButton("BUTTON");
		Bttn.setBounds(301, 277, 89, 23);
		add(Bttn);
		
		final JLabel label = new JLabel("THIS PART IS NOT DONE YET");
		label.setFont(new Font("Tahoma", Font.PLAIN, 35));
		label.setBounds(10, 56, 746, 244);
		add(label);
		
		Bttn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				label.setText("This button does not do anything of use.");
			}
		});
	}
}

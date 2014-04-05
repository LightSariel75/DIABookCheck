package bookCheck1;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Layout extends JPanel{
	public void hello(){
		System.out.println("Hello");
	}
	public JPanel panelBackground(){
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.ORANGE);
		panel.setBounds(65, 0, 765, 700);
		panel.setLayout(null);
		//System.out.println("Hello");
		
		return panel;
		}
	public Image getImage(String path) {
		Image image=null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
package bookCheck1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ListItem {

	public JPanel listGui(String[] listItem){
		JPanel item= new JPanel();
		GroupLayout layout=new GroupLayout(item);
		item.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
	
		item.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		item.setPreferredSize(new Dimension(875, 100));
		Font font=new Font("Tahoma", Font.BOLD, 15);
	
		JLabel line1aLbl = new JLabel(listItem[0]);
		line1aLbl.setFont(font);
		item.add(line1aLbl);
		JLabel line1bLbl = new JLabel(listItem[1]);
		line1bLbl.setFont(font);
		item.add(line1bLbl);		
		JLabel rLvlLbl =new JLabel(listItem[2]);
		rLvlLbl.setFont(font);
		item.add(rLvlLbl);		
		JLabel checkedLbl=new JLabel(listItem[3]);
		checkedLbl.setFont(font);
		item.add(checkedLbl);
	
		JButton viewBttn=new JButton("View");
		item.add(viewBttn);
		JButton delBttn=new JButton("Delete");
		item.add(delBttn);
	
		JPanel picture=new JPanel();
		picture.setBackground(Color.ORANGE);
		picture.setPreferredSize(new Dimension(75,75));
		item.add(picture);
	
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGap(10)
		    .addComponent(picture)
		    .addGap(10)
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		        .addGroup(layout.createSequentialGroup()
		            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                .addComponent(line1aLbl)			                
		                .addComponent(rLvlLbl)
		                .addComponent(checkedLbl))
		            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                .addComponent(line1bLbl))))			                
		     .addGroup(layout.createSequentialGroup()
		    		 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		        .addComponent(viewBttn)
		        .addComponent(delBttn)))
				);
		layout.setVerticalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
		    .addGap(10)
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		.addComponent(picture)
		    .addGroup(layout.createSequentialGroup()			    		
		    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)	
		    					.addComponent(line1aLbl)
		    					.addComponent(line1bLbl)
		    					.addComponent(viewBttn))
		    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    					.addComponent(rLvlLbl))
		    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    					.addComponent(checkedLbl)
		    					.addComponent(delBttn))))
			);
	
		layout.linkSize(SwingConstants.HORIZONTAL, picture,viewBttn,delBttn);
		layout.linkSize(SwingConstants.VERTICAL, picture);
		return item;
	}
}
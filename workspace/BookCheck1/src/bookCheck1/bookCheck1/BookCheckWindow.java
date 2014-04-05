package bookCheck1;

import javax.swing.JFrame;

public class BookCheckWindow extends JFrame {	
	private static TestPanel testP;
	private static LoginPanel loginP;
	private static AddBookPanel addBkP;
	private static CheckOutPanel1 chckOut1P;
	private static AddStdntPanel addStdntP;
	
	private static QRgenerator qrGen;	
	private static DBConnect connect;
	
	public static void main(String[] args){
		DBConnect connect=new DBConnect();
		QRgenerator qrGen=new QRgenerator();		
		
		createFrame();
	}
	public static void createFrame(){		
		JFrame frame=new JFrame("Book Check");
		//import other panels
		testP= new TestPanel();
		loginP=new LoginPanel();
		addStdntP=new AddStdntPanel();
		addBkP=new AddBookPanel();
		chckOut1P=new CheckOutPanel1();
		
		//set up frame
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,700);
		frame.getContentPane().add(loginP);
	
		listeners(frame);
	}
	public static void listeners(final JFrame frame){
		
		loginP.addDetailListener(new PanelListener(){
			public void eventHappen(String event) {
				if(event=="Login"){frame.setContentPane(chckOut1P);}
				else if(event=="Register"){frame.setContentPane(testP);}
				frame.setVisible(true);
			}

		});	
		chckOut1P.addDetailListener(new PanelListener(){
			public void eventHappen(String event){
				switch(event){
				case "Add Student":frame.setContentPane(addStdntP);
				frame.setVisible(true);
					break;
				case "Add Book":frame.setContentPane(addBkP);
				frame.setVisible(true);
					break;
				case "Exit":frame.dispose();
					break;
				}
			}
		});
		addStdntP.addDetailListener(new PanelListener(){
			public void eventHappen(String event) {
				if(event=="Submit"){frame.setContentPane(chckOut1P);}
				else if(event=="Cancel"){frame.setContentPane(chckOut1P);}
				frame.setVisible(true);
			}

		});	
		addBkP.addDetailListener(new PanelListener(){
			public void eventHappen(String event) {
				if(event=="Submit"){frame.setContentPane(chckOut1P);}
				else if(event=="Cancel"){frame.setContentPane(chckOut1P);}
				frame.setVisible(true);
			}

		});	
	}
}


package clientGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Controller {
	
	//private JTextField textField_Input = new JTextField();
	
	public Model model;
	public InputOutput view;
	
	public Controller(Model m, InputOutput v) {
		this.model=m;
		this.view=v;
		this.view.assignListener(new ExecuteListener());
		this.view.connect(new Connect());
	}
	
class ExecuteListener implements ActionListener{
		
		public void actionPerformed (ActionEvent e) {
			 try {
				 view.displayResult(model.execute(view.getCommand()));	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}	
}
		

class Connect implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		 try {
			view.displayResult(model.connectServer(view.getIP(), view.getPort()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
} 
}

	



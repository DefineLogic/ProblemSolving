

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Picker 
{
        public static void main(String[] args) // main method
        {
        	//create object of JLabel and set label
        	JLabel label = new JLabel("Selected Date:");
        	//create object of JTextField and declare it final
        	final JTextField text = new JTextField(20);
        	//create object of JButton
        	JButton b = new JButton("popup");
        	//create object of JPanel
        	JPanel p = new JPanel();
        	p.add(label);
        	p.add(text);
        	p.add(b);
        	//create object of JFrame and declare it final
        	final JFrame f = new JFrame();
        	f.getContentPane().add(p);
        	f.pack();
        	f.setVisible(true);
        	//add action listener
        	b.addActionListener(new ActionListener() 
        	{
        		public void actionPerformed(ActionEvent ae) 
        		{
        			//set text i.e. date
        			text.setText(new DatePicker(f).setPickedDate());
        		}
            });
        }
}

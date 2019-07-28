

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPicker {

	public static void main(String[] args) {
			JPanel p=new JPanel();
			final JFrame f=new JFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLabel l=new JLabel("Selected Date:");
			final JTextField tf=new JTextField(20);
			JButton b=new JButton("..");
//			MyDatePicker pickerObj = new MyDatePicker(f,tf.getText()).setPickedDate();
			//final MyDatePicker pickerObj = new MyDatePicker(f, tf);
			p.add(l);
			p.add(tf);
			p.add(b);
			f.add(p);
        	f.add(p);
        	f.pack();
			f.setVisible(true);
			b.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent ae){ 
					tf.setText(new MyDatePicker(f,tf.getText()).setPickedDate());
					//System.out.println(tf.getText());
					//pickerObj.show();
					
				}

				
			});
				
			
	}

}

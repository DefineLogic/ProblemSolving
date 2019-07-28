

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
	     JFrame aWindow = new JFrame("MY CALCULATOR");
	   // aWindow.setBounds(300, 300, 300, 300);
	     aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     final JTextField tf=new JTextField();
	     tf.setSize(300,300);
	     aWindow.add(tf,BorderLayout.NORTH);
	     JPanel p2=new JPanel(new GridLayout(4,4));
	     p2.setPreferredSize(new Dimension(430,220));
	     final JButton[] button = new JButton[16];
	    String[] str={"1","2","3","<<","4","5","6","+","7","8","9","-","*","0","/","="};
	    final String[] value={""};
	    for(int i=0;i<str.length;i++)
	    {
	    final int selection=i;
	     button[i]= new JButton(str[i]);
	     button[i].setBackground(Color.WHITE);
	     button[i].setFocusPainted(false);
	     p2.add(button[i]);
	     if(i==15||i==3)
	    	continue;
	     button[i].addActionListener(new ActionListener() 
         {
                  public void actionPerformed(ActionEvent ae) 
                  {
                	  value[0] =button[selection].getActionCommand();    
                	  tf.setText(tf.getText()+value[0]);
                  }
                  
         });
	    }
	    button[3].addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		int len=tf.getText().length();
	    		tf.setText(tf.getText().substring(0,len-1));
	    	}
	    });
	    button[15].addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		tf.setText(String.valueOf((process(tf.getText()))));
	    	}
	    });
	    aWindow.add(p2,BorderLayout.SOUTH);
	    aWindow.pack();
	    aWindow.setVisible(true);
		   
	   
	}
	static int process(String s){
		boolean aa = false;
		ArrayList<Integer> ali=new ArrayList<Integer>();
		ArrayList<String> alc=new ArrayList<String>();
		if(s.charAt(0)=='-')
			 aa=true;
		String[] ar=s.split("\\W");
		for(String ss:ar)
		{
		if(ss.length()==0)
			continue;
		ali.add(Integer.parseInt(ss));}
		if(aa)
		{
		ali.add(0,ali.get(0)*-1);}	
		for(int i=0;i<s.length();i++)
		{
		
		if(Character.isDigit(s.charAt(i))){
			//ali.add(Integer.parseInt(s.charAt(i)+""));
			
		}
		else
			alc.add(s.charAt(i)+"");
		}
		if(aa)
		alc.remove(0);	
		int sum=fprocess(ali.get(0),alc.get(0),ali.get(1));
		int j=1;
		for(int i=2;i<ali.size();i++)
		{
			sum=fprocess(sum,alc.get(j),ali.get(i));
			if(ali.size()==(i+1))
				break;
			j++;
		}
		return sum;
	}
	static int fprocess(Integer i,String  c,Integer j){
		if(c.equals("+"))
		return i+j;
		else if(c.equals("-"))
			return i-j;
		else if(c.equals("*"))
			return i*j;
		else if(c.equals("/"))
			return i/j;
		else return 0;
		
	}
	
}



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyDatePicker {
	
	String pattern="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-\\.](0?[1-9]|1[012])[\\/\\-\\.](2015|2016|2017|2018)$";
	 int currentMonth=Calendar.getInstance().get(Calendar.MONTH);
	 int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	int month = Calendar.getInstance().get(Calendar.MONTH);
	int year = Calendar.getInstance().get(Calendar.YEAR);
	int date=Calendar.getInstance().get(Calendar.DATE);
	
	JButton fromDate;
	JButton toDate;
	JButton  gButton;
	
	JDialog d=new JDialog();
	JButton[] button = new JButton[49];
	MouseAdapter less;
    JTextField parentDateField = null;
    
	String day = "";
	Boolean check=true;
	
	public MyDatePicker(JFrame parent,String st) {
		String yearss="";
		
		
		 if (st.length() != 0 && st.matches(pattern)){
			check=false;
			int c=0,d=0,e=0,f=0;
			String all="";
			for(int i=0;i<st.length();i++)
			{
				if(Character.isDigit(st.charAt(i))){
					all=all+st.charAt(i);
				}
			}
			int intall=Integer.parseInt(all);
			c=intall/1000000;
			f=intall%1000000;
			d=f/10000;
			e=f%10000;
			currentMonth=d-1;
			currentYear=e;
			date=c;
			 yearss=String.valueOf(currentYear);

		}
		else{ 
			 yearss=String.valueOf(year);
			check=true;
		}
		
		

	
		d.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		JPanel p1 = new JPanel();
		
		String months[] = { "january", "february", "march", "april", "may","june", "july", "august", "september", "october", "november","december" };
		final JComboBox cb = new JComboBox(months);
		cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox) e.getSource();
				Object selected = cb.getSelectedItem();
                if(selected.toString().equals("january"))
                	month=0;
                else if(selected.toString().equals("february"))
                    month=1;
                else if(selected.toString().equals("march"))
                    month=2;
                else if(selected.toString().equals("april"))
                    month=3;
                else if(selected.toString().equals("may"))
                    month=4;
                else if(selected.toString().equals("june"))
                    month=5;
                else if(selected.toString().equals("july"))
                    month=6;
                else if(selected.toString().equals("august"))
                    month=7;
                else if(selected.toString().equals("september"))
                    month=8;
                else if(selected.toString().equals("october"))
                    month=9;
                else if(selected.toString().equals("november"))
                    month=10;
                else if(selected.toString().equals("december"))
                    month=12;
                System.out.println("month changed to"+month);
                System.out.println("final month is"+currentMonth);
				displayDate();
				}
				});

		String years[] = { "2015", "2016", "2017", "2018" };
		final JComboBox cbb = new JComboBox(years);
		cbb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cbb = (JComboBox) e.getSource();

                Object selected = cbb.getSelectedItem();
                if(selected.toString().equals("2015"))
                	year=2015;
                else if(selected.toString().equals("2016"))
                	year=2016;
                else if(selected.toString().equals("2017"))
                	year=2017;
                else if(selected.toString().equals("2018"))
                	year=2018;
                System.out.println("year changed to"+year);
                System.out.println("final year is"+currentYear);
				displayDate();
				
				
			}

		});

		JPanel p2 = new JPanel(new GridLayout(7, 7));
		p2.setPreferredSize(new Dimension(430, 120));
		for (int i = 0; i < button.length; i++) 
		{
			final int selection = i;
			button[i] = new JButton();
			button[i].setBackground(Color.white);
			button[i].setFocusPainted(false);
			if (i > 6){
				button[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			}
			if (i < 7) {
				// button[i].setFont(new Font("Arial", Font.PLAIN, 20));

				button[i].setText(header[i]);
				button[i].setForeground(Color.red);

			}

			p2.add(button[i]);
		}

		p1.add(cb);
		p1.add(cbb);
		d.add(p1, BorderLayout.NORTH);
		d.add(p2, BorderLayout.CENTER);

		d.setLocationRelativeTo(parent);
		d.pack();
		
		if(check){
			cb.setSelectedIndex(month);
		cbb.setSelectedItem(yearss);
		}
		else{
			cb.setSelectedIndex(currentMonth);
			cbb.setSelectedItem(yearss);
		}
		
		displayDate();
		d.setVisible(true);

	}

	public void displayDate() {
		//removing mouse listeners of each button,resetting their text to "" and background color to white in this loop
		for (int x = 7; x < button.length; x++){
        	button[x].setText("");
        	button[x].setBackground(Color.white);
          	//System.out.println("remove mouse listener from"+x);
        	MouseListener[] ml=button[x].getMouseListeners();
        	int count=1;
        	for(MouseListener ml1:ml)  
        	{
        	//System.out.println(ml1.toString());
        	if(!(count==1)){
        		button[x].removeMouseListener(ml1);
        	}
    		count++;

        	}
        	
		}
        int currentDatePlace=0;	
		Calendar cal=Calendar.getInstance();
		cal.set(year,month,1);
		int startDate=cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1,place=startDate+6;i<=numberOfDays;i++,place++){
			
			button[place].setText(""+i);
			//Adding green background to the current date or the entered date in textbox
			if(i==date && month==currentMonth && year==currentYear)
			{	
				button[place].setBackground(Color.green);
				currentDatePlace=place;
			}
			else{
				button[place].setBackground(Color.white);
			}
		}
		//Adding mouselisteners to each of the button
		for(int i=7;i<button.length;i++){
			final int selected = i;
			if(i==currentDatePlace && month==currentMonth && year==currentYear)
			{
				//System.out.println("abcdeff"+currentDatePlace);
				}
			else{
				  less=new MouseAdapter(){
					 public void mouseEntered(MouseEvent evt)
					 {
						 button[selected].setBackground(Color.gray);
					 }
					 public void mouseExited(MouseEvent evt){
					button[selected].setBackground(Color.white);	 
					 }
				 };
				//System.out.println("thisisssss");
					//System.out.println("putting mouselistener to" +i);
					button[i].addMouseListener(less);
			}
		}
		findGreenButton();
		
	}

	private MouseListener createMouseListener(final JButton jb) {
		return new MouseAdapter(){
			 public void mouseEntered(MouseEvent evt)
			 {
				 jb.setBackground(Color.gray);
			 }
			 public void mouseExited(MouseEvent evt){
			jb.setBackground(Color.white);	 
			 }
		 };
	}
	
	private JButton findGreenButton(){
		for(int i=7;i<button.length;i++){
			button[i].getBackground();
			if(button[i].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))
			{
				gButton=button[i];
			}
		}
		return gButton;
		
	}
	
	public String setPickedDate() {
		if (day.equals(""))
		{	
			//System.out.println("thisisempty");
			return day;
		}
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(year,month,Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}
	
	public void show() {
		d.setVisible(true);
	}

}

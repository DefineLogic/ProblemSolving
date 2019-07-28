

import javax.swing.JFrame;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class JDatePicker {

	public static void main(String[] args) {
		
		JFrame frame=new JFrame();
		frame.setTitle("Date Picker Example");
		frame.setSize(500, 500);
		frame.setLocation(200,  200);
		frame.setVisible(true);
		frame.setLayout(null);

		UtilDateModel model = new UtilDateModel();
		model.setDate(1990, 8, 24);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
		datePicker.setTextEditable(true);
	    datePicker.setShowYearButtons(true);
		
		 
		frame.add(datePicker);
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.utils;

import java.awt.FlowLayout;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Michael Kramer
 */
public class DateInputPanel extends JPanel {
    private JComboBox monthsBox;
    private JComboBox daysBox;
    
    public DateInputPanel () {
        addComponents();
    }
    
    private void addComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        //Makes the date drop downs to elliminate user entering error
        String[] months = new String[12];
        for (int i = 0; i < 12; i++) {
            months[i] = (i+1)+"";
        }
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = (i+1)+"";
        }
        
        
        monthsBox = new JComboBox(months);
        add(monthsBox);
        JLabel slash = new JLabel("/");
        add(slash);
        daysBox = new JComboBox(days);
        add(daysBox);
    }

    public int getMonth() {
        return Integer.parseInt(monthsBox.getSelectedItem().toString());
    }

    public int getDay() {
        return Integer.parseInt(daysBox.getSelectedItem().toString());
    }

    public void setDate(GregorianCalendar time) {
        //Gregorian Months start at 0 so index = month
        monthsBox.setSelectedIndex(time.get(GregorianCalendar.MONTH));
        //Gregoiran Days start at 1 so inex = date - 1;
        daysBox.setSelectedIndex(time.get(GregorianCalendar.DATE) - 1);
    }
    
    public Date getDate(){
        int month = getMonth();
        int date = getDay();
        return new Date(2017, month, date);
    }
    
    public GregorianCalendar getCalendar(){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getDate());
        return calendar;
    }
    
    
}

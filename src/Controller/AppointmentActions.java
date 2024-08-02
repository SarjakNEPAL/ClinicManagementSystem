/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author bhand
 */
public class AppointmentActions {
    public boolean isDateValid(String inputDate) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date currentDate = new Date();
            Date parsedInputDate = dateFormat.parse(inputDate);
            boolean isToday=true;
            boolean isAfterTwo=true;
            boolean isPast=true;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            if(!(parsedInputDate.equals(calendar.getTime()))) {
                // Input date is not today return true
                isToday=false;
            } 
            
            if(!(parsedInputDate.after(calendar.getTime()))) {
                // Input date is more than today
               isPast=false;
            } 
            
            calendar.add(Calendar.DAY_OF_MONTH, 2); // Add 2 days to current date

            if(!(parsedInputDate.after(calendar.getTime()))) {
                // Input date is more than 2 days in the future
               isAfterTwo=false;
            } 
            
            if(!isToday && !isAfterTwo && !isPast){
                return true;
            }
         // Input date is today or in the past
         return false;
            
        } catch (ParseException e) {
            // Handle invalid date format (e.g., non-parseable input)
            return false;
        }
    }
}

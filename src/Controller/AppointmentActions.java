/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Appointment;
import dao.StaffDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author bhand
 */
public class AppointmentActions {
    StaffDAO sda=new StaffDAO();
public boolean isDateValid(String inputDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    try {
        Date currentDate = new Date();
        Date parsedInputDate = dateFormat.parse(inputDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Calculate dates for tomorrow and the day after tomorrow
        calendar.add(Calendar.DAY_OF_MONTH, 1); // Tomorrow
        Date tomorrow = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1); // Day after tomorrow
        Date dayAfterTomorrow = calendar.getTime();

        // Check if the input date matches either of these
        if (parsedInputDate.equals(tomorrow) || parsedInputDate.equals(dayAfterTomorrow)) {
            return true;
        }

        // Check if the input date is today or in the past
        if (!parsedInputDate.after(currentDate)) {
            return true;
        }

        // Check if the input date is more than 2 days ahead
        calendar.add(Calendar.DAY_OF_MONTH, -2); // Reset to current date
        calendar.add(Calendar.DAY_OF_MONTH, 2); // Add 2 days to current date
        Date twoDaysAhead = calendar.getTime();
        if (!parsedInputDate.after(twoDaysAhead)) {
            return false;
        }

        // Input date is neither today, nor in the past, nor more than 2 days ahead
        return true;
    } catch (ParseException e) {
        // Handle invalid date format (e.g., non-parseable input)
        return false;
    }
}


    public boolean CommitAppointment(Appointment a){
        return sda.registerAppointment(a);
    }


    public boolean isAppointmentAvailable(Appointment a){
        return sda.isAppointmentFree(a);
    }
    
    public boolean isValidDoctor(String Doctor) {
        return Doctor.equals("Doctor 1") || Doctor.equals("Doctor 2") || Doctor.equals("Doctor 3") || Doctor.equals("Doctor 4") || Doctor.equals("Doctor 5");

    }
    public boolean isValidTime(String time) {
        return time.equals("10 AM") || time.equals("1 PM") || time.equals("3 PM");
    }

}


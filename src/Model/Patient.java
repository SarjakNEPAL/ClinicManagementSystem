package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bhand
 */
public class Patient {
    private String name;
    private String address;
    private String gender;
    private long phoneNumber;
      // Getter for 'name'
    public String getName() {
        return name;
    }

    // Setter for 'name'
    public void setName(String newName) {
        this.name = newName;
    }

    // Getter for 'address'
    public String getAddress() {
        return address;
    }

    // Setter for 'address'
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    // Getter for 'gender'
    public String getGender() {
        return gender;
    }

    // Setter for 'gender'
    public void setGender(String newGender) {
        this.gender = newGender;
    }

    // Getter for 'phoneNumber'
    public long getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for 'phoneNumber'
    public void setPhoneNumber(long newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
    
}

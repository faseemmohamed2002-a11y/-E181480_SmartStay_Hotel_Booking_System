/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartstay_e181480;

/**
 *
 * @author pc
 */
public class E181480_Guest {
    private String nic;
    private String fullName;
    private String contactNumber;
    private String email;
    public E181480_Guest(String nic, String fullName, String contact, String email){
        this.nic = nic; this.fullName = fullName; this.contactNumber = contact; this.email = email;
    }
    public String getNic(){ return nic; }
    public String getFullName(){ return fullName; }
    @Override
    public String toString(){ return fullName + " (" + nic + ") - " + contactNumber + " - " + email; }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package smartstay_e181480;

import java.time.LocalDate;
public class SmartStay_E181480 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        E181480_AdminControl admin = new E181480_AdminControl();
        admin.addRoom(new E181480_Room("R001", E181480_RoomType.STANDARD, "Single"));
        admin.addRoom(new E181480_Room("R002", E181480_RoomType.DELUXE, "Queen"));
        admin.addRoom(new E181480_Room("R003", E181480_RoomType.SUITE, "King"));
        admin.addRoom(new E181480_Room("R004", E181480_RoomType.FAMILY_SUITE, "King"));
        
        System.out.println("--- All Rooms ---");
        admin.viewAllRooms();

        E181480_Guest g1 = new E181480_Guest("199012345678", "Kasun Perera", "0771234567", "kasun@gmail.com");
        admin.registerGuest(g1);

        LocalDate in = LocalDate.now().plusDays(3);
        LocalDate out = LocalDate.now().plusDays(9); // 6 nights -> discount
        E181480_Booking b1 = admin.makeReservation("B001", g1.getNic(), "R001", in, out, 3);

        if (b1 != null) {
            System.out.println(b1.toString());
            E181480_Invoice inv = new E181480_Invoice("INV001", b1);
            System.out.println(inv.generateInvoice());
        }
    }
}
    
   


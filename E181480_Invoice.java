/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartstay_e181480;

/**
 *
 * @author pc
 */
import java.time.LocalDate;
public class E181480_Invoice {
    private String invoiceID; private String bookingID; private E181480_Booking booking; private LocalDate invoiceDate;
    public E181480_Invoice(String invoiceID, E181480_Booking booking){
        this.invoiceID = invoiceID; this.bookingID = booking.getBookingID(); this.booking = booking; this.invoiceDate = LocalDate.now();
    }
    public String generateInvoice(){
        StringBuilder sb = new StringBuilder();
        sb.append("========== SmartStay Invoice ==========\n");
        sb.append("Invoice ID: ").append(invoiceID).append("\n");
        sb.append("Invoice Date: ").append(invoiceDate).append("\n");
        sb.append("---------------------------------------\n");
        sb.append("Room Details: \n");
        sb.append("  Room ID: ").append(booking.getRoom().getRoomID()).append("\n");
        sb.append("  Room Type: ").append(booking.getRoom().getRoomType()).append("\n");
        sb.append("  Bed Type: ").append(booking.getRoom().getBedType()).append("\n");
        sb.append("  Daily Rate: LKR ").append(booking.getRoom().getDailyRate()).append("\n");
        sb.append("---------------------------------------\n");
        sb.append("Guest Details: ").append(booking.getGuest().toString()).append("\n");
        sb.append("---------------------------------------\n");
        sb.append("CheckIn: ").append(booking.getCheckIn()).append(" CheckOut: ").append(booking.getCheckOut()).append("\n");
        sb.append("Nights: ").append(booking.getNumberOfNights()).append(" Guests: ").append(booking.getNumberOfGuests()).append("\n");
        sb.append("---------------------------------------\n");
        sb.append("Base Charge: LKR ").append(booking.calculateBaseCharge()).append("\n");
        sb.append("Extra Guest: LKR ").append(booking.calculateExtraGuestCharge()).append("\n");
        sb.append("Discount (12%): -LKR ").append(booking.calculateDiscount()).append("\n");
        sb.append("Tax: +LKR ").append(booking.calculateTax()).append("\n");
        sb.append("Advance: -LKR 10000\n");
        sb.append("---------------------------------------\n");
        sb.append("FINAL Payable: LKR ").append(booking.calculateFinalAmount()).append("\n");
        sb.append("=======================================\n");
        return sb.toString();
    }
}


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
import java.time.temporal.ChronoUnit;
public class E181480_Booking {
    private String bookingID; private String guestID; private String roomID;
    private E181480_Room room; private E181480_Guest guest;
    private LocalDate checkIn; private LocalDate checkOut;
    private int numberOfGuests; private long numberOfNights;
    private static final double BOOKING_ADVANCE = 10000;
    private static final double DISCOUNT_RATE = 0.12;

    public E181480_Booking(String bookingID, E181480_Guest guest, E181480_Room room, LocalDate checkIn, LocalDate checkOut, int guests){
        this.bookingID = bookingID; this.guest = guest; this.guestID = guest.getNic();
        this.room = room; this.roomID = room.getRoomID(); this.checkIn = checkIn; this.checkOut = checkOut;
        this.numberOfGuests = guests; this.numberOfNights = ChronoUnit.DAYS.between(checkIn, checkOut);
    }
    public String getBookingID(){ return bookingID; }
    public String getGuestID(){ return guestID; }
    public String getRoomID(){ return roomID; }
    public E181480_Guest getGuest(){ return guest; }
    public E181480_Room getRoom(){ return room; }
    public LocalDate getCheckIn(){ return checkIn; }
    public LocalDate getCheckOut(){ return checkOut; }
    public int getNumberOfGuests(){ return numberOfGuests; }
    public long getNumberOfNights(){ return numberOfNights; }

    // ALGORITHMS
    public double calculateBaseCharge(){ return room.getDailyRate() * numberOfNights; }
    public double calculateExtraGuestCharge(){
        if(numberOfGuests > 2){ return (numberOfGuests - 2) * room.getRoomType().getExtraGuestCharge() * numberOfNights; }
        return 0;
    }
    public double calculateDiscount(){
        if(numberOfNights >= 5){ return calculateBaseCharge() * DISCOUNT_RATE; }
        return 0;
    }
    public double calculateTax(){
        double taxable = calculateBaseCharge() + calculateExtraGuestCharge() - calculateDiscount();
        return taxable * (room.getRoomType().getTaxRate()/100.0);
    }
    public double calculateFinalAmount(){
        double total = calculateBaseCharge() + calculateExtraGuestCharge() - calculateDiscount() + calculateTax() - BOOKING_ADVANCE;
        return total < 0 ? 0 : total;
    }
    public boolean isEligibleForCancel(){ return ChronoUnit.DAYS.between(LocalDate.now(), checkIn) >= 2; }
    @Override
    public String toString(){ return bookingID + " | Guest: " + guest.getFullName() + " | Room: " + roomID + " | " + checkIn + " to " + checkOut + " | Final: LKR " + calculateFinalAmount(); }
}


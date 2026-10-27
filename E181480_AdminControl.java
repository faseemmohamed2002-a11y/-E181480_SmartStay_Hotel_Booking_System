/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartstay_e181480;

/**
 *
 * @author pc
 */
import java.util.ArrayList; import java.util.List; import java.util.stream.Collectors; import java.time.LocalDate;
public class E181480_AdminControl {
    private List<E181480_Room> rooms = new ArrayList<>();
    private List<E181480_Guest> guests = new ArrayList<>();
    private List<E181480_Booking> bookings = new ArrayList<>();
    public void addRoom(E181480_Room room){ rooms.add(room); System.out.println("Room added: " + room.getRoomID()); }
    public void updateRoom(String roomID, E181480_RoomType newType, String newBed){
        for(E181480_Room r: rooms){ if(r.getRoomID().equals(roomID)){ r.setRoomType(newType); r.setBedType(newBed); return; } }
    }
    public void removeRoom(String roomID){ rooms.removeIf(r->r.getRoomID().equals(roomID)); }
    public void viewAllRooms(){ rooms.forEach(System.out::println); }
    public void manageAvailability(String roomID, E181480_AvailabilityStatus status){ for(E181480_Room r: rooms){ if(r.getRoomID().equals(roomID)) r.setAvailabilityStatus(status); } }
    public void registerGuest(E181480_Guest g){ guests.add(g); }
    public List<E181480_Room> searchAvailableRooms(E181480_RoomType type, LocalDate checkIn, LocalDate checkOut){
        return rooms.stream().filter(r-> r.getRoomType()==type && r.isAvailable()).filter(r-> isRoomFree(r.getRoomID(), checkIn, checkOut)).collect(Collectors.toList());
    }
    private boolean isRoomFree(String roomID, LocalDate in, LocalDate out){
        for(E181480_Booking b: bookings){ if(b.getRoomID().equals(roomID)){ if(!(out.isBefore(b.getCheckIn()) || in.isAfter(b.getCheckOut()))){ return false; } } }
        return true;
    }
    public E181480_Booking makeReservation(String bookingID, String guestNic, String roomID, LocalDate in, LocalDate out, int guestsCount){
        E181480_Guest g = guests.stream().filter(x->x.getNic().equals(guestNic)).findFirst().orElse(null);
        E181480_Room r = rooms.stream().filter(x->x.getRoomID().equals(roomID)).findFirst().orElse(null);
        if(g==null || r==null){ System.out.println("Guest or Room not found"); return null; }
        if(!r.isAvailable()){ System.out.println("Room not available"); return null; }
        if(in.isBefore(LocalDate.now().plusDays(2))){ System.out.println("Must book 2 days advance"); return null; }
        E181480_Booking b = new E181480_Booking(bookingID, g, r, in, out, guestsCount);
        bookings.add(b); System.out.println("Booking successful: " + bookingID); return b;
    }
    public List<E181480_Booking> searchByGuestName(String name){ return bookings.stream().filter(b-> b.getGuest().getFullName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList()); }
    public E181480_Booking searchByBookingID(String id){ return bookings.stream().filter(b-> b.getBookingID().equals(id)).findFirst().orElse(null); }
    public List<E181480_Booking> viewByCheckInDate(LocalDate date){ return bookings.stream().filter(b-> b.getCheckIn().equals(date)).collect(Collectors.toList()); }
    public void cancelReservation(String bookingID){ E181480_Booking b = searchByBookingID(bookingID); if(b!=null && b.isEligibleForCancel()){ bookings.remove(b); System.out.println("Cancelled: "+bookingID); } else { System.out.println("Cannot cancel"); } }
}


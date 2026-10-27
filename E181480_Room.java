/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartstay_e181480;

/**
 *
 * @author pc
 */
public class E181480_Room {
    private String roomID; // PK
    private E181480_RoomType roomType;
    private String bedType;
    private double dailyRate;
    private E181480_AvailabilityStatus availabilityStatus;

    public E181480_Room(String roomID, E181480_RoomType type, String bedType){
        this.roomID = roomID;
        this.roomType = type;
        this.bedType = bedType;
        this.dailyRate = type.getDailyRate();
        this.availabilityStatus = E181480_AvailabilityStatus.AVAILABLE;
    }
    public String getRoomID(){ return roomID; }
    public E181480_RoomType getRoomType(){ return roomType; }
    public String getBedType(){ return bedType; }
    public double getDailyRate(){ return dailyRate; }
    public E181480_AvailabilityStatus getAvailabilityStatus(){ return availabilityStatus; }
    public void setAvailabilityStatus(E181480_AvailabilityStatus s){ this.availabilityStatus = s; }
    public void setBedType(String b){ this.bedType = b; }
    public void setRoomType(E181480_RoomType t){ this.roomType = t; this.dailyRate = t.getDailyRate(); }
    public boolean isAvailable(){ return availabilityStatus == E181480_AvailabilityStatus.AVAILABLE; }
    @Override
    public String toString(){
        return roomID + " | " + roomType + " | " + bedType + " | LKR " + dailyRate + " | " + availabilityStatus;
    }
}


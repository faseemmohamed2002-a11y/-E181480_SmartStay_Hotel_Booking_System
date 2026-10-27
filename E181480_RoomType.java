/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartstay_e181480;

/**
 *
 * @author pc
 */
public enum E181480_RoomType {
    STANDARD(6000, 1000, 10, false),
    DELUXE(9000, 1500, 12, true),
    SUITE(14000, 2000, 15, true),
    FAMILY_SUITE(18000, 2500, 15, true);

    private final double dailyRate;
    private final double extraGuestCharge;
    private final double taxRate;
    private final boolean breakfast;

    E181480_RoomType(double rate, double extra, double tax, boolean bf){
        this.dailyRate = rate;
        this.extraGuestCharge = extra;
        this.taxRate = tax;
        this.breakfast = bf;
    }
    public double getDailyRate(){ return dailyRate; }
    public double getExtraGuestCharge(){ return extraGuestCharge; }
    public double getTaxRate(){ return taxRate; }
    public boolean hasBreakfast(){ return breakfast; }
}


package sg.edu.rp.c346.id21012377.carparkavailability;

public class Carpark {
    String carpark_Number;
    String total_Lots;
    String lots_available;
    String lot_type;

    public Carpark(String carpark_Number, String total_Lots, String lots_available, String lot_type) {
        this.carpark_Number = carpark_Number;
        this.total_Lots = total_Lots;
        this.lots_available = lots_available;
        this.lot_type = lot_type;
    }

    public String getCarpark_Number() {
        return carpark_Number;
    }

    public void setCarpark_Number(String carpark_Number) {
        this.carpark_Number = carpark_Number;
    }

    public String getTotal_Lots() {
        return total_Lots;
    }

    public void setTotal_Lots(String total_Lots) {
        this.total_Lots = total_Lots;
    }

    public String getLots_available() {
        return lots_available;
    }

    public void setLots_available(String lots_available) {
        this.lots_available = lots_available;
    }

    public String getLots_type() {
        return lot_type;
    }

    public void setLots_type(String lots_type) {
        this.lot_type = lots_type;
    }

    @Override
    public String toString() {
        return "Carpark{" +
                "carpark_Number='" + carpark_Number + '\'' +
                ", total_Lots='" + total_Lots + '\'' +
                ", lots_available='" + lots_available + '\'' +
                ", lot_type='" + lot_type + '\'' +
                '}';
    }
}

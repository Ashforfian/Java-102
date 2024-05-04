package PatikaStore;

import java.util.InputMismatchException;

public class MobilePhone extends Product{
    private int battery;
    private String color;
    public MobilePhone(int id, String name, double prize, int stock, double saleRate, int storage, double screenSize, int ram, int battery, String color, Brand brand) {
        super(id, name, prize, stock, saleRate, storage, screenSize, ram, brand);
        this.battery = battery;
        this.color = color;
    }
    public MobilePhone(){

    }
    @Override
    public void setStorage(int storage){
        if (storage == 32 || storage == 64 || storage == 128 || storage == 256){
            super.setStorage(storage);
        }else {
            throw new InputMismatchException("Yanlış bir depolama değeri girildi!");
        }
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String  toString(){
        return super.toString()+
                ", color= "+this.color+
                ", battery= "+this.battery;
    }
}

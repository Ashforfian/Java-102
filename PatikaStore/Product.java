package PatikaStore;

public class Product {
    private int id;
    private String name;
    private double prize;
    private int stock;
    private double saleRate;
    private int storage;
    private double screenSize;
    private int ram;
    private int battery;
    private String color;
    private Brand brand;

    public Product(int id, String name, double prize, int stock, double saleRate, int storage, double screenSize,
                   int ram, Brand brand) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.stock = stock;
        this.saleRate = saleRate;
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;


        this.brand = brand;
    }
    public Product(){}

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", prize=" + prize +
                ", stock=" + stock +
                ", saleRate=" + saleRate +
                ", storage=" + storage +
                ", screenSize=" + screenSize +
                ", ram=" + ram +
                ", brand=" + brand.getName() ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(double saleRate) {
        this.saleRate = saleRate;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

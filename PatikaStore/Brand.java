package PatikaStore;

import java.util.LinkedList;
import java.util.ListIterator;

public class Brand {
    private String name;
    private String id;
    public static LinkedList<Brand> brands = new LinkedList<>();

    public Brand(String name, String id) {
        this.name = name;
        this.id = id;
        addToBrands(this);
    }

    public static void generateDatabase(){
        String[] exampleBrands = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for (int i = 0;i < exampleBrands.length; i++ ){
            Brand b1 = new Brand(exampleBrands[i]," ");
        }

    }
    public static void addToBrands(Brand newBrand) {
        ListIterator<Brand> iterator = brands.listIterator();

        while (iterator.hasNext()) {
            int comparison = iterator.next().getName().compareTo(newBrand.getName());
            if (comparison > 0) {
                iterator.previous();
                iterator.add(newBrand);
                return;
            }
        }

        iterator.add(newBrand);
    }

    public static void print(){
        for (Brand brand: brands){
            System.out.println(brand.getName()+"  ");
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id='" + id + '\'' ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

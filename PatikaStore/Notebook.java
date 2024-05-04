package PatikaStore;

import java.util.InputMismatchException;

public class Notebook extends Product {
    private int[] storages;

    public Notebook(int id, String name, double prize, int stock, double saleRate, int storage, double screenSize, int ram, Brand brand) {
        super(id, name, prize, stock, saleRate, storage, screenSize, ram, brand);
        storages = new int[]{128, 256, 512, 1024, 2048, 3072, 4096};
    }
    public Notebook(){
        storages = new int[]{128, 256, 512, 1024, 2048, 3072, 4096};
    }

    @Override

    public void setStorage(int storage) {
        boolean control = true;
        for (int i = 0; i < storages.length; i++){
            if (storage == storages[i]){
                super.setStorage(storage);
                control = false;
                break;
            }
        }if (control){
            throw new InputMismatchException("Yanlış bir depolama değeri girildi!");
        }
    }
}

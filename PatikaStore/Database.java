package PatikaStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    ArrayList<Product> products;
    Scanner input = new Scanner(System.in);

    public Database() {
        products = new ArrayList<>();
    }

    public void inputProductMobile() {
        MobilePhone newProduct = new MobilePhone();
        System.out.println();
        System.out.print("Ürünün adını giriniz: ");
        newProduct.setName(input.next());
        System.out.print("Ürünün rengini giriniz: ");
        newProduct.setColor(input.next());
        System.out.print("Ürünün marka ismini giriniz: ");
        String brandName = input.next().toLowerCase().trim();
        boolean findBrand = false;
        for (Brand b : Brand.brands) {
            if (b.getName().toLowerCase().trim().equals(brandName)) {
                newProduct.setBrand(b);
                findBrand = true;
                break;
            }
        }
        if (!findBrand) {
            System.out.print("Markanın id'sini giriniz: ");
            String brandId = input.next();
            Brand newBrand = new Brand(brandName, brandId);
            newProduct.setBrand(newBrand);
        }
        System.out.print("Batarya boyutunu giriniz: ");
        newProduct.setBattery(input.nextInt());
        System.out.print("Ürünün id'sini giriniz: ");
        newProduct.setId(input.nextInt());
        System.out.print("Ürünün fiyatını giriniz: ");
        newProduct.setPrize(input.nextDouble());
        System.out.print("Ürünün stok adedini giriniz: ");
        newProduct.setStock(input.nextInt());
        System.out.print("Ürünün indirim oranını giriniz: ");
        newProduct.setSaleRate(input.nextDouble());
        System.out.print("Ürünün depolayabildiği hafızayı giriniz: ");
        newProduct.setStorage(input.nextInt());
        System.out.print("Ürünün ekran boyutunu giriniz: ");
        newProduct.setScreenSize(input.nextDouble());
        System.out.print("Ürünün ram boyutunu giriniz: ");
        newProduct.setRam(input.nextInt());
        System.out.println("Ürün başarıyla eklenmiştir!");
        System.out.println(newProduct);

        products.add(newProduct);
    }

    public void inputProductNotebook() {
        Notebook newProduct = new Notebook();
        System.out.println();
        System.out.print("Ürünün adını giriniz: ");
        newProduct.setName(input.next());
        System.out.print("Ürünün marka ismini giriniz: ");
        String brandName = input.next().toLowerCase().trim();
        boolean findBrand = false;
        for (Brand b : Brand.brands) {
            if (b.getName().toLowerCase().trim().equals(brandName)) {
                newProduct.setBrand(b);
                findBrand = true;
                break;
            }
        }
        if (!findBrand) {
            System.out.print("Markanın id'sini giriniz: ");
            String brandId = input.next();
            Brand newBrand = new Brand(brandName, brandId);
            newProduct.setBrand(newBrand);
        }
        System.out.print("Ürünün id'sini giriniz: ");
        newProduct.setId(input.nextInt());
        System.out.print("Ürünün fiyatını giriniz: ");
        newProduct.setPrize(input.nextDouble());
        System.out.print("Ürünün stok adedini giriniz: ");
        newProduct.setStock(input.nextInt());
        System.out.print("Ürünün indirim oranını giriniz: ");
        newProduct.setSaleRate(input.nextDouble());
        System.out.print("Ürünün depolayabildiği hafızayı giriniz: ");
        newProduct.setStorage(input.nextInt());
        System.out.print("Ürünün ekran boyutunu giriniz: ");
        newProduct.setScreenSize(input.nextDouble());
        System.out.print("Ürünün ram boyutunu giriniz: ");
        newProduct.setRam(input.nextInt());
        System.out.println("Ürün başarıyla eklenmiştir!");
        System.out.println(newProduct);

        products.add(newProduct);
    }

    public void removeNotebook() {
        System.out.print("Ürünün id'sini giriniz: ");
        int removedId = input.nextInt();
        for (Product product : products) {
            if (product instanceof Notebook) {
                if (product.getId() == removedId) {
                    products.remove(product);
                    System.out.println("Ürün başarıyla silinmiştir.");
                    break;
                }
            }
        }
    }

    public void removeMobilePhone() {
        System.out.print("Ürünün id'sini giriniz: ");
        int removedId = input.nextInt();
        for (Product product : products) {
            if (product instanceof MobilePhone) {
                if (product.getId() == removedId) {
                    products.remove(product);
                    System.out.println("Ürün başarıyla silinmiştir.");
                    break;
                }
            }
        }
    }

    public void displayNotebook() {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("| %-3s | %-30s | %-10s | %-10s | %-10s | %-10s | %-8s |\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Product product : products) {
            if (product instanceof Notebook) {
                Notebook notebook = (Notebook) product;
                System.out.format("| %-3d | %-30s | %-10.2f | %-10s | %-10d | %-10.1f | %-8d |\n", notebook.getId(), notebook.getName(), notebook.getPrize(), notebook.getBrand().getName(), notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public void printMobilePhoneList() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-3s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Pil", "RAM", "Renk");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (Product product : products) {
            if (product instanceof MobilePhone) {
                MobilePhone mobilePhone = (MobilePhone) product;
                System.out.format("| %-3d | %-30s | %-10.2f | %-10s | %-10d | %-10.1f | %-10d | %-10d | %-10s |\n",
                        mobilePhone.getId(), mobilePhone.getName(), mobilePhone.getPrize(), mobilePhone.getBrand().getName(),
                        mobilePhone.getStorage(), mobilePhone.getScreenSize(), mobilePhone.getBattery(),
                        mobilePhone.getRam(), mobilePhone.getColor());
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Brand.generateDatabase();
        Database database = new Database();
        String menu = "PatikaStore Ürün Yönetim Paneli !\n" +
                "1 - Notebook İşlemleri\n" +
                "2 - Cep Telefonu İşlemleri\n" +
                "3 - Marka Listele\n" +
                "0 - Çıkış Yap";

        while (true) {
            int select = -1;
            while (true) {
                System.out.println(menu);
                System.out.print("Tercihiniz: ");
                try {
                    select = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Lütfen geçerli bir değer giriniz!!");
                    input.next();
                }
                if (select < 4 && select >= 0) {
                    break;
                }
            }
            if (select == 1) {
                String menuNotebook = "1 - Notebook Ekle\n" +
                        "2 - Notebook Listele\n" +
                        "3 - Notebook Sil";
                int select1 = -1;
                while (true) {
                    System.out.println(menuNotebook);
                    System.out.print("Tercihiniz: ");
                    try {
                        select1 = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Lütfen geçerli bir değer giriniz!!");
                        input.next();
                    }
                    if (select1 < 4 && select1 > 0) {
                        break;
                    }
                }
                if (select1 == 1) {
                    database.inputProductNotebook();
                } else if (select1 == 2) {
                    database.displayNotebook();
                } else {
                    database.removeNotebook();
                }

            } else if (select == 2) {
                String menuMobile = "1 - Cep Telefonu Ekle\n" +
                        "2 - Cep Telefonu Listele\n" +
                        "3 - Cep Telefonu Sil";
                int select2 = -1;
                while (true) {
                    System.out.println(menuMobile);
                    System.out.print("Tercihiniz: ");
                    try {
                        select2 = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Lütfen geçerli bir değer giriniz!");
                        input.next();
                    }
                    if (select2 < 4 && select2 > 0) {
                        break;
                    }
                }
                if (select2 == 1) {
                    database.inputProductMobile();
                } else if (select2 == 2) {
                    database.printMobilePhoneList();
                } else {
                    database.removeMobilePhone();
                }
            } else if (select == 3) {
                Brand.print();
            } else {
                break;
            }
        }
    }
}

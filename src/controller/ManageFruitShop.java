/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author MSII
 */
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import model.Fruit;
import view.Menu;
import validation.Validation;

public class ManageFruitShop extends Menu<String> {

    private List<Fruit> listFruit;
    private Hashtable<String, List<Fruit>> hashTable;
    private Validation vl;

    public ManageFruitShop() {
        super("Fruit Shop Menu", new String[]{"Create Product", "Shopping", "View Orders", "Exit"});
        listFruit = new ArrayList<>();
        hashTable = new Hashtable<>();
        vl = new Validation();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createProduct();
                break;
            case 2:
                shopping();
                break;
            case 3:
                viewOrders();
                break;
            case 4:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void createProduct() {
        while (true) {
            String nameFruit = vl.inputString("Enter fruit name: ");
            String idFruit = vl.inputString("Enter fruit id: ");
            double price = vl.inputDouble("Enter price: ", 0, 1000);
            int quantity = vl.inputInt("Enter quantity: ", 0, 100);
            String origin = vl.inputString("Enter origin: ");

            Fruit f = new Fruit(idFruit, nameFruit, price, quantity, origin);
            listFruit.add(f);

            String option = vl.inputString("Do you want to create another fruit (Y|N)? ");
            if (!option.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private void shopping() {
        List<Fruit> listItemBought = new ArrayList<>();
        String option; // Khai báo biến option để lưu lựa chọn của người dùng 
        while (true) {
            System.out.println("List of Fruit:");
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");

             // Hiển thị danh sách các loại trái cây với định dạng bảng
            for (int i = 0; i < listFruit.size(); i++) {
                Fruit f = listFruit.get(i);
                System.out.printf("       %-13s%-18s%-15s%-10s", f.getIdFruit(), f.getNameFruit(), 
                        f.getOrigin(), String.format("%.2f", f.getPrice()));
                System.out.println("\n");
            }

            int selected = vl.inputInt("Enter item you want to order", 1, listFruit.size()); // Lấy lựa chọn của người dùng
            Fruit selectedFruit = listFruit.get(selected - 1);  // Lấy trái cây được chọn từ danh sách
            System.out.println("You selected: " + selectedFruit.getNameFruit());

            int availableQuantity = selectedFruit.getQuantity();
            int quantity = vl.inputInt("Please input quantity (Available: " + availableQuantity + ")", 0, availableQuantity);

            if (quantity > 0) {
                option = vl.inputString("Do you want to order another fruit (Y|N)? ");

                if (option.equalsIgnoreCase("Y")) {
                    selectedFruit.setQuantity(availableQuantity - quantity);  // Cập nhật số lượng trái cây còn lại
                    selectedFruit = new Fruit(selectedFruit.getIdFruit(), selectedFruit.getNameFruit(),
                            selectedFruit.getPrice(), quantity, selectedFruit.getOrigin());
                    listItemBought.add(selectedFruit);
                }
            } else {
                System.out.println("Invalid quantity. Please enter a valid quantity.");
                continue;
            }

            if (!option.equalsIgnoreCase("Y")) {
                continue;
            } else {
                System.out.println("Product | Quantity | Price | Amount ");
                double total = 0;
                for (Fruit f : listItemBought) {
                    System.out.printf("%-9.2s%-9d%-9s%-9s\n", f.getNameFruit(), 
                            f.getQuantity(), String.format("%.2f", f.getPrice()), 
                            String.format("%.2f", (f.getQuantity() * f.getPrice())));
                    total += f.getQuantity() * f.getPrice();
                }
                System.out.println("Total: " + String.format("%.2f", total));
                String nameCustomer = vl.inputString("Input your name: ");
                // Lưu thông tin đơn hàng vào hashtable
                hashTable.put(nameCustomer, listItemBought);  
                break;
            }
        }
    }

    private void viewOrders() {
        Enumeration<String> nameCustomerList = hashTable.keys();
        while (nameCustomerList.hasMoreElements()) {
            String nameCustomer = nameCustomerList.nextElement();
            System.out.println("Customer: " + nameCustomer);
            System.out.println("Product | Quantity | Price | Amount ");
            double total = 0;
            for (Fruit f : hashTable.get(nameCustomer)) {
                System.out.printf("%-9s%-9d%-9.2f%-9.2f\n", f.getNameFruit(), f.getQuantity(), f.getPrice(), (f.getQuantity() * f.getPrice()));
                total += f.getQuantity() * f.getPrice();
            }
            System.out.println("Total: " + total);
        }
    }
}

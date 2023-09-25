/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSII
 */
public class Fruit {
    private String idFruit;
    private String nameFruit;
    private double price;
    private int quantity;
    private String origin;

    public Fruit(String idFruit, String nameFruit, double price, int quantity, String origin) {
        this.idFruit = idFruit;
        this.nameFruit = nameFruit;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public Fruit() {
    }

    public String getIdFruit() {
        return idFruit;
    }

    public void setIdFruit(String idFruit) {
        this.idFruit = idFruit;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Fruit{" + "idFruit=" + idFruit + ", nameFruit=" + nameFruit + ", price=" + price + ", quantity=" + quantity + ", origin=" + origin + '}';
    }
}

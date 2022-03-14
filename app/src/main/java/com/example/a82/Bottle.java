package com.example.a82;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matia
 */
public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double price;
    
    public Bottle(){
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        total_energy = 0.3;
        size = 0.5;
        price = 1.8;
    }

    public Bottle(String name,  double size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getTotal_energy() {
        return total_energy;
    }

    public void setTotal_energy(double total_energy) {
        this.total_energy = total_energy;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

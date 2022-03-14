package com.example.a82;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matia
 */
import java.util.*;
import java.text.*;

public class BottleDispenser {

    private int bottles;
    private double money;
    private ArrayList<Bottle> bottle_array;
    private ArrayList<String> stringBottles;
    
    private static BottleDispenser bd = new BottleDispenser();
    

    private BottleDispenser() {
        bottles = 5;
        money = 0;
        bottle_array = new ArrayList();
        bottle_array.add(new Bottle("Pepsi Max", 0.5, 1.8));
        bottle_array.add(new Bottle("Pepsi Max", 1.5, 2.2));
        bottle_array.add(new Bottle("Coca-Cola Zero", 0.5, 2.0));
        bottle_array.add(new Bottle("Coca-Cola Zero", 1.5, 2.5));
        bottle_array.add(new Bottle("Fanta Zero", 0.5, 1.95));
    }
    
    public static BottleDispenser getInstance(){
        return bd;
    }

    public int getBottles() {
        return bottles;
    }

    public ArrayList<String> getStringBottles() {
        bd.bottlestoString();
        return stringBottles;
    }

    public ArrayList<Bottle> getBottleArray() { return bottle_array;}

    public void setBottles(int bottles) {
        this.bottles = bottles;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(double lisays) {
        money += lisays;
        System.out.println("Klink! Added more money!");

    }

    public int buyBottle(int drink_choice) {
        if (bottles>0) {
            if (money > bottle_array.get(drink_choice).getPrice()) {
                System.out.println("KACHUNK! "+bottle_array.get(drink_choice).getName()+" came out of the dispenser!");
                money -= bottle_array.get(drink_choice).getPrice();
                bottles -=1;
                return 1;
            } else {
                System.out.println("Add money first!");
                return 2;
            }
        }else{
            System.out.println("Out of bottles!");
            return 3;
        }
    }

    public void returnMoney() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Klink klink. Money came out! You got "+df.format(money)+"€ back");
        money = 0;
    }
    
    public void listBottles(){
        int i = 1;
        for(Bottle b : bottle_array){
            System.out.println(i+". Name: "+b.getName());
            System.out.println("\tSize: "+b.getSize()+"\tPrice: "+b.getPrice());
            i++;
        }
    }

    public void bottlestoString(){
        stringBottles = new ArrayList<>();
        int i = 1;
        for(Bottle b : bottle_array){
            stringBottles.add(i + ". " + b.getName() + " " + b.getSize() + "L " + b.getPrice() + "€");
            i++;
        }
    }
    
}

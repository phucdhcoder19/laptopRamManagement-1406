/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Ram implements Serializable {

    private String code;
    private String type;
    private int speed;
    private String brand;
    private int quantity;
    private String production_month_year;
    private boolean active;

    public Ram(String code, String type, int speed, String brand, int quantity, String production_month_year, boolean active) {
        this.code = code;
        this.type = type;
        this.speed = speed;
        this.brand = brand;
        this.quantity = quantity;
        this.production_month_year = production_month_year;
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduction_month_year() {
        return production_month_year;
    }

    public void setProduction_month_year(String production_month_year) {
        this.production_month_year = production_month_year;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getActive() {
        String tmp = String.valueOf(active);
        return tmp;
    }

    @Override
    public String toString() {
        String s = String.format("%s %s %dMHz %s %d %s %b", code, type, speed, brand, quantity, production_month_year, active);
        return s;
    }

    public String showByType() {
        String s = String.format("%s %s %s %d", code, type, production_month_year, quantity);
        return s;
    }

    public String showByBus() {
        String s = String.format("%s %d %s %d", code, speed, production_month_year, quantity);
        return s;
    }

    public String showByBrand() {
        String s = String.format("%s %s %d", brand, production_month_year, quantity);
        return s;
    }

}

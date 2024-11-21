/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import utils.MyToys;

/**
 *
 * @author ADMIN
 */
public class RamManagement {

    ArrayList<Ram> ramList = new ArrayList<>();

    public void readFile(String url) {

        try {
            File file = new File(url);
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            while (1 == 1) {
                try {
                    Object o = ois.readObject();
                    if (o instanceof Ram) {
                        Ram r = (Ram) o;
                        ramList.add(r);
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException cnfe) {
                    System.out.println(cnfe);
                    break;
                }
            }
            is.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFileStream(String url) {
        try {
            File file = new File(url);
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (Ram ram : ramList) {
                oos.writeObject(ram);
            }
            os.close();
            oos.close();
            System.out.println("write to file successfully!!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int searchRamByID(String code) {
        if (ramList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < ramList.size(); i++) {
            if (ramList.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewRam() {
        boolean checkExit;
        do {
            boolean checkID = true;
            String code;

            String type = MyToys.getID("Input type of Ram: ", "That field is required!!!");
            code = "Ram" + type + "_" + generateID();
            int speed = MyToys.getAnInteger("Input speed of Ram: ", "That field is required!!!");
            String brand = MyToys.getID("Input brand of Ram: ", "That field is required!!!");;
            int quantity = MyToys.getAnInteger("Input quantity of Ram: ", "That field is required!!!");;
            String production_month_year = MyToys.getDateFormat("Input production of ram(dd/MM/yyyy): ", "That field is required!!!", "dd/MM/yyyy");
            boolean active = true;
            Ram r = new Ram(code, type, speed, brand, quantity, production_month_year, active);
            ramList.add(r);
            int choice = MyToys.getAnInteger("Do you want to add more Ram 0.No || 1.Yes ", "Invalid!!!", 0, 1);
            checkExit = choice == 1 ? true : false;
            System.out.println("Add successfully!!!");
        } while (checkExit);

    }

    public void print() {
        System.out.println("_____Ram List_____");
        for (Ram ram : ramList) {
            if (ram.getActive().equalsIgnoreCase("true")) {
                System.out.println(ram);
            }
        }
    }

    public void searchByType() {
        ArrayList<Ram> typeList = new ArrayList<>();
        String type = MyToys.getID("Input type u want to search: ", "That field is required!!!");
        char tmp = type.charAt(0);
        for (Ram ram : ramList) {
            if (ram.getType().charAt(0) == tmp) {
                typeList.add(ram);
            }
        }
        System.out.println("____Here is list after searching by type_____");
        if (typeList.isEmpty()) {
            System.out.println("There is no Ram have type " + type);
            return;
        }
        for (Ram t : typeList) {
            System.out.println(t.showByType());
        }

    }

    public void searchByBus() {
        ArrayList<Ram> busList = new ArrayList<>();
        int bus = MyToys.getAnInteger("Input bus u want to search: ", "That field is required!!!");
        for (Ram ram : ramList) {
            if (ram.getSpeed() == bus) {
                busList.add(ram);
            }
        }
        System.out.println("____Here is list after searching by bus speed_____");
        if (busList.isEmpty()) {
            System.out.println("There is no Ram have bus " + bus);
            return;
        }
        for (Ram t : busList) {
            System.out.println(t.showByBus());
        }

    }

    public void searchByBrand() {
        ArrayList<Ram> brandList = new ArrayList<>();
        String brand = MyToys.getID("Input brand u want to search: ", "That field is required!!!");
        char tmp = brand.charAt(0);
        for (Ram ram : ramList) {
            if (ram.getBrand().charAt(0) == tmp) {
                brandList.add(ram);
            }
        }
        System.out.println("____Here is list after searching by brand____");
        if (brandList.isEmpty()) {
            System.out.println("There is no Ram have brand " + brand);
            return;
        }
        for (Ram t : brandList) {
            System.out.println(t.showByBrand());
        }
    }

    public Ram searchByObject(String code) {
        if (ramList.isEmpty()) {
            System.out.println("Have no any product!!!");
            return null;
        }

        for (Ram ram : ramList) {
            if (ram.getCode().equalsIgnoreCase(code)) {
                return ram;
            }
        }
        return null;
    }

    public void updateByCode() {
        boolean checkExit = true;
        do {
            String code = MyToys.getID("Input code of Ram u want to update(format: RAMx_y, where x is the"
                    + "type and y is a numerical order): ", "That field is required!!!", "^RAM[a-zA-Z0-9]+_\\d+$");

            Ram tmp = searchByObject(code);
            if (tmp == null) {
                System.out.println("There is no product have the code " + code);
            } else {
                String type = MyToys.getID("Input type of Ram to update: ", "That field is required!!!");
                tmp.setType(type);
                code = "Ram" + type + "_" + generateID();
                tmp.setCode(code);
                int speed = MyToys.getAnInteger("Input speed of Ram to update: ", "That field is required!!!");
                tmp.setSpeed(speed);
                String brand = MyToys.getID("Input brand of Ram to update: ", "That field is required!!!");
                tmp.setBrand(brand);
                int quantity = MyToys.getAnInteger("Input quantity of Ram to update: ", "That field is required!!!");
                tmp.setQuantity(quantity);
                String production_month_year = MyToys.getDateFormat("Input production of ram(dd/MM/yyyy): ", "That field is required!!!", "dd/MM/yyyy");
                tmp.setProduction_month_year(production_month_year);
                System.out.println("Update successfully!!!");
            }
            int choice = MyToys.getAnInteger("Do you want to update more Ram 0.No || 1.Yes ", "Invalid!!!", 0, 1);
            checkExit = choice == 1 ? true : false;
        } while (checkExit);

    }

    public void deleleRam() {
        boolean checkExit = true;
        do {
            String code = MyToys.getID("Input code of Ram u want to delete(format: RAMx_y, where x is the"
                    + "type and y is a numerical order): ", "That field is required!!!", "^RAM[a-zA-Z0-9]+_\\d+$");
            Ram tmp = searchByObject(code);
            if (tmp == null) {
                System.out.println("There is no product have the code " + code);
            } else {
                tmp.setActive(false);
                System.out.println("Delete successfully!!!");
            }
            int choice = MyToys.getAnInteger("Do you want to delete more Ram 0.No || 1.Yes ", "Invalid!!!", 0, 1);
            checkExit = choice == 1 ? true : false;
        } while (checkExit);

    }

    private String generateID() {
        String ID;
        if (ramList.isEmpty()) {
            ID = "1";
        } else {
            String code = ramList.get(ramList.size() - 1).getCode();
            int max = Integer.parseInt(code.substring(code.length() - 1));
            max++;
            ID = String.valueOf(max);
        }
        return ID;

    }

}

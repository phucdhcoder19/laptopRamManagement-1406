/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptoprammanagement;

import data.RamManagement;
import ui.Menu;
import utils.MyToys;

/**
 *
 * @author ADMIN
 */
public class LaptopRamManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RamManagement rm = new RamManagement();
        String url = "ram.txt";
        rm.readFile(url);

        Menu menu = new Menu("Ram management");
        menu.addNewOption("Add new Ram");
        menu.addNewOption("Search Ram by type, bus and brand");
        menu.addNewOption("Update Ram");
        menu.addNewOption("Delete Ram");
        menu.addNewOption("Display All Active Ram");
        menu.addNewOption("Save to file");
        menu.addNewOption("quit");

        int choice;
        do {
            menu.print();
            rm.print();
            choice = MyToys.getAnInteger("Input your choice (1 - " + menu.getSize() + "): ", "That field is required!!!", 1, menu.getSize());

            switch (choice) {
                case 1:
                    rm.addNewRam();
                    break;
                case 2:
                    Menu menuSearch = new Menu("Searching menu");
                    menuSearch.addNewOption("Search by type");
                    menuSearch.addNewOption("Search by bus");
                    menuSearch.addNewOption("Search by brand");
                    menuSearch.addNewOption("Quit");
                    menuSearch.print();
                    int choiceSeach;
                    do {
                        choice = MyToys.getAnInteger("Input your choice: ", "That field is required!!!", 1, menu.getSize());
                        if (choice == 1) {
                            rm.searchByType();
                        } else if (choice == 2) {
                            rm.searchByBus();
                        } else if (choice == 3) {
                            rm.searchByBrand();
                        }
                    } while (choice != 4);
                    break;
                case 3:
                    rm.updateByCode();
                    break;
                case 4:
                    rm.deleleRam();
                    break;
                case 5:
                    rm.print();
                    break;
                case 6:
                    rm.writeFileStream(url);
                    break;
                default:
                    rm.writeFileStream(url);
                    System.out.println("see you again!!!");
                    break;
            }
        } while (choice != menu.getSize());

    }

}

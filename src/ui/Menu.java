/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import utils.MyToys;

/**
 *
 * @author ADMIN
 */
public class Menu<T> {
    ArrayList<String> optionList = new ArrayList<>();
    public String title;
    public Menu(String title) {
        this.title = title;
    }
    
    public void addNewOption(String newOption){
        optionList.add(newOption);       
    }
    
    public void print(){
        if(optionList.isEmpty()){
            System.out.println("There is nothing, try again!");
            return;
        }
        
        int count = 1;
        System.out.println("__________"+title+"__________");
        for (String string : optionList) {
            System.out.println(count + "." + string);
            count++;
        }
    }
    
    public int getChoice(){
        int choice = MyToys.getAnInteger("Input your choice: ","Your choice must between 1 and" +
                " " + optionList.size(), 1, optionList.size());
        return choice;
    }

    public int getSize() {
       return optionList.size();
    }
    
}

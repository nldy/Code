package com.designpattern.iterator;

public class MenuTestDrive {
    public static void main(String args[]){
        Dinermenu dinermenu=new Dinermenu();

        Waitress waitress=new Waitress(dinermenu);

        waitress.printMenu();
    }
}

package com.designpattern.iterator;

public class Waitress {
    Dinermenu dinermenu;

    public Waitress(Dinermenu dinermenu){
        this.dinermenu=dinermenu;
    }

    public void printMenu(){
        Iterator dinerIterator=dinermenu.createIterator();
        System.out.println("MENU\n----\nLUNCH");
        printMenu(dinerIterator);
    }

    public void printMenu(Iterator iterator){
        while(iterator.hasNext()){
            MenuItem menuItem=(MenuItem)iterator.next();
            System.out.println(menuItem.getName()+",");
            System.out.println(menuItem.getDescription()+",");
            System.out.println(menuItem.getPrice());
        }
    }
}

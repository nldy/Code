package com.designpattern.iterator;

public class Dinermenu {
    static final int MAX_ITEMS=6;
    int numberOfItems=0;
    MenuItem[] menuItems;

    public Dinermenu(){
        menuItems=new MenuItem[MAX_ITEMS];

        addItem("BLT","Bacon",true,2.99);
        addItem("Soup","with patato",false,3.29);
        addItem("hot dog","with onions",false,3.05);
    }

    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem=new MenuItem(name,description,vegetarian,price);
        if(numberOfItems>=MAX_ITEMS)
            System.out.println("menu is full");
        else{
            menuItems[numberOfItems]=menuItem;
            numberOfItems=numberOfItems+1;
        }
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}

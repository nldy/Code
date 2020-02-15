package com.designpattern.model;

public abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();
    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }
    void pourInCup(){
        System.out.println("pouring into cup");
    }

    boolean customerWantsCondiments(){
        return true;
    }
}

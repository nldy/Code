package com.designpattern.strategy;

public abstract class Duck {
    FlyBehavivor flyBehavior;

    public Duck(){
    }
    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }
    public void swim(){
        System.out.println("All ducks float!");
    }
    public void setFlyBehavior(FlyBehavivor fb){
        flyBehavior=fb;
    }
}

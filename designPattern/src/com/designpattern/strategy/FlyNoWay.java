package com.designpattern.strategy;

public class FlyNoWay implements FlyBehavivor{
    public void fly(){
        System.out.println("I can't fly!");
    }
}

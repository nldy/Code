package com.designpattern.strategy;

public class MiniDuckSimulator {
    public static void main(String[] args){
        Duck mallard=new MallardDuck();
        mallard.performFly();
        mallard.display();

        Duck model=new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRockerPowered());
        model.performFly();
    }
}

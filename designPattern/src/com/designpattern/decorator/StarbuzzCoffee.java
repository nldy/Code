package com.designpattern.decorator;

public class StarbuzzCoffee {
    public static void main(String args[]){
        Beverage beverage=new Espresso();
        System.out.println(beverage.getDescription()+" $ "+beverage.cost());

        Beverage beverage1=new HouseBlend();    // 制作出一个HouseBlend对象
        beverage1=new Mocha(beverage1); //用Mocha装饰
        beverage1=new Whip(beverage1);
        System.out.println(beverage1.getDescription()+" $ "+beverage1.cost());
    }
}

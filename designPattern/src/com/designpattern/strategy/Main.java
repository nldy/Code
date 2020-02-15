package com.designpattern.strategy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Duck mallard=new MallardDuck();
        mallard.performFly();
        mallard.display();
        mallard.swim();
    }
}

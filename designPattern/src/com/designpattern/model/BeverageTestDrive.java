package com.designpattern.model;

public class BeverageTestDrive {
    public static void main(String[] args){
        TeaWithHook teaWithHook=new TeaWithHook();

        System.out.println("\nMaking tea...");
        teaWithHook.prepareRecipe();
    }
}

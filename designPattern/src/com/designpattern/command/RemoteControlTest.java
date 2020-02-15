package com.designpattern.command;

public class RemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light();
        SimpleRemoteControl remote = new SimpleRemoteControl();
        LightOnCommand lightOn = new LightOnCommand(light);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
    }
}

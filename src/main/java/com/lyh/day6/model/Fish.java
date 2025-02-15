
package com.lyh.day6.model;

public class Fish extends Animal implements Swimmable {
    private String habitat;

    public Fish(String name, String habitat) {
        super(name);
        this.habitat = habitat;
    }

    @Override
    public void move() {
        System.out.println(name + "摆动鱼鳍游动");
    }

    @Override
    public void swim() {
        System.out.println(name + "在" + habitat + "中快速游动");
    }

    public String getHabitat() {
        return habitat;
    }
}
package com.zhanglongyang;

import java.util.List;

/**
 * Created by longyangzhang on 28/08/2016.
 */
public class FruitBasket {
    private String name;
    private List<String> fruits;

    public FruitBasket(String name, List<String> fruits) {
        this.name = name;
        this.fruits = fruits;
    }

    @Override
    public String toString() {
        return "FruitBasket{" +
                "name='" + name + '\'' +
                ", fruits=" + fruits +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFruits() {
        return fruits;
    }

    public void setFruits(List<String> fruits) {
        this.fruits = fruits;
    }
}

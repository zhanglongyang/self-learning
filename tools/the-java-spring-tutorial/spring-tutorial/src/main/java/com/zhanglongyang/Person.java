package com.zhanglongyang;

public class Person {
    private String name;
    private Integer age;
    private String id;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void onCreate() {
        System.out.println("Creating Person object: " + this);
    }

    public void onDestroy() {
        System.out.println("Destroy Person object");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

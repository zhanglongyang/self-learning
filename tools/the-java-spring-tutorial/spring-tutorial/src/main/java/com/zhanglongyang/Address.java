package com.zhanglongyang;

/**
 * Created by longyangzhang on 28/08/2016.
 */
public class Address {
    private String name;
    private String postCode;

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}

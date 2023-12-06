package org.example.streams;

public class Plant {

    private String name;
    private String blossomColor;
    private boolean isBlooming;
    private int age;

    public Plant(String name, String blossomColor, boolean isBlooming, int age) {
        this.name = name;
        this.blossomColor = blossomColor;
        this.isBlooming = isBlooming;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlossomColor() {
        return blossomColor;
    }

    public void setBlossomColor(String blossomColor) {
        this.blossomColor = blossomColor;
    }

    public boolean isBlooming() {
        return isBlooming;
    }

    public void setBlooming(boolean blooming) {
        isBlooming = blooming;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", blossomColor='" + blossomColor + '\'' +
                ", isBlooming=" + isBlooming +
                ", age=" + age +
                '}';
    }
}

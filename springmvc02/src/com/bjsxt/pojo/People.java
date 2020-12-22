package com.bjsxt.pojo;

/**
 * @author whz
 * @create 2020-02-07 18:44
 * @desc TODO: add description here
 **/
public class People {
    private String name;
    private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override public String toString() {
    return "People{" + "name='" + name + '\'' + ", age=" + age + '}';
  }
}
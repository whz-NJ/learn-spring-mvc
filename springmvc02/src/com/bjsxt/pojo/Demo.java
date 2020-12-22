package com.bjsxt.pojo;

/**
 * @author whz
 * @create 2020-02-07 19:53
 * @desc TODO: add description here
 **/
public class Demo {
  public People getPeo() {
    return peo;
  }

  public void setPeo(People peo) {
    this.peo = peo;
  }

  @Override public String toString() {
    return "Demo{" + "peo=" + peo + '}';
  }

  private People peo;

}
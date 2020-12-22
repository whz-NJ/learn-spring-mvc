package com.bjsxt.pojo;

import java.util.List;

/**
 * @author whz
 * @create 2020-02-07 20:06
 * @desc TODO: add description here
 **/
public class Demo2 {
  public List<People> getPeo() {
    return peo;
  }

  public void setPeo(List<People> peo) {
    this.peo = peo;
  }

  private List<People> peo;

  @Override public String toString() {
    return "Demo2{" + "peo=" + peo + '}';
  }
}
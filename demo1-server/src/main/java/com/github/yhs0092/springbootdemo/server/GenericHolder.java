package com.github.yhs0092.springbootdemo.server;

public class GenericHolder<T> {
  private int num;

  private String str;

  private T data;

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("GenericHolder{");
    sb.append("num=").append(num);
    sb.append(", str='").append(str).append('\'');
    sb.append(", data=").append((T)data);
    sb.append('}');
    return sb.toString();
  }
}

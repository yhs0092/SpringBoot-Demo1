package com.github.yhs0092.springbootdemo.server;

public class Person {
  String name;

  int age;

  Address address;

  public String getName() {
    return name;
  }

  public Person setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public Person setAge(int age) {
    this.age = age;
    return this;
  }

  public Address getAddress() {
    return address;
  }

  public Person setAddress(Address address) {
    this.address = address;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Person{");
    sb.append("name='").append(name).append('\'');
    sb.append(", age=").append(age);
    sb.append(", address=").append(address);
    sb.append('}');
    return sb.toString();
  }
}

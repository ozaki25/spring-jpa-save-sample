package com.example.demo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlayerData {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "username")
  private String name;
  private int age;

  public PlayerData() {
  }

  public PlayerData(Long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "PlayerData{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PlayerData that = (PlayerData) o;
    return age == that.age && Objects.equals(id, that.id) && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age);
  }
}
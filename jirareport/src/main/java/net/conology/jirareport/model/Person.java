package net.conology.jirareport.model;

public class Person {
	
private int id;
private String name;
private int sumOfTotalHours;
private int remainingHours;

public Person() {
	
}
public Person(int id, String name, int sumOfTotalHours, int remainingHours) {
	this.id = id;
	this.name = name;
	this.sumOfTotalHours = sumOfTotalHours;
	this.remainingHours = remainingHours;
			
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSumOfTotalHours() {
	return sumOfTotalHours;
}
public void setSumOfTotalHours(int sumOfTotalHours) {
	this.sumOfTotalHours = sumOfTotalHours;
}
public int getRemainingHours() {
	return remainingHours;
}
public void setRemainingHours(int remainingHours) {
	this.remainingHours = remainingHours;
}

@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", sumOfTotalHours=" + sumOfTotalHours + ", remainingHours=" + remainingHours + "]";
}
}

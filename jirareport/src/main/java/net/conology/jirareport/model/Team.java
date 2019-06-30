package net.conology.jirareport.model;

import java.util.ArrayList;
import java.util.HashMap;

import net.conology.jirareport.interfaces.ITeam;

public class Team implements ITeam {
	
	
	//ArrayList<Person> currentTeam = new ArrayList<Person>();
	HashMap<String, Person> currentTeam = new HashMap<String, Person>();
	
	public void addTeammember(Person person) {
		currentTeam.put(person.getName(), person);
	}
	
	public void updateTeammember(String name, Person person) {
		currentTeam.replace(name, person);
	}
	
	public Person getTeammember(String name) {
		return currentTeam.get(name);
	}
	
	public boolean exisits(String name) {
		if (currentTeam.get(name) == null) return false;
		else return true;
	}
	
	public ArrayList<Person> getTeam() {
		ArrayList<Person> p = new ArrayList<Person>();
		p.addAll(currentTeam.values());
		return p;
	}

}

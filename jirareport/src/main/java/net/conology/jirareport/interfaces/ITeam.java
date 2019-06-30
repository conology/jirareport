package net.conology.jirareport.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import net.conology.jirareport.model.Person;

public interface ITeam {
	
	ArrayList<IPerson> persons = null;
	
	HashMap<String, IPerson> currentTeam = null;
	
	
	public void addTeammember(Person person);
	
	public void updateTeammember(String name, Person person);
	
	public Person getTeammember(String name);
	
	public boolean exisits(String name);
	
	public ArrayList<Person> getTeam();

}

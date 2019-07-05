package net.conology.jirareport.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.conology.jirareport.model.*;
import net.conology.jirareport.model.jira.JiraConnector;
import net.conology.jirareport.model.jira.Sprint;



@Controller
@RequestMapping("/persons")
public class PersonController {

	// load person data
	
	private List<Person> thePersons;
	
	@PostConstruct
	private void loadData() {
	/*// create persons **HARDCODED DATA FOR TESTING**
		Person per1 = new Person(1, "Aleš",89,0);
		Person per2 = new Person(2, "Rok",35,5);
		Person per3 = new Person(3, "Bojan",20,21);

		// create the list
		thePersons = new ArrayList<>();
		
		// add to the list
		thePersons.add(per1);
		thePersons.add(per2);
		thePersons.add(per3);*/			
				// get Jira Connection
				JiraConnector con = new JiraConnector("willm.tueting@conology.net", "m628BRhnEj5wDvDFi9cXDE59",
						"http://conology.atlassian.net");
				// JiraConnector("willm.tueting@conology.net","TestingTesting","http://conology.atlassian.net");
				// JiraConnector("rok.pusnik@conology.onmicrosoft.com","nZvnprWZ234FK4RjIDWk32E6","http://conology.atlassian.net");
	
				
				// transform to sprint
				Sprint currentSprint = con.getSprint();
				
				
				// calculate team efforts
				CalculateTeamWorkload teamWorkload = new CalculateTeamWorkload();
				thePersons = teamWorkload.getTeamWorkload(currentSprint).getTeam();
				
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listPersons(Model theModel) {
		
		// add to the spring model
		theModel.addAttribute("persons", thePersons);
		
		return "display";
	}
}

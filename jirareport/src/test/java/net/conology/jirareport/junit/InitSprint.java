package net.conology.jirareport.junit;

import net.conology.jirareport.model.jira.SimplifiedIssue;
import net.conology.jirareport.model.jira.Sprint;

public class InitSprint {
	
	private Sprint sprint;
	
	public Sprint createSprint() {
		
		SimplifiedIssue issue = new InitSimplifiedIssue().createIssue();
		
		sprint.addIssue(issue);
		sprint.addIssue(issue);
		
		return sprint;
	}
	
	public Sprint getSprint() {
		return sprint;
	}

}

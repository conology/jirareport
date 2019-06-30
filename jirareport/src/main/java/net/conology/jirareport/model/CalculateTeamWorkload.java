package net.conology.jirareport.model;

import java.util.Iterator;

import net.conology.jirareport.interfaces.ITeam;
import net.conology.jirareport.model.jira.SimplifiedIssue;
import net.conology.jirareport.model.jira.Sprint;

public class CalculateTeamWorkload {
	
	ITeam currentTeam = new Team();
	
	public ITeam getTeamWorkload(Sprint currentSprint) {
		
		Iterator<SimplifiedIssue> iterator = currentSprint.getIssues().iterator();
		while(iterator.hasNext()) {
			SimplifiedIssue currentIssue = iterator.next();
			if(currentTeam.exisits(currentIssue.getAssignee()) == true) {
				Person member = currentTeam.getTeammember(currentIssue.getAssignee());
				member.setSumOfTotalHours(member.getSumOfTotalHours()+currentIssue.getTimeSpent());
				member.setRemainingHours(member.getRemainingHours()-currentIssue.getTimeSpent());
				currentTeam.updateTeammember(member.getName(), member);
			}
			else {
				Person member = new Person();
				member.setName(currentIssue.getAssignee());
				member.setRemainingHours((60*40)-currentIssue.getTimeSpent());
				member.setSumOfTotalHours(currentIssue.getTimeSpent());
				currentTeam.addTeammember(member);
			}
			
			//show changes
			Person member = currentTeam.getTeammember(currentIssue.getAssignee());
			//System.out.println(member.getName());
			//System.out.println(member.getRemainingHours());
			//System.out.println(member.getSumOfTotalHours());
			
		}
		
		return currentTeam;		
		
	}

}

package net.conology.jirareport.model.jira;

import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.conology.jirareport.interfaces.ISprint;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Sprint implements ISprint {
	
	
	ArrayList<SimplifiedIssue> issues = new ArrayList<SimplifiedIssue>();
	String teamName;
	Date startDate, endDate;
	
	
	public void addIssue(SimplifiedIssue issue) {
		issues.add(issue);
	}
	
	public ArrayList<SimplifiedIssue> getIssues() {
		return issues;
	}
	
	public void setIssues(ArrayList<SimplifiedIssue> issues) {
		this.issues = issues;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}

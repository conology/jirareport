package net.conology.jirareport.junit;

import com.atlassian.jira.rest.client.api.domain.Issue;

import net.conology.jirareport.model.jira.SimplifiedIssue;

public class InitSimplifiedIssue {
	
	private SimplifiedIssue issue;
	
	public SimplifiedIssue createIssue() {
		
		issue = new SimplifiedIssue();
		
		issue.setAssignee("Willm");
		issue.setTimeSpent(255);
		
		return issue;
	}
	
	public SimplifiedIssue getIssue() {
		return issue;
	}

}

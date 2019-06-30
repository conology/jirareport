package net.conology.jirareport.model.jira;

import net.conology.jirareport.interfaces.IIssue;
import net.conology.jirareport.interfaces.IPerson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SimplifiedIssue implements IIssue {
	private int timeSpent=0;
	int timeEstimate=0;
	String description = "";
	String id = "";  //integer... typically
	String key = ""; //TRA-num
	private String assignee = "";
	int timeLeft=0;
	
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public int getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}	
	
}

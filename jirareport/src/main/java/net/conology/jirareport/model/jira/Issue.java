package net.conology.jirareport.model.jira;

import net.conology.jirareport.interfaces.IIssue;
import net.conology.jirareport.interfaces.IPerson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Issue implements IIssue {
	int timeSpent=0;
	int timeEstimate=0;
	String description = "";
	String id = "";  //integer... typically
	String key = ""; //TRA-num
	IPerson assignee = null;
	int timeLeft=0;	
}

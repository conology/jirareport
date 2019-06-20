package net.conology.jirareport.interfaces;

import net.conology.jirareport.interfaces.IPerson;

public interface IIssue {
	int timeSpent=0;
	int timeEstimate=0;
	String description = "";
	String id = "";  //integer... typically
	String key = ""; //TRA-num
	IPerson assignee = null;
	int timeLeft=0;
	
}

/*
"id":"10142",
"self":"https://conology.atlassian.net/rest/api/3/issue/10142",
"key":"TRA-143",

timetracking.originalEstimate  -> String "1d 5h 15m"
timetracking.remainingEstimate -> String "4h"
timetracking.timeSpent         -> String "1h"
*/

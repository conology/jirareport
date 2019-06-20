package net.conology.jirareport.model.jira;

import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.conology.jirareport.interfaces.ISprint;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Sprint implements ISprint {
	ArrayList<Issue> issues;
	String teamName;
	Date startDate, endDate;
	Issue[] issueList;
}

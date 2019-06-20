package net.conology.jirareport.interfaces;

import java.util.ArrayList;
import java.util.Date;

public interface ISprint {
	ArrayList<IIssue> issues = null;
	String teamName="";
	Date startDate=null;
	Date endDate=null;
}

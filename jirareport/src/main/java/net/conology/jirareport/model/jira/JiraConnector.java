package net.conology.jirareport.model.jira;

import java.net.URI;

import com.atlassian.jira.rest.client.api.AuthenticationHandler;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Issue;

public class JiraConnector {
	
	private String username;
	private String password;
	private String jiraUrl;
	private JiraRestClient restClient;
	
	 public static void main(String[] args) {
		//JiraConnector con = new JiraConnector("willm.tueting@conology.net","TestingTesting","http://conology.atlassian.net");
		 JiraConnector con = new JiraConnector("willm.tueting@conology.net","m628BRhnEj5wDvDFi9cXDE59","http://conology.atlassian.net");
		 //JiraConnector con = new JiraConnector("rok.pusnik@conology.onmicrosoft.com","nZvnprWZ234FK4RjIDWk32E6","http://conology.atlassian.net");
		 //con.getIssuesOfSprint();
		 con.transformToSprint(con.getIssuesOfSprint());
	 }
	
	
	public JiraConnector(String username, String password, String jiraUrl) {
	    this.username = username;
	    this.password = password;
	    this.jiraUrl = jiraUrl;
	    this.restClient = getJiraRestClient();
	}
	
	private JiraRestClient getJiraRestClient() {
	    return new AsynchronousJiraRestClientFactory()
	      .createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
	}
	
/*	private JiraRestClient getJiraRestClient2() {
	   
		AsynchronousJiraRestClientFactory async = new AsynchronousJiraRestClientFactory();
	    AuthenticationHandler handle = new AuthenticationHandler();
		
		return new AsynchronousJiraRestClientFactory()
	      .createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
	}*/
	
	
	
	
	private SearchResult getIssuesOfSprint() {
		//return restClient.getSearchClient().searchJql("Sprint in openSprints() AND Sprint not in futureSprints()").claim();
		return restClient.getSearchClient().searchJql("Status not in (done) AND assignee = rok.pusnik").claim();
	}
	
	private void transformToSprint (SearchResult result) {
		
		Sprint currentSprint = new Sprint();
	
		for (Issue issue: result.getIssues()) {
			SimplifiedIssue currentIssue = new SimplifiedIssue();
			
			if( issue.getTimeTracking() != null ) {
			currentIssue.timeEstimate = issue.getTimeTracking().getOriginalEstimateMinutes();
			currentIssue.timeLeft = issue.getTimeTracking().getRemainingEstimateMinutes();
			currentIssue.timeSpent = issue.getTimeTracking().getTimeSpentMinutes();}
			currentIssue.id = issue.getId().toString();
			currentIssue.key = issue.getKey();
			currentIssue.description = issue.getDescription();
			
			
			currentSprint.addIssue(currentIssue);
		}
	
		
	}
	

	
	private URI getJiraUri() {
	    return URI.create(this.jiraUrl);
	}

}

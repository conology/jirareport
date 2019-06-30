package net.conology.jirareport.model.jira;

import java.net.URI;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import com.atlassian.jira.rest.client.api.domain.Issue;

public class JiraConnector {

	private String username;
	private String password;
	private String jiraUrl;
	private JiraRestClient restClient;
	
	private Sprint currentSprint = new Sprint();


	public JiraConnector(String username, String password, String jiraUrl) {
		this.username = username;
		this.password = password;
		this.jiraUrl = jiraUrl;
		this.restClient = getJiraRestClient();
	}

	private JiraRestClient getJiraRestClient() {
		return new AsynchronousJiraRestClientFactory().createWithBasicHttpAuthentication(getJiraUri(), this.username,
				this.password);
	}


	private SearchResult getIssuesOfSprint() {
		return restClient.getSearchClient().searchJql("Sprint in openSprints() AND Sprint not in futureSprints()").claim();
		//return restClient.getSearchClient().searchJql("Status not in (done) AND assignee = rok.pusnik").claim();
	}

	private Sprint transformSearchResultToSprint(SearchResult result) {

		

		for (Issue issue : result.getIssues()) {
			SimplifiedIssue currentIssue = new SimplifiedIssue();
			//System.out.println("New Issue:");
			
			currentIssue.id = issue.getId().toString();
			//System.out.println(currentIssue.id);
			
			currentIssue.setAssignee(issue.getAssignee().getName());
			//System.out.println(currentIssue.getAssignee());
		
			currentIssue.key = issue.getKey();
			//System.out.println(currentIssue.key);
			
			currentIssue.description = issue.getSummary();
			//System.out.println(currentIssue.description);
			
			issue = restClient.getIssueClient().getIssue(currentIssue.key).claim();
				
			
			if (issue.getTimeTracking() != null) {
				if (issue.getTimeTracking().getOriginalEstimateMinutes() != null) {
					currentIssue.timeEstimate = issue.getTimeTracking().getOriginalEstimateMinutes();
				    //System.out.println(currentIssue.timeEstimate);
				}
				if (issue.getTimeTracking().getRemainingEstimateMinutes() != null) {
					currentIssue.timeLeft = issue.getTimeTracking().getRemainingEstimateMinutes();
					//System.out.println(currentIssue.timeLeft);
				}
				if (issue.getTimeTracking().getTimeSpentMinutes() != null) {
					currentIssue.setTimeSpent(issue.getTimeTracking().getTimeSpentMinutes());
					//System.out.println(currentIssue.getTimeSpent());
				}
				else currentIssue.setTimeSpent(0);
				
			}
			else {
				currentIssue.timeEstimate = 0;
				currentIssue.timeLeft = 0;
				currentIssue.setTimeSpent(0);
			}
			//System.out.println(" ");
			
			currentSprint.addIssue(currentIssue);
		}
		return currentSprint;

	}

	private URI getJiraUri() {
		return URI.create(this.jiraUrl);
	}
	
	public Sprint getSprint() {
		transformSearchResultToSprint(getIssuesOfSprint());
		return currentSprint;
	}
	

}

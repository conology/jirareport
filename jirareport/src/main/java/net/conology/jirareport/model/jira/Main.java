package net.conology.jirareport.model.jira;

import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Main {
    public static void main(String[] args) throws Exception {
    	String email = "rok.pusnik@conology.onmicrosoft.com", token= "nZvnprWZ234FK4RjIDWk32E6";
    	String jqlQueryURL = "https://conology.atlassian.net/rest/api/2/search?jql=Sprint%20in%20openSprints()%20and%20Sprint%20not%20in%20futureSprints()";
    	HttpResponse<JsonNode> response = Unirest.get(jqlQueryURL).basicAuth(email, token).header("Accept","application/json").asJson();
       	System.out.println(response.getBody());
       	//HttpResponse<SearchResult> response=  Unirest.get(jqlQueryURL).basicAuth(email, token).header("Accept","application/json").asObject(SearchResult.class);
    	//sauce for not working example: https://stackoverflow.com/questions/45687588/java-post-request-to-get-token-from-web-service
    	    
       	//SearchResult result = response.getBody();
       	
       	
    	//just reading from existing JSON file
    	ObjectMapper mapper = new ObjectMapper();
    	ReadWebPage page = new ReadWebPage();
    	String content = page.getWebContent(jqlQueryURL);
    	
    	Sprint sprint = mapper.readValue(content, Sprint.class);
    	
    }
}

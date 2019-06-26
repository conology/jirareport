package net.conology.jirareport.model.jira;

import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Main {
    public static void main(String[] args) throws Exception {
    	/*String email = "rok.pusnik@conology.onmicrosoft.com", token= "nZvnprWZ234FK4RjIDWk32E6";
    	//String email = "willm.tueting@conology.net", token= "TestingTesting";
    	//String jqlQueryURL = "https://conology.atlassian.net/rest/api/2/search?jql=Sprint%20in%20openSprints()%20and%20Sprint%20not%20in%20futureSprints()";
    	String jqlQueryURL = "https://conology.atlassian.net/rest/API/2/issue/TRA-55";
    	
    	//Base64.getEncoder().encodeToString((email+token).getBytes());
    	Base64 base64 = new Base64();
    	HttpResponse<JsonNode> response = Unirest.post("https://conology.atlassian.net/rest/API/2/issue/TRA-55").header("Authorization: Basic", new String(base64.encode((email+token).getBytes()))).header("Accept","application/json").asJson();
    	//HttpResponse<JsonNode> response = Unirest.get(jqlQueryURL).basicAuth(email, token).asJson();
    	System.out.println("Key:"+base64.encode((email+token).getBytes()));
    	System.out.println(response.getBody());
       	//HttpResponse<SearchResult> response=  Unirest.get(jqlQueryURL).basicAuth(email, token).header("Accept","application/json").asObject(SearchResult.class);
    	//sauce for not working example: https://stackoverflow.com/questions/45687588/java-post-request-to-get-token-from-web-service
    	    
       	//SearchResult result = response.getBody();
       	
       	
    	//just reading from existing JSON file
    	ObjectMapper mapper = new ObjectMapper();
    	ReadWebPage page = new ReadWebPage();
    	String content = page.getWebContent(jqlQueryURL);
    	
    	Sprint sprint = mapper.readValue(content, Sprint.class);*/
    	String email = "willm.tueting@conology.net", token = "m628BRhnEj5wDvDFi9cXDE59";
    	//String email = "rok.pusnik@conology.onmicrosoft.com", token= "nZvnprWZ234FK4RjIDWk32E6";
    	String jqlQueryURL = "https://conology.atlassian.net/rest/api/2/search?jql=status%20not%20in%20%28done%29%20AND%20assignee%20=%20rok.pusnik";
    	String jqlQueryURL2 = "https://conology.atlassian.net/rest/api/2/search?jql=sprint%20in%20openSprints()%20and%20sprint%20not%20in%20futureSprints()";
    	HttpResponse<JsonNode> response = Unirest.get(jqlQueryURL).basicAuth(email, token).header("Accept","application/json").asJson();
    	//HttpResponse<SearchResult> response=  Unirest.get(jqlQueryURL).basicAuth(email, token).header("Accept","application/json").asObject(SearchResult.class);
    	//SearchResult result = (SearchResult) response.getBody();
    	
    	System.out.println(response.getBody());
       	//status%20not%20in%20done%20AND%20assignee%20=%20rok.pusnik
    	//sauce for not working example: https://stackoverflow.com/questions/45687588/java-post-request-to-get-token-from-web-service
    	
    	//just reading from existing JSON file
    	ObjectMapper mapper = new ObjectMapper();
    	ReadWebPage page = new ReadWebPage();
    	String content = page.getWebContent(jqlQueryURL);
    	
    	SearchResult search = mapper.readValue(content, SearchResult.class);
    	
    	System.out.println(search.getTotal());
    	
    }
}

package net.conology.jirareport.model.jira;


import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class ReadWebPage {

    public String getWebContent(String page) throws IOException {

        HttpGet request = null;

        try {

            String url = page;
            HttpClient client = HttpClientBuilder.create().build();
            request = new HttpGet(url);

            request.addHeader("User-Agent", "Apache HTTPClient");
            HttpResponse response = client.execute(request);

            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
           // System.out.println(content);
           // System.out.println("\n\n\n\n");
            return content;
        } finally {

            if (request != null) {

                request.releaseConnection();
            }
        }
    }
}
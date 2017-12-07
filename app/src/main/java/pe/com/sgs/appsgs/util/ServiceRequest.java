package pe.com.sgs.appsgs.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

public class ServiceRequest {

	HttpPost httppost;
	HttpGet httpget;
	HttpEntity entity;
	HttpResponse response = null;
	HttpClient client = new DefaultHttpClient();
	URI website = null;

	String url;
	List<NameValuePair> params;

	public ServiceRequest(String url, List<NameValuePair> params) {
		this.url = url;
		this.params = params;
	}

	public String MakePostRequest() {

		try {
			website = new URI(url);
			httppost = new HttpPost();
			if (params != null) {
				httppost.setEntity(new UrlEncodedFormEntity(params));
			}
			httppost.setURI(website);
			response = client.execute(httppost);
			entity = response.getEntity();
			return EntityUtils.toString(entity);

		} catch (Exception e) {
			return e.getMessage();
		}

	}
	
	public String MakePostRequest(String json){
        InputStream inputStream = null;
        String result = "";
        try {
        	
        	// 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);
 
            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);
 
            // 6. set httpPost Entity
            httpPost.setEntity(se);
 
            // 7. Set some headers to inform server about the type of the content   
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
 
            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);
 
            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
 
            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
        	return e.getMessage();
        }
 
        // 11. return result
        return result;
    }
	
	private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
 
    }   
	
	public String MakeGetRequest() {
		try {
			if (params != null) {
				String paramString = URLEncodedUtils.format(params, "utf-8");
				url += "?" + paramString;
			}
			website = new URI(url);
			httpget = new HttpGet();
			httpget.setURI(website);
			response = client.execute(httpget);
			entity = response.getEntity();

			return EntityUtils.toString(entity);

		} catch (Exception e) {
			return "some error";
		}
	}

}

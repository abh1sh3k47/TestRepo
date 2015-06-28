package c1.fundamentals;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RequestExecution 
{

	public static void main(String[] args) throws ClientProtocolException, IOException 
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpClientContext context = new HttpClientContext();
		HttpGet httpget = new HttpGet("http://www.google.com/");
		CloseableHttpResponse response = httpclient.execute(httpget,context);
		CookieStore cs = context.getCookieStore();
		for(Cookie c:cs.getCookies())
		{
			System.out.println(c);
		}
		
		try 
		{
			HttpEntity entity = response.getEntity();
			String resp = EntityUtils.toString(entity);
			System.out.println(resp);
		} 
		finally 
		{
			response.close();
		}
	}

}

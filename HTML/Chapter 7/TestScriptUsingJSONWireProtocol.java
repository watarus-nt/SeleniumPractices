package com.packt.webdriver.chapter7;

public class TestScriptUsingJSONWireProtocol {
	
	public static void main(String... args){
		
		HttpClient httpClient = new DefaultHttpClient();
	    HttpResponse response=null;
	    String searchBox = null;
	    String searchButton = null;
	    HttpPost postMethod = null;
	    HttpGet getMethod = null;
	    HttpDelete deleteMethod = null;
	    
		try {			
			// Create a session with RemoteWebDriver 
                // to open Firefox

                postMethod = new HttpPost("http://10.172.10.1:4444/wd/hub/session");
			StringEntity input=null;
			JSONObject jo=new JSONObject();
			jo.put("browserName","firefox");
			JSONObject caps = new JSONObject();
			caps.put("desiredCapabilities", jo);
			System.out.println(caps.toString());
			input = new StringEntity(caps.toString());
			input.setContentEncoding("UTF-8");
			input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			postMethod.setEntity(input);

			//postMethod.set
			response = httpClient.execute(postMethod);
			
			
			//Get Sessions
			httpClient = new DefaultHttpClient();
			getMethod  = new HttpGet("http://10.172.10.1:4444/wd/hub/sessions");
			response = httpClient.execute(getMethod);
			JSONObject json = new JSONObject(response.getEntity().getContent());
			System.out.println(json.toString());
			
			String sessionId = new JSONObject(json.getString("value").substring(1, json.getString("value").length()-1)).getString("id");
			System.out.println("Current SessionId is: "+sessionId);
			
          
                // Navigate to Google Search Page
			httpClient = new DefaultHttpClient();
			postMethod  = new HttpPost("http:// 10.172.10.1:4444/wd/hub/session/"+sessionId+"/url");
			jo=new JSONObject();
			jo.put("url","http://www.google.com");
			input = new StringEntity(jo.toString());
			input.setContentEncoding("UTF-8");
			input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			postMethod.setEntity(input);
			response = httpClient.execute(postMethod);
			
			// Find SearchBox Element
			httpClient = new DefaultHttpClient();
			postMethod = new HttpPost("http:// 10.172.10.1:4444/wd/hub/session/"+sessionId+"/element");
			jo=new JSONObject();
			jo.put("using","name");
			jo.put("value","q");
			input = new StringEntity(jo.toString());
			input.setContentEncoding("UTF-8");
			input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			postMethod.setEntity(input);
			response = httpClient.execute(postMethod);
			json = new JSONObject(response.getEntity().getContent());
			System.out.println(json.toString());
			String searchBoxId = json.getJSONObject("value").getString("ELEMENT");
			System.out.println("SearchBox Id is : "+ searchBoxId);
			
			
			//Click on SearchBox
			httpClient = new DefaultHttpClient();
			postMethod = new HttpPost("http:// 10.172.10.1:4444/wd/hub/session/"+sessionId+"/element/"+searchBoxId+"/click");
			response = httpClient.execute(postMethod);
			
			
			// Type Packt Publishing in SearchBox
			httpClient = new DefaultHttpClient();
			postMethod = new HttpPost("http:// 10.172.10.1:4444/wd/hub/session/"+sessionId+"/element/"+searchBoxId+"/value");
			jo=new JSONObject();
			jo.put("value",Arrays.asList(new String[]{"packt publishing"}));
			input = new StringEntity(jo.toString());
			input.setContentEncoding("UTF-8");
			input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			postMethod.setEntity(input);
			response = httpClient.execute(postMethod);
			
			// End the Session		
           	httpClient = new DefaultHttpClient();
			deleteMethod = new HttpDelete("http:// 10.172.10.1:4444/wd/hub/session/"+sessionId);
			//response = httpClient.execute(deleteMethod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


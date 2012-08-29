package com.remotecontrol.computercontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class HttpController {
	
	private HttpClient httpclient;

	public HttpController(){
		 httpclient = new DefaultHttpClient();
	}
	
	 public void postNewVolume(String volumeValue) {

	        httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost("http://18.212.1.24:8080/hello/volume_control/");
	        
	        try {
	            // Add your data
	            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	            nameValuePairs.add(new BasicNameValuePair("new_volume", volumeValue));
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	            // Execute HTTP Post Request
	            HttpResponse response = httpclient.execute(httppost);
	            Log.d("response", response.getParams().toString());

	        } catch (ClientProtocolException e) {
	        	Log.e("response",e.toString());
	            // TODO Auto-generated catch block
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	        	Log.e("response",e.toString());
	        }
	    } 
}

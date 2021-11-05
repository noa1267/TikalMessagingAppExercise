package com.tikal.MessagingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import com.tikal.MessagingApp.exceptions.ApiError;
import com.tikal.MessagingApp.model.Message;


public class ResultParser {

	public Object getResponseData(String URL, String method, String inputJson) {
		Message msg = null;
		ApiError error = null;
		try {
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);
			conn.setRequestProperty("Accept", "application/json");

			if (method.equals("POST") && inputJson!=null) { //send json data
				try(OutputStream os = conn.getOutputStream()) {
				    byte[] input = inputJson.getBytes("utf-8");
				    os.write(input, 0, input.length);			
				}
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			if ((output = br.readLine()) != null) {
//				Gson g = new Gson();
//				if (conn.getResponseCode()==200) {
//					msg = g.fromJson(output, Message.class);
//					return msg;
//				}else {
//					error = g.fromJson(output, ApiError.class);
//					return error;
//				}
			}
			
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

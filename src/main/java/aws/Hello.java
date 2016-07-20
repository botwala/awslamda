/**
 
 * All HOL
 * Created by Sankara Reddy Telukutla on Jul 19, 2016
 * Copyright © 2015 AllHOL. All rights reserved.
 
 **/

/**
 * 
 */
package aws;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author Neel
 *
 */
public class Hello {
	
	public static void main(String[] args) {
		System.out.println("This is test message !!!");
	}
	
	public String testThis() throws Exception{
		System.out.println("This is test message !!!");
		sendPost();
		return "This is test message";
	}

		private void sendPost() throws Exception {

			String url = "https://hooks.slack.com/services/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";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			//con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			

			String urlParameters = "payload={\"channel\": \"#hackathon\", \"username\": \"moviebot\", \"text\": \"<h3>This is from lambda function scedule every 2 minitues.\", \"icon_emoji\": \":movie_camera:\"}";
			
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());

		}
}

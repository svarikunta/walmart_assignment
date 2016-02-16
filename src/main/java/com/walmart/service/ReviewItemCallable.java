package com.walmart.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.walmart.modal.ReviewItem;
/**
 * In this class we implemented parallel processing using callable and futures.
 * @author sreenivasarao
 *
 */
public class ReviewItemCallable implements Callable<ReviewItem> {
	private String mURL;

	public ReviewItemCallable(String url) {
		mURL = url;
	}

	/**
	 * This method calls the walmart review service to get the review information for each item.
	 * 
	 */
	@Override
	public ReviewItem call() throws Exception {

		ReviewItem reviewItem = null;
		HttpURLConnection connection = null;
		URL siteURL;
		BufferedReader br = null;
		InputStreamReader isr = null;
		try {
			siteURL = new URL(mURL);
			connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
				isr = new InputStreamReader(connection.getInputStream());
				br = new BufferedReader(isr);
				Gson gson = new Gson();
				reviewItem = gson.fromJson(br, ReviewItem.class);
//				System.out.println("reviewItem: " + reviewItem.toString());
			}
			else {
				isr = new InputStreamReader(connection.getErrorStream());
				br = new BufferedReader(isr);
				StringBuilder builder = new StringBuilder();
				String aux = "";
				while ((aux = br.readLine()) != null) {
				    builder.append(aux);
				}
				String error = builder.toString();
				System.out.println("error while calling "+ mURL +" service: " + error);
			}
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException in call method "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException in call method "+e.getMessage());
		} finally {
			if (connection != null)
				connection.disconnect();
			try {
				if (isr != null)
					isr.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("Exception while closing resources in call method" + e.getMessage());
			}
		}
		return reviewItem;

	}

}

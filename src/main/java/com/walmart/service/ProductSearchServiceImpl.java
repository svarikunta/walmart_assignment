package com.walmart.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.walmart.api.API;
import com.walmart.api.NBPAPI;
import com.walmart.api.QueryString;
import com.walmart.api.QueryStringEnum;
import com.walmart.api.SearchAPI;
import com.walmart.modal.Product;
import com.walmart.modal.RecommendedItem;

/**
 * This class implements all the abstract methods in ProductSearchService.java.
 * 
 * @author sreenivasarao
 *
 */
public class ProductSearchServiceImpl implements ProductSearchService {

	/**
	 * This methods takes the search string as input, calls the walmart product
	 * search API and returns the search results.
	 * 
	 * @param searchString
	 *            the product we want to search.
	 * @return returns search result as a product.
	 */
	@Override
	public Product searchProducts(String searchString) {

		API api = buildSearchAPI(searchString);
		
		Product product = null;
		HttpURLConnection connection = null;
		URL siteURL;
		BufferedReader br = null;
		InputStreamReader isr = null;
		try {
			siteURL = new URL(api.getApi());
			connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
				isr = new InputStreamReader(connection.getInputStream());
				br = new BufferedReader(isr);
				Gson gson = new Gson();
				product = gson.fromJson(br, Product.class);
				// System.out.println("reviewItem: " + reviewItem.toString());
			} else {
				isr = new InputStreamReader(connection.getErrorStream());
				br = new BufferedReader(isr);
				StringBuilder builder = new StringBuilder();
				String aux = "";
				while ((aux = br.readLine()) != null) {
					builder.append(aux);
				}
				String error = builder.toString();
				System.out.println("error while calling http://api.walmartlabs.com/v1/search service: " + error);
			}
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException in searchProducts method" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException in searchProducts method" + e.getMessage());
		} finally {
			if (connection != null)
				connection.disconnect();
			try {
				if (isr != null)
					isr.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("Exception while closing resources in searchProducts method" + e.getMessage());
			}
		}
		return product;

	}


	/**
	 * This methods takes the item id as input, calls the walmart recommended
	 * search API and returns recommended items results.
	 * 
	 * @param itemId
	 *            the item id for which we want to get recommended items.
	 * @return returns the the list of recommended items.
	 */
	@Override
	public List<RecommendedItem> getRecommendedProducts(int itemId) {
		API api = buildRecommendedAPI(itemId);
		
		List<RecommendedItem> reItemList = null;
		HttpURLConnection connection = null;
		URL siteURL;
		BufferedReader br = null;
		InputStreamReader isr = null;
		try {
			siteURL = new URL(api.getApi());
			connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
				isr = new InputStreamReader(connection.getInputStream());
				br = new BufferedReader(isr);
				Gson gson = new Gson();
				reItemList = gson.fromJson(br, new TypeToken<List<RecommendedItem>>() {
				}.getType());
				// System.out.println("reviewItem: " + reviewItem.toString());
			} else {
				isr = new InputStreamReader(connection.getErrorStream());
				br = new BufferedReader(isr);
				StringBuilder builder = new StringBuilder();
				String aux = "";
				while ((aux = br.readLine()) != null) {
					builder.append(aux);
				}
				String error = builder.toString();
				System.out.println("error while calling http://api.walmartlabs.com/v1/nbp service: " + error);
			}
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException in getRecommendedProducts method" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException in getRecommendedProducts method" + e.getMessage());
		} finally {
			if (connection != null)
				connection.disconnect();
			try {
				if (isr != null)
					isr.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("Exception while closing resources in getRecommendedProducts method" + e.getMessage());
			}
		}

		return reItemList;
	}


	/**
	 * This method builds recommended API URL as a string;
	 * @param itemId the item is we need insert into URL.
	 * @return
	 */
	private API buildRecommendedAPI(int itemId) {
		QueryString qs = new QueryString("apiKey", QueryStringEnum.API_KEY.getValue());
		qs.add("itemId", String.valueOf(itemId));
		API api = new NBPAPI(qs);
		return api;
	}
	
	
	/**
	 * This method builds product search API URL as a string;
	 * @param searchString  the search string we need to insert into URL.
	 * @return
	 */
	private API buildSearchAPI(String searchString) {
		QueryString qs = new QueryString("format", QueryStringEnum.FORMAT_JSON.getValue());
		qs = new QueryString("format", QueryStringEnum.FORMAT_JSON.getValue());
		qs.add("apiKey", QueryStringEnum.API_KEY.getValue());
		qs.add("query", searchString);
		API api = new SearchAPI(qs);
		return api;
	}


}

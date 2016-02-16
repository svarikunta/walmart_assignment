package com.walmart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.walmart.api.API;
import com.walmart.api.QueryString;
import com.walmart.api.QueryStringEnum;
import com.walmart.api.ReviewAPI;
import com.walmart.modal.ReviewItem;

/**
 * This class implements ReviewService.java interface.
 * @author sreenivasarao
 *
 */
public class ReviewServiceImpl implements ReviewService {
	
	// Walmart API allows only five calls per second.
	//I am creating five parallel threads so that we can call five requests in a one second.
	private static final int NTHREDS = 5;

	/**
	 * This method takes the list on items ids as input and returns list of corresponding review API URLs.
	 * @param intemList list of item ids for which we need review information
	 * @return returns list of review API URLs.
	 */
	private List<String> buildReviewAPIs(List<Integer> intemList) {
		List<String> urlList = new ArrayList<String>();
		
		for (Integer item : intemList) {
			QueryString qs = new QueryString("format", QueryStringEnum.FORMAT_JSON.getValue());
			qs.add("apiKey", QueryStringEnum.API_KEY.getValue());
			API api = new ReviewAPI(item.intValue(), qs);
			urlList.add(api.getApi());
		}
		
		return urlList;
	}

	/**
	 * This method takes the list on items ids as input and returns list of corresponding review items.
	 * @param intemList list of item ids for which we need review information
	 * @return returns list of review items.
	 */
	@Override
	public List<ReviewItem> getReview(List<Integer> intemList) {

		List<String> urls = buildReviewAPIs(intemList);

		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		List<Future<ReviewItem>> list = new ArrayList<Future<ReviewItem>>();
		for (String url : urls) {
			Callable<ReviewItem> worker = new ReviewItemCallable(url);
			Future<ReviewItem> submit = executor.submit(worker);
			list.add(submit);
		}
		List<ReviewItem> itemList = new ArrayList<>();
		// now retrieve the result
		for (Future<ReviewItem> future : list) {
			try {
				ReviewItem item = future.get();
				itemList.add(item);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			} catch (ExecutionException e) {
				System.out.println(e.getMessage());
			}
		}
		
		executor.shutdown();
		return itemList;
	}
}

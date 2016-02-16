package com.walmart.service;

import java.util.List;

import com.walmart.modal.ReviewItem;

public interface  ReviewService {
	
	/**
	 * This method takes the list on items ids as input and returns list of corresponding review items.
	 * @param intemList list of item ids for which we need review information
	 * @return returns list of review items.
	 */
	List<ReviewItem> getReview(List<Integer> intemList);

}

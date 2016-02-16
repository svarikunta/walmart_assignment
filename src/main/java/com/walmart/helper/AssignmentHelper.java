package com.walmart.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.walmart.modal.Item;
import com.walmart.modal.Product;
import com.walmart.modal.RecommendedItem;
import com.walmart.modal.ReviewItem;
import com.walmart.service.ReviewService;
import com.walmart.service.ReviewServiceImpl;

/**
 * This class contains all the helper methods required for Assignment.java
 * 
 * @author sreenivasarao
 *
 */
public class AssignmentHelper {
	
	
	public static Map<Integer,RecommendedItem> map= new HashMap<Integer,RecommendedItem>();

	/**
	 * This method calls Walmart review service to get review for top ten recommended items in the recommendeDItemList
	 * @param recommendeDItemList
	 * @return  returns list of review items.
	 */
	public static List<ReviewItem> getReviewItems(List<RecommendedItem> recommendedItemList) {

		ReviewService reviewService = new ReviewServiceImpl();

		List<ReviewItem> ReviewItemsList = new ArrayList<ReviewItem>();

		if (null != recommendedItemList && recommendedItemList.size() != 0) {

			List<Integer> itemIdsList = new ArrayList<Integer>();

			for (RecommendedItem recommendedItem : recommendedItemList) {

				itemIdsList.add(recommendedItem.getItemId());
				map.put(new Integer(recommendedItem.getItemId()), recommendedItem);
			}

			if (itemIdsList.size() != 0) {
				{
					// Walmart API allows only five calls for second.
					if (itemIdsList.size() >= 10) {
						ReviewItemsList = reviewService.getReview(itemIdsList.subList(0, 5));
						ReviewItemsList.addAll(reviewService.getReview(itemIdsList.subList(5, 10)));
					} else if (itemIdsList.size() < 10 && itemIdsList.size() > 5) {
						ReviewItemsList = reviewService.getReview(itemIdsList.subList(0, 5));
						ReviewItemsList.addAll(reviewService.getReview(itemIdsList.subList(5, itemIdsList.size())));
					}
					if (itemIdsList.size() <= 5) {

						ReviewItemsList.addAll(reviewService.getReview(itemIdsList.subList(0, itemIdsList.size())));
					}

				}

			}

		}

		return ReviewItemsList;
	}

	
	
	/**
	 * This method prints all the review items in the given list. 
	 * @param reviewItemsList
	 */
	public static void printntRecommendedItems(List<ReviewItem> reviewItemsList) {
		int i=1;
		for (ReviewItem reviewItem : reviewItemsList) {
			System.out.print("Rank: "+i+" "+reviewItem.getReviewStatistics().toString());
			System.out.println(map.get(reviewItem.getItemId()).toString());
			i++;
		}
	}

	/**
	 *This method prints all the items list in the product. 
	 * @param product
	 */
	public static void printItems(Product product) {

		System.out.println("\nSearch results:");
		
		if (null != product && product.getItems().size() != 0) {
			for (Item item : product.getItems()) {
				System.out.println(item.toString());
			}
		} else {

			System.out.println("No products found for your search please try with different search string");
		}
	}

}

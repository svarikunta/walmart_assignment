/**
 * 
 */
package com.walmart.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.walmart.modal.ReviewItem;
import com.walmart.service.ProductSearchService;
import com.walmart.service.ProductSearchServiceImpl;
import com.walmart.service.ReviewService;
import com.walmart.service.ReviewServiceImpl;



/**
 * @author sreenivasarao
 *
 */

public class ReviewSearchTest {

	ProductSearchService productSearchService = new ProductSearchServiceImpl();
	ReviewService reviewService = new ReviewServiceImpl();
	
	@Before
	public void initialise() throws InterruptedException {
	    Thread.sleep(1000);
	}

	@Test
	public final void testGetReview() {
		ReviewService reviewService = new ReviewServiceImpl();

		List<Integer> testIds = new ArrayList<>();
		testIds.add(45826138);
		testIds.add(30146246);
		testIds.add(45924440);
		testIds.add(42608125);
		testIds.add(31232984);
	
		List<ReviewItem> reviewItemList = reviewService.getReview(testIds);
		Assert.assertNotNull(reviewItemList);
		Assert.assertEquals(reviewItemList.size(), 5);
		
	
		Assert.assertNotNull(reviewItemList.get(0).getCategoryPath());
		Assert.assertNotNull(reviewItemList.get(0).getName());
		Assert.assertNotNull(reviewItemList.get(0).getItemId());
		Assert.assertNotNull(reviewItemList.get(0).getReviewStatistics());
		
		Assert.assertNotNull(reviewItemList.get(0).getReviewStatistics().getAverageOverallRating());
		Assert.assertNotNull(reviewItemList.get(0).getReviewStatistics().getTotalReviewCount());
		Assert.assertNotNull(reviewItemList.get(0).getReviewStatistics().getOverallRatingRange());
		Assert.assertNotNull(reviewItemList.get(0).getReviewStatistics().getRatingDistributions());

	}
	
	@Test
	public final void testGetReviewNegative() {
		ReviewService reviewService = new ReviewServiceImpl();

		List<Integer> testIds = new ArrayList<>();
		testIds.add(21321321);
		testIds.add(11111111);
		testIds.add(22222222);
		testIds.add(33333333);
		testIds.add(55555555);
	
		List<ReviewItem> reviewItemList = reviewService.getReview(testIds);
		Assert.assertNotNull(reviewItemList);
		Assert.assertEquals(reviewItemList.size(), 5);

		
		Assert.assertNull(reviewItemList.get(0).getCategoryPath());
		Assert.assertNull(reviewItemList.get(0).getName());
		Assert.assertEquals(reviewItemList.get(0).getItemId(),0);
		Assert.assertNull(reviewItemList.get(0).getReviewStatistics());
	
	}

}

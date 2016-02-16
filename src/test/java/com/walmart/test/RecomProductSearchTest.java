/**
 * 
 */
package com.walmart.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.walmart.modal.RecommendedItem;
import com.walmart.service.ProductSearchService;
import com.walmart.service.ProductSearchServiceImpl;
import com.walmart.service.ReviewService;
import com.walmart.service.ReviewServiceImpl;

/**
 * @author sreenivasarao
 *
 */

public class RecomProductSearchTest {

	ProductSearchService productSearchService = new ProductSearchServiceImpl();
	ReviewService reviewService = new ReviewServiceImpl();

	@Before
	public void initialise() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	public final void testGetrecommendedProducts() {
		int itemId = 45826138;

		List<RecommendedItem> recProList = productSearchService.getRecommendedProducts(itemId);
		Assert.assertNotNull(recProList);
		Assert.assertNotNull(recProList.get(0).getBrandName());
		Assert.assertNotNull(recProList.get(0).getCategoryNode());
		Assert.assertNotNull(recProList.get(0).getCategoryPath());
		Assert.assertNotNull(recProList.get(0).getCustomerRatingImage());
		Assert.assertNotNull(recProList.get(0).getLargeImage());
		Assert.assertNotNull(recProList.get(0).getLongDescription());
		Assert.assertNotNull(recProList.get(0).getMediumImage());
		Assert.assertNotNull(recProList.get(0).getModelNumber());
		Assert.assertNotNull(recProList.get(0).getItemId());
		Assert.assertNotNull(recProList.get(0).getName());
		Assert.assertNotNull(recProList.get(0).getProductTrackingUrl());
		Assert.assertNotNull(recProList.get(0).getProductUrl());
		Assert.assertNotNull(recProList.get(0).getShortDescription());
		Assert.assertNotNull(recProList.get(0).getMarketplace());
		Assert.assertNotNull(recProList.get(0).getBundle());
		Assert.assertNotNull(recProList.get(0).getSalePrice());

	}

	@Test
	public final void testGetrecommendedProductsNegative() {
		int itemId = 2132132123;
		List<RecommendedItem> recProList = productSearchService.getRecommendedProducts(itemId);
		Assert.assertEquals(recProList.size(), 0);

	}

}

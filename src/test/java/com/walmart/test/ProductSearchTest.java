/**
 * 
 */
package com.walmart.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.walmart.modal.Product;
import com.walmart.service.ProductSearchService;
import com.walmart.service.ProductSearchServiceImpl;
import com.walmart.service.ReviewService;
import com.walmart.service.ReviewServiceImpl;

/**
 * @author sreenivasarao
 *
 */

public class ProductSearchTest {

	ProductSearchService productSearchService = new ProductSearchServiceImpl();
	ReviewService reviewService = new ReviewServiceImpl();

	@Before
	public void initialise() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	public final void testSearchProduct() {
		Product product = productSearchService.searchProducts("ipod");
		Assert.assertNotNull(product);
		Assert.assertNotNull(product.getItems());
		Assert.assertNotNull(product.getItems().get(0).getName());
		Assert.assertNotNull(product.getItems().get(0).getItemId());
		Assert.assertNotNull(product.getItems().get(0).getShortDescription());
		Assert.assertNotNull(product.getItems().get(0).getLongDescription());
		Assert.assertNotNull(product.getItems().get(0).getCategoryPath());
		Assert.assertNotNull(product.getItems().get(0).getCategoryNode());
		Assert.assertNotNull(product.getItems().get(0).getProductTrackingUrl());
		Assert.assertNotNull(product.getItems().get(0).getProductUrl());
		Assert.assertNotNull(product.getItems().get(0).getParentItemId());
		Assert.assertNotNull(product.getItems().get(0).getThumbnailImage());
		Assert.assertNotNull(product.getItems().get(0).getAvailableOnline());
		Assert.assertNotNull(product.getItems().get(0).getBundle());
		Assert.assertNotNull(product.getItems().get(0).getMarketplace());
		Assert.assertNotNull(product.getItems().get(0).getSalePrice());
		Assert.assertNotNull(product.getItems().get(0).getStandardShipRate());

	}

	@Test
	public final void testSearchProductNegative() {
		Product product = productSearchService.searchProducts("xxyyzz");
		Assert.assertNotNull(product);
		Assert.assertNull(product.getItems());
		Assert.assertEquals(product.getTotalResults(), 0);

	}

}

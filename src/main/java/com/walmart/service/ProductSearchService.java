package com.walmart.service;

import java.util.List;

import com.walmart.modal.Product;
import com.walmart.modal.RecommendedItem;
/**
 * This interface contains abstract methods to search products and recommended products.
 * @author sreenivasarao
 *
 */
public interface  ProductSearchService {
	
/**
 * This methods takes the search string as input, calls the walmart product search API and returns the search results.
 * @param searchString  the product we want to search.
 * @return  returns search result as a product.
 */
public Product searchProducts(String searchString); 

/**
 * This methods takes the item id as input, calls the walmart recommended search API and returns recommended items results.
 * @param itemId   the item id for which we want to get recommended items.
 * @return  returns the the list of recommended items.
 */
public List<RecommendedItem> getRecommendedProducts(int itemId) ;


}

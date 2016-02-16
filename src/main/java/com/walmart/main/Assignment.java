package com.walmart.main;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.walmart.helper.AssignmentHelper;
import com.walmart.helper.ReviewSortByAvgOverallRating;
import com.walmart.modal.Item;
import com.walmart.modal.Product;
import com.walmart.modal.RecommendedItem;
import com.walmart.modal.ReviewItem;
import com.walmart.service.ProductSearchService;
import com.walmart.service.ProductSearchServiceImpl;

/**
 * This class helps to run the application from the command line.
 * 
 * @author sreenivasarao
 *
 */
public class Assignment {

	public static void main(String[] args) {

		ProductSearchService productSearchService = new ProductSearchServiceImpl();
		Scanner sc = new Scanner(System.in);
		String productName = null;
		String x = null;
		do {
			System.out.print("Please enter the name of the product you would like to search \nand press enter: ");
			productName = sc.next();
			Product product = productSearchService.searchProducts(productName);

			AssignmentHelper.printItems(product);

			// Search Recommended products for the first item in the search
			// results.

			Item item = product.getItems().get(0);

			List<RecommendedItem> RecomItemList = productSearchService.getRecommendedProducts(item.getItemId());

			List<ReviewItem> reviewItemList = AssignmentHelper.getReviewItems(RecomItemList);

			Collections.sort(reviewItemList, new ReviewSortByAvgOverallRating());

			System.out.println(
					"\nTop 10 recommended products for the first product based on review seniments (averageOverallRating) \n");
			AssignmentHelper.printntRecommendedItems(reviewItemList);

			System.out.print("Do you want to do another search y/n:");
			x = sc.next();
		} while (x.equals("y"));

		sc.close();

	}

}

package com.walmart.helper;

import java.util.Comparator;
import com.walmart.modal.ReviewItem;

/**
 * This method implements Comparator interface to sort review items in ascending order based on the average overall rating
 * @author sreenivasarao
 *
 */
public class ReviewSortByAvgOverallRating implements Comparator<ReviewItem>{
    /**
     * This method helps to sort ReviewItems bases on average overall rating.
     */
	@Override
	public int compare(ReviewItem reviewItem1, ReviewItem reviewItem2) {
		
	    return (reviewItem1.getReviewStatistics().getAverageOverallRating()> reviewItem2.getReviewStatistics().getAverageOverallRating() ) ? -1: (reviewItem1.getReviewStatistics().getAverageOverallRating() < reviewItem2.getReviewStatistics().getAverageOverallRating() ) ? 1:0 ;
	}

}
package com.walmart.modal;

import java.util.List;

public class ReviewStatistics {

	private Float averageOverallRating;

	private Float overallRatingRange;

	private List<RatingDistributions> ratingDistributions;

	private Long totalReviewCount;

	public Float getAverageOverallRating() {
		return averageOverallRating;
	}

	public void setAverageOverallRating(Float averageOverallRating) {
		this.averageOverallRating = averageOverallRating;
	}

	public Float getOverallRatingRange() {
		return overallRatingRange;
	}

	public void setOverallRatingRange(Float overallRatingRange) {
		this.overallRatingRange = overallRatingRange;
	}

	public List<RatingDistributions> getRatingDistributions() {
		return ratingDistributions;
	}

	public void setRatingDistributions(List<RatingDistributions> ratingDistributions) {
		this.ratingDistributions = ratingDistributions;
	}

	public Long getTotalReviewCount() {
		return totalReviewCount;
	}

	public void setTotalReviewCount(Long totalReviewCount) {
		this.totalReviewCount = totalReviewCount;
	}

	@Override
	public String toString() {
		return "averageOverallRating=" + averageOverallRating /*+ ", overallRatingRange="
				+ overallRatingRange + ", totalReviewCount=" + totalReviewCount*/ ;
	}
}

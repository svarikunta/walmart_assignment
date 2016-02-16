package com.walmart.modal;

import java.util.List;

public class ReviewItem {

	private int itemId;

	private String name;
	
	private String productUrl;

	private String categoryNode;

	private List<Review> reviews;

	private ReviewStatistics reviewStatistics;

	private Boolean availableOnline;

	private Float salePrice;

	private Long upc;

	private String categoryPath;

	private String brandName;

	private String productTrackingUrl;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	public Long getUpc() {
		return upc;
	}

	public void setUpc(Long upc) {
		this.upc = upc;
	}

	public String getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductTrackingUrl() {
		return productTrackingUrl;
	}

	public void setProductTrackingUrl(String productTrackingUrl) {
		this.productTrackingUrl = productTrackingUrl;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getCategoryNode() {
		return categoryNode;
	}

	public void setCategoryNode(String categoryNode) {
		this.categoryNode = categoryNode;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public ReviewStatistics getReviewStatistics() {
		return reviewStatistics;
	}

	public void setReviewStatistics(ReviewStatistics reviewStatistics) {
		this.reviewStatistics = reviewStatistics;
	}

	public Boolean getAvailableOnline() {
		return availableOnline;
	}

	public void setAvailableOnline(Boolean availableOnline) {
		this.availableOnline = availableOnline;
	}
	
	@Override
	public String toString() {
		return "itemId=" + itemId + ", name=" + name + ", salePrice=" + salePrice  + reviewStatistics.toString();
	}

}

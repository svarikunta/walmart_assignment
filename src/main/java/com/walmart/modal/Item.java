package com.walmart.modal;

public class Item {



	int itemId;
	int parentItemId;
	String name;
	float salePrice;
	String categoryPath;
	String shortDescription;
	String longDescription;
	String thumbnailImage;
	String productTrackingUrl;
	float standardShipRate;
	Boolean marketplace;
	String productUrl;
	String categoryNode;
	Boolean bundle;
	Boolean availableOnline;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getParentItemId() {
		return parentItemId;
	}

	public void setParentItemId(int parentItemId) {
		this.parentItemId = parentItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

	public String getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public String getProductTrackingUrl() {
		return productTrackingUrl;
	}

	public void setProductTrackingUrl(String productTrackingUrl) {
		this.productTrackingUrl = productTrackingUrl;
	}

	public float getStandardShipRate() {
		return standardShipRate;
	}

	public void setStandardShipRate(float standardShipRate) {
		this.standardShipRate = standardShipRate;
	}

	public Boolean getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Boolean marketplace) {
		this.marketplace = marketplace;
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

	public Boolean getBundle() {
		return bundle;
	}

	public void setBundle(Boolean bundle) {
		this.bundle = bundle;
	}

	public Boolean getAvailableOnline() {
		return availableOnline;
	}

	public void setAvailableOnline(Boolean availableOnline) {
		this.availableOnline = availableOnline;
	}

	
	@Override
	public String toString() {
		return "itemId=" + itemId + ", name=" + name + ", salePrice=" + salePrice /*+ ", shortDescription="
				+ shortDescription */;
	}
	

}

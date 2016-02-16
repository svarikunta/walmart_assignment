package com.walmart.api;

public class ReviewAPI implements API {
	private QueryString mQueryString;
	private long mItemId;
	public ReviewAPI(long itemId, QueryString qs) {
		mQueryString = qs;
		mItemId = itemId;
	}

	@Override
	public String getApi() {
		 return ApiEnum.REVIEW.getApiCode() + mItemId + "?"+ mQueryString.getQuery();
	}
}

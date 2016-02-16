/**
 * 
 */
package com.walmart.api;

public enum ApiEnum {
	
	REVIEW ("http://api.walmartlabs.com/v1/reviews/"),
	SEARCH ("http://api.walmartlabs.com/v1/search"),
	NBP ("http://api.walmartlabs.com/v1/nbp"),
	COMMON ("http://api.walmartlabs.com/v1/");
	
	private final String mApiCode;
	
	ApiEnum(String apiCode) {
		mApiCode = apiCode;
	}
	
	public String getApiCode() {
		return mApiCode;
	}

}

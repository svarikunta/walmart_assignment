/**
 * 
 */
package com.walmart.api;

public enum QueryStringEnum {
	
	API_KEY ("prctfqsnhqrqtp5qjeruwu35"),
	FORMAT_JSON ("json");
	
	private final String mValue;
	
	QueryStringEnum(String value) {
		mValue = value;
	}
	
	public String getValue() {
		return mValue;
	}

}

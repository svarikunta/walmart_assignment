package com.walmart.api;

public class SearchAPI implements API {
	private QueryString mQueryString;
	public SearchAPI(QueryString qs) {
		mQueryString = qs;
	}

	@Override
	public String getApi() {
		 return ApiEnum.SEARCH.getApiCode() + "?"+ mQueryString.getQuery();
	}

}

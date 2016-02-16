package com.walmart.api;

public class CommonAPI implements API {
	private QueryString mQueryString;
	public CommonAPI(QueryString qs) {
		mQueryString = qs;
	}

	@Override
	public String getApi() {
		 String api = ApiEnum.COMMON.getApiCode() + mQueryString.getQuery();
		 return api;
	}

}

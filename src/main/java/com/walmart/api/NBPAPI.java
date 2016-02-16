package com.walmart.api;

public class NBPAPI implements API {
	private QueryString mQueryString;
	public NBPAPI(QueryString qs) {
		mQueryString = qs;
	}

	@Override
	public String getApi() {
		 return ApiEnum.NBP.getApiCode()+"?"+ mQueryString.getQuery();
	}
}

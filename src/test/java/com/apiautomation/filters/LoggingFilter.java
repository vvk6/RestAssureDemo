package com.apiautomation.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
	private static final Logger logger =LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		LogRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		LogResponse(response);
		// TODO Auto-generated method stub
		return response;
	}
	
	public void LogRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI: "+ requestSpec.getBaseUri());
		logger.info("Headers :  "+ requestSpec.getHeaders());
		logger.info("Body : "+ requestSpec.getBody());
		
	}

	public void LogResponse(Response response ) {
		logger.info("Status Code: "+ response.getStatusCode());
		logger.info("Response Headers :  "+ response.headers());
		logger.info("Response Body : "+ response.getBody().prettyPrint() );
		
	}
}

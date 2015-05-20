package com.twimba.fin.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class YahooQuotesRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		String yahooQueryHost = "query.yahooapis.com";
		String yahooYQLPath = "/v1/public/yql";
		String yahooYQLQuery = "?q={{stocks.yql}}&format=json&diagnostics=false&env=store://datatables.org/alltableswithkeys&callback=";

		from("timer://yahooQuotesApiTimer?fixedRate=true&period=20s")
				.to("http4://" + yahooQueryHost + yahooYQLPath + yahooYQLQuery)
				.to("stream:out")
				.to("log:com.mycompany.order?showAll=true&multiline=true");
	}

}

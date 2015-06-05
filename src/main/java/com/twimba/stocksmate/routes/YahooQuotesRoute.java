package com.twimba.stocksmate.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;
import com.twimba.stocksmate.domain.QuoteEvent;
import com.twimba.stocksmate.xstream.NullableBigDecimalConverter;

@Component
public class YahooQuotesRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		String yahooQueryHost = "query.yahooapis.com";
		String yahooYQLPath = "/v1/public/yql";
		String stocksYQL = "select * from yahoo.finance.quotes where symbol in (\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")";
		String yahooYQLQuery = "?q="+stocksYQL+"&format=xml&diagnostics=false&env=store://datatables.org/alltableswithkeys&callback=";

		XStream xStream = new XStream();
		xStream.alias("quote", QuoteEvent.class);
		xStream.autodetectAnnotations(true);
		xStream.ignoreUnknownElements();
		xStream.registerConverter(new NullableBigDecimalConverter(), XStream.PRIORITY_VERY_HIGH);
		
		from("timer://yahooQuotesApiTimer?fixedRate=true&period=10s")
				.to("http4://" + yahooQueryHost + yahooYQLPath + yahooYQLQuery)
				.split(xpath("/query/results/quote")).streaming()
				.parallelProcessing()
//				.to("stream:out")
				.unmarshal(new XStreamDataFormat(xStream))
				.to("esper://QuoteEvent")
				.to("log:com.mycompany.order?showAll=true&multiline=true");
	}

}

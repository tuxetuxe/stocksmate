package com.twimba.fin.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.twimba.fin.model.YahooQuoteEvent;
import com.twimba.fin.xstream.NullableBigDecimalConverter;

@Component
public class YahooQuotesRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		String yahooQueryHost = "query.yahooapis.com";
		String yahooYQLPath = "/v1/public/yql";
		String yahooYQLQuery = "?q={{stocks.yql}}&format=xml&diagnostics=false&env=store://datatables.org/alltableswithkeys&callback=";

		XStream xStream = new XStream();
		xStream.alias("quote", YahooQuoteEvent.class);
		xStream.autodetectAnnotations(true);
		xStream.ignoreUnknownElements();
		xStream.registerConverter(new NullableBigDecimalConverter(), XStream.PRIORITY_VERY_HIGH);
		
		from("timer://yahooQuotesApiTimer?fixedRate=true&period=10s")
				.to("http4://" + yahooQueryHost + yahooYQLPath + yahooYQLQuery)
				.split(xpath("/query/results/quote")).streaming()
				.parallelProcessing()
//				.to("stream:out")
				.unmarshal(new XStreamDataFormat(xStream))
				.to("esper://YahooQuoteEvent")
				.to("log:com.mycompany.order?showAll=true&multiline=true");
	}

}

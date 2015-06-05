package com.twimba.stocksmate.config;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {

	@Autowired
	private CamelContext camelContext;

	@Bean
	public CamelContextConfiguration contextConfiguration() {
		return new CamelContextConfiguration() {
			@Override
			public void beforeApplicationStart(CamelContext context) {
				context.setAllowUseOriginalMessage(true);
				context.setStreamCaching(true);
			}
		};
	}

}

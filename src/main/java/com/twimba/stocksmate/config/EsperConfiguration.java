package com.twimba.stocksmate.config;

import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

@Configuration
public class EsperConfiguration {

	@Bean
	public com.espertech.esper.client.Configuration getEpServiceProviderConfiguration() {
		com.espertech.esper.client.Configuration config = new com.espertech.esper.client.Configuration();
		config.addEventTypeAutoName("com.twimba.stocksmate.domain");
		config.getEngineDefaults().getExpression()
				.setMathContext(new MathContext(8, RoundingMode.HALF_EVEN));
		return config;
	}

	@Bean
	@Autowired
	public EPServiceProvider getEPServiceProvider(
			com.espertech.esper.client.Configuration configuration) {
		return EPServiceProviderManager.getDefaultProvider(configuration);
	}

	@Bean
	@Autowired
	public EPAdministrator getEPAdministrator(EPServiceProvider serviceProvider) {
		return serviceProvider.getEPAdministrator();
	}

	@Bean
	@Autowired
	public EPRuntime getEPRuntime(EPServiceProvider serviceProvider) {
		return serviceProvider.getEPRuntime();
	}
}

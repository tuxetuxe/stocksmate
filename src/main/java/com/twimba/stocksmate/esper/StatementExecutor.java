package com.twimba.stocksmate.esper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;

@Service
public class StatementExecutor {

	@Autowired
	private EPAdministrator epAdministrator;
	
	@Autowired
	private SystemOutEventListener systemOutEventListener;
	@PostConstruct
	private void executeStatements(){
		
		List<String> statements = new ArrayList<>();
		statements.add("select symbol, avg(ask) from QuoteEvent.win:time(30 sec)");
		statements.add("select evt.symbol, evt.change from pattern [" +
					   "every evt=QuoteEvent(change>1) where timer:within(120 seconds)" +
					   "] group by evt.symbol");
		for(String statementString: statements ){
			EPStatement statement = epAdministrator.createEPL(statementString);
			statement.addListener(systemOutEventListener);
		}
	}
}

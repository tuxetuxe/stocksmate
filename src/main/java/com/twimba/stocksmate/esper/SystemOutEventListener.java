package com.twimba.stocksmate.esper;

import org.springframework.stereotype.Service;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.StatementAwareUpdateListener;

@Service
public class SystemOutEventListener implements StatementAwareUpdateListener {

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents,
			EPStatement statement, EPServiceProvider epServiceProvider) {

		StringBuffer msg = new StringBuffer();
		msg.append("statement: ");
		msg.append(statement.getName());
		msg.append("\n\t");
		msg.append(statement.getText());
		int i = 1;
		for (EventBean event : newEvents) {
			msg.append("\n");
			msg.append("\t event[" + (i++) + "]:");
			msg.append("\t\t ");
			msg.append(event.getUnderlying());
		}
		msg.append("\n");
		System.out.println(msg);

	}

}

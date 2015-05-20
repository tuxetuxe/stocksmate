package com.twimba.fin.xstream;

import org.springframework.util.StringUtils;

import com.thoughtworks.xstream.converters.basic.BigDecimalConverter;

public class NullableBigDecimalConverter extends BigDecimalConverter {

	@Override
	public Object fromString(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		} else {
			return super.fromString(str);
		}
	}
}

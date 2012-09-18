package com.skumar.spring.core.service;

public interface SpringProp {
	String getConfigValue();

	String getOverrideValue();

	void setConfigValue(final String configValue);

	void setOverrideValue(final String overrideValue);
}

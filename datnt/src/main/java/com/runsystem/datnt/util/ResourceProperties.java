package com.runsystem.datnt.util;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceProperties {
	/*
	private static ResourceProperties instance = null;
	private ApplicationContext context = null;
	
	private ResourceProperties() {
		context = new ClassPathXmlApplicationContext("/WEB-INF/dispatcher-servlet.xml");
	}
	
	public static ResourceProperties getInstance() {
		if (instance == null) {
			instance = new ResourceProperties();
		}
		return instance;
	}
	
	public String getValue(String key) {
		return context.getMessage(key, null, Locale.US);
	}*/
}

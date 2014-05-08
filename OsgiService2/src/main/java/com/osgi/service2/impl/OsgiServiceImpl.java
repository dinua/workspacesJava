package com.osgi.service2.impl;

import com.osgi.service2.OsgiService;

public class OsgiServiceImpl implements OsgiService{

	@Override
	public String getText() {
		return "Hello this is second Service";
	}

}

package com.osgi.service1.impl;

import com.osgi.service1.OsgiService;

public class OsgiServiceImpl implements OsgiService {

	@Override
	public String getText() {
		return "Hello this is first Service";
	}

}

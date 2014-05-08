package com.osgi.service.impl;

import com.osgi.service.OsgiService;

public class OsgiServiceImpl implements OsgiService {

	@Override
	public String getText() {
		return "Hello this is first Service";
	}

}

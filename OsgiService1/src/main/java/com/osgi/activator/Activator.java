package com.osgi.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.osgi.service.OsgiService;
import com.osgi.service.impl.OsgiServiceImpl;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(OsgiService.class.getName(), new OsgiServiceImpl(), null);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

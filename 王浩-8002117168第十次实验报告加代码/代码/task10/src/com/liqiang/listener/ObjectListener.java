package com.liqiang.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ObjectListener implements HttpSessionListener{
	
    private static int objectCount = 0;
    
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		objectCount++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		if(objectCount > 0)  objectCount--;
	}

	public static int getObjectCount() {
		return objectCount;
	}

}

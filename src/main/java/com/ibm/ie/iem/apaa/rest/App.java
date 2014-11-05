package com.ibm.ie.iem.apaa.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class App extends Application {
	
	 @Override
     public Set<Class<?>> getClasses()
     {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(Tasks.class);
        return classes;
     }
	 
	
}

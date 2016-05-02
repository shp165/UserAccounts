package com.earthbenign.springmvc.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.earthbenign.springmvc.configuration.CORSFilter;
import com.earthbenign.springmvc.configuration.HelloWorldConfiguration;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	 @Override
	 protected Class<?>[] getRootConfigClasses() {
		 return new Class[] { HelloWorldConfiguration.class };
	 }
	  
	 @Override
	 protected Class<?>[] getServletConfigClasses() {
		 return null;
	 }
	  
	 @Override
	 protected String[] getServletMappings() {
		 return new String[] { "/" };
	 }
	    
	 @Override
	 protected Filter[] getServletFilters() {
		 Filter [] singleton = { new CORSFilter() };
		 return singleton;
	 }
}

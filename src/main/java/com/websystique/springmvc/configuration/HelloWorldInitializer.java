package com.websystique.springmvc.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { HelloWorldConfiguration.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/general/*" };
    }
    
//    @Override
//    protected Filter[] getServletFilters() {
//    	Filter [] singleton = { new CORSFilter()};
//    	return singleton;
//    }
 
}
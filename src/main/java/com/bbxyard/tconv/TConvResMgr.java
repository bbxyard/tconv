/**
 * 
 */
package com.bbxyard.tconv;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.bbxyard.tconv.impl.TCFactoryImpl;

/**
 * @author bbxyard
 *
 */
public final class TConvResMgr {
	public static TConvResMgr getInst() {
		return gcinst;
	}
	
	ITCFactory getFactory() {
		return factory;
	}
	ApplicationContext getApplicationContext() {
		return ctx;
	}
	
	private TConvResMgr() { // spring todo optimiz!!
		PropertyConfigurator.configure("log4j.properties");
		ctx = new AnnotationConfigApplicationContext(TConvReflect.class);
		factory = new TCFactoryImpl(ctx);
	}
	
	private static TConvResMgr 	gcinst = new TConvResMgr();
	private ApplicationContext 	ctx;
	private ITCFactory 			factory;
}

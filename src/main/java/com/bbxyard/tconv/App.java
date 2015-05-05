package com.bbxyard.tconv;

import com.sun.istack.internal.logging.Logger;


/**
 * 
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		// # 1 parse command line options
		TConvOption opt = new TConvOption();
		opt.parseCommandLine(args);
		
		// # TConvResMgr global resource manger
		// # 2.1 get factory
		ITCFactory factory = TConvResMgr.getInst().getFactory();
		
		// # 2.2 ready logger
		Logger log = Logger.getLogger(App.class);
		log.info("App start!!");
		
		// # 2.3 base factory reflection create instance from class name.
		ITConvInput in = factory.createInput(opt.getInputType());
		ITConvOutput out = factory.createOutput(opt.getOutputType());
		ITConvDocument doc = in.parseFile(opt.getInput(), opt);
		out.saveFile(doc, opt.getOutput(), opt);

		// # 2.4 test case finished.
		log.info("App stop!!");
	}
}

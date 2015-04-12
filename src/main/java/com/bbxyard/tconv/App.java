package com.bbxyard.tconv;

import com.sun.istack.internal.logging.Logger;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		TConvOption opt = new TConvOption();
		opt.parseCommandLine(args);
		
		ITCFactory factory = TConvResMgr.getInst().getFactory();
		
		Logger log = Logger.getLogger(App.class);
		log.info("App start!!");
		
		ITConvInput in = factory.createInput(opt.getInputType());
		ITConvOutput out = factory.createOutput(opt.getOutputType());
		ITConvDocument doc = in.parseFile(opt.getInput(), opt);
		out.saveFile(doc, opt.getOutput(), opt);

		log.info("App stop!!");
	}
}

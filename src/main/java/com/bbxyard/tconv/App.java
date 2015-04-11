package com.bbxyard.tconv;

import com.bbxyard.tconv.impl.in.CsvInput;
import com.bbxyard.tconv.impl.out.CsvOutput;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		TConvOption opt = new TConvOption();
		opt.parseCommandLine(args);
		
		CsvInput csvIn = new CsvInput();
		ITConvDocument doc = csvIn.parseFile(opt.getInput(), opt);
		CsvOutput csvOut = new CsvOutput();
		csvOut.saveFile(doc, opt.getOutput(), opt);
		
	}
}

package com.bbxyard.tconv;

import java.util.HashMap;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class TConvOption {
	public TConvOption(String caption, String tabHead, String extparams) {
		// TODO Auto-generated constructor stub
		attrMap = new HashMap<String, String>();
	}
	
	public TConvOption() {
		opt = new Options();
		// input
		opt.addOption("i", "input", true, "input file");
		opt.addOption("t", "input-type", true, "input file type");
		opt.addOption("p", "input-params", true, "input params");
		opt.addOption("f", "input-field-mark", true, "input field split mark");
		// output
		opt.addOption("o", "output", true, "output file");
		opt.addOption("T", "output-type", true, "output file type");
		opt.addOption("P", "output-params", true, "output params");
		opt.addOption("F", "output-field-mark", true, "output field split mark");
		// common
		opt.addOption("C", "table-caption", true, "table cation/title");
		opt.addOption("H", "table-head", true, "table head");
		// help
		opt.addOption("h", "help", false, "Print this usage information");
		opt.addOption("v", "verbose", false, "Print out VERBOSE information");
	}
	
	public void parseCommandLine(String[] args) {
		CommandLineParser parser = new BasicParser();
		try {
			cmdline = parser.parse(opt, args);
			
			if (cmdline.hasOption('h')) {
				showUsage();
				System.exit(0);
			}
			if (cmdline.hasOption('i')) {
				attrMap.put("input", cmdline.getOptionValue('i'));
			}
						
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String query(String attr) {
		String value = attrMap.get(attr);
		return value;
	}
	
	public void showUsage() {
		System.out.println("**************");
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("tconv", opt);
	}
	
	private Options opt;
	private CommandLine cmdline;
	
	private String caption;
	private String tabHead;
	private HashMap<String, String>	attrMap;
}

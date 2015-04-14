package com.bbxyard.tconv;

import java.util.HashMap;
import java.util.Vector;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class TConvOption {
	public TConvOption(String caption, String tabHead, String extparams) {
		attrMap = new HashMap<String, String>();
	}
	
	class OptionNode {
		public OptionNode(String sname, String lname, boolean withArg, String desc, String defValue) {
			this.sname 		= sname;
			this.lname		= lname;
			this.withArg 	= withArg;
			this.desc		= desc;
			this.defValue	= defValue;
		}
		public String	sname;
		public String	lname;
		public boolean	withArg;
		public String	desc;
		public String 	defValue;
	}
	
	class OptionNodeArray extends Vector<OptionNode> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1607717610169488429L;
		
		public void fill(Options opt) {
			for (OptionNode node : this) {
				opt.addOption(node.sname, node.lname, node.withArg, node.desc);
			}
		}
		
		public void visit(CommandLine cmdline, HashMap<String, String> attrMap) {
			for (OptionNode node : this) {
				String value = node.defValue;
				if (cmdline.hasOption(node.sname)) {
					value = cmdline.getOptionValue(node.sname);
				} else if (cmdline.hasOption(node.lname)) {
					value = cmdline.getOptionValue(node.lname);
				}
				attrMap.put(node.sname, value);
				attrMap.put(node.lname, value);
			}			
		}
	}
	
	public TConvOption() {
		attrMap = new HashMap<String, String>();
		ona = new OptionNodeArray();
		// input
		ona.add(new OptionNode("i", "input", true, "input file", ""));
		ona.add(new OptionNode("t", "input-type", true, "input file type", ""));
		ona.add(new OptionNode("p", "input-params", true, "input params", ""));
		ona.add(new OptionNode("f", "input-field-mark", true, "input field split mark", ""));
		ona.add(new OptionNode("c", "input-comment", true, "input comment", "#//"));
		// output
		ona.add(new OptionNode("o", "output", true, "output file", ""));
		ona.add(new OptionNode("T", "output-type", true, "output file type", ""));
		ona.add(new OptionNode("P", "output-params", true, "output params", ""));
		ona.add(new OptionNode("F", "output-field-mark", true, "output field split mark", ""));
		// common
		ona.add(new OptionNode("A", "factory-table", true, "facotry table", "factory.csv"));
		ona.add(new OptionNode("C", "table-caption", true, "table cation/title", ""));
		ona.add(new OptionNode("H", "table-head", true, "table head", ""));
		// help
		ona.add(new OptionNode("h", "help", false, "Print this usage information", ""));
		ona.add(new OptionNode("v", "verbose", false, "Print out VERBOSE information", ""));
		
		opt = new Options();
		ona.fill(opt);
	}
	
	public void parseCommandLine(String[] args) {
		CommandLineParser parser = new BasicParser();
		try {
			cmdline = parser.parse(opt, args);
			
			if (cmdline.hasOption('h')) {
				showUsage();
				System.exit(0);
			}
			
			// 轮询命令行选项
			ona.visit(cmdline, attrMap);
						
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * input options
	 */
	public String getInput() {
		return query("input");
	}
	public String getInputType() {
		return query("input-type");
	}
	public String getInputParams() {
		return query("input-params");
	}
	public String getInputFieldMark() {
		return query("input-field-mark");
	}
	public String getInputComment() {
		return query("input-comment");
	}	
	
	/*
	 * output options
	 */
	public String getOutput() {
		return query("output");
	}
	public String getOutputType() {
		return query("output-type");
	}
	public String getOutputParams() {
		return query("output-params");
	}
	public String getOutputFieldMark() {
		return query("output-field-mark");
	}
	
	/*
	 * common in/out options
	 */
	public String getFactoryTable() {
		return query("factory-table");
	}
	public String getTableCaption() {
		return query("table-caption");
	}
	public String[] getTableHead() {
		String s = query("table-head");
		return s.split(",");
	}
	
	public void showUsage() {
		System.out.println("**************");
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("tconv", opt);
	}
	
	public void update(String attr, String value) {
		attrMap.put(attr, value);
	}
	
	private String query(String attr) {
		String value = attrMap.get(attr);
		return value;
	}
	
	private OptionNodeArray 		ona;
	private Options 				opt;
	private CommandLine 			cmdline;
	private HashMap<String, String>	attrMap;
}

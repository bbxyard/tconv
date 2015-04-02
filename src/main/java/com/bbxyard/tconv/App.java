package com.bbxyard.tconv;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

/**
 * Hello world!
 *
 */
public class App 
{    
	public static void main(String[] args) throws Exception {
		// Create a Parser
		CommandLineParser parser = new BasicParser();
		Options options = new Options();
		options.addOption("h", "help", false, "Print this usage information");
		options.addOption("v", "verbose", false,
				"Print out VERBOSE information");
		options.addOption("f", "file", true, "File to save program output to");
		//System.out.println(options);
		// Parse the program arguments
		CommandLine commandLine = parser.parse(options, args);
		// Set the appropriate variables based on supplied options
		boolean verbose = false;
		String file = "";
		
		HelpFormatter hfmt = new HelpFormatter();

		if (commandLine.hasOption('h')) {
			System.out.println("Help Message");
			hfmt.printHelp("tconv", options);
			System.exit(0);
		}
		if (commandLine.hasOption('v')) {
			verbose = true;
		}
		if (commandLine.hasOption('f')) {
			file = commandLine.getOptionValue('f');
		}
	}
}

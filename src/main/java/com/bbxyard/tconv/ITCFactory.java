package com.bbxyard.tconv;

/**
 * @author bbxyard
 * @interface ITCFactory
 *
 */
public interface ITCFactory {
	/**
	 * @param type "xml, json, csv, excel, ..."
	 * @return
	 */
	ITConvInput  createInput(String type);
	ITConvOutput createOutput(String type);
}

package com.bbxyard.tconv;

public interface ITConvOutput {
	int saveFile(ITConvDocument doc, String file, TConvOption opt);
	int saveContent(ITConvDocument doc, StringBuffer sb, TConvOption opt);
}

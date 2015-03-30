package com.bbxyard.tconv;

public interface ITConvOutput {
	int saveFile(ITConvDocument doc, String file, TConvParam param);
	int saveContent(ITConvDocument doc, StringBuffer sb, TConvParam param);
}

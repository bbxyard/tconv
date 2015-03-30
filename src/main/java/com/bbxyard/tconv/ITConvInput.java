package com.bbxyard.tconv;

public interface ITConvInput {
	ITConvDocument parseFile(String file, TConvParam param);
	ITConvDocument parseContent(String content, TConvParam param);
}

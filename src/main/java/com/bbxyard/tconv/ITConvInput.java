package com.bbxyard.tconv;

public interface ITConvInput {
	ITConvDocument parseFile(String file, TConvOption opt);
	ITConvDocument parseContent(String content, TConvOption opt);
}

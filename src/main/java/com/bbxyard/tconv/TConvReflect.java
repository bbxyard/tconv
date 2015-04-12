package com.bbxyard.tconv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class TConvReflect {
	public TConvReflect() {
		System.out.println("Ref start!!");
	}
}

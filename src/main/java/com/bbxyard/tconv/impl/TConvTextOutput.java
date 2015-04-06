package com.bbxyard.tconv.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.bbxyard.tconv.ITConvDocument;
import com.bbxyard.tconv.ITConvOutput;
import com.bbxyard.tconv.TConvOption;

public class TConvTextOutput implements ITConvOutput {

	public int saveFile(ITConvDocument doc, String file, TConvOption opt) {
		StringBuffer sb = new StringBuffer();
		int ret = saveContent(doc, sb, opt);
		if (0 == ret) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(new File(file));
				byte[] bs = sb.toString().getBytes("utf8");
				fos.write(bs);
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}

	public int saveContent(ITConvDocument doc, StringBuffer sb, TConvOption opt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

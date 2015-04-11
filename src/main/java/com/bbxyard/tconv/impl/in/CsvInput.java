package com.bbxyard.tconv.impl.in;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.bbxyard.tconv.ITConvDocument;
import com.bbxyard.tconv.ITConvDocument.TConvRow;
import com.bbxyard.tconv.ITConvInput;
import com.bbxyard.tconv.TConvOption;
import com.bbxyard.tconv.impl.TConvDocumentImpl;

public class CsvInput implements ITConvInput {

	public ITConvDocument parseFile(String file, TConvOption opt) {
		ITConvDocument doc = new TConvDocumentImpl();
		File f = new File(file);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = null;
			while ( (line = br.readLine()) != null ) {
				addRow(line, opt.getInputFieldMark(), doc);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doc;
	}

	public ITConvDocument parseContent(String content, TConvOption opt) {
		ITConvDocument doc = new TConvDocumentImpl();
		String[] txt = content.split("\n");
		for (String line : txt) {
			addRow(line, opt.getInputFieldMark(), doc);
		}
		return doc;
	}
	
	private static void addRow(String line, String spliter, ITConvDocument doc) {
		TConvRow row = new TConvRow(line.split(spliter));
		doc.addRow(row);	
	}

	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}

package com.bbxyard.tconv.impl;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;

import com.bbxyard.tconv.ITCFactory;
import com.bbxyard.tconv.ITConvDocument;
import com.bbxyard.tconv.ITConvDocument.TConvRow;
import com.bbxyard.tconv.ITConvInput;
import com.bbxyard.tconv.ITConvOutput;
import com.bbxyard.tconv.TConvOption;

public class TCFactoryImpl implements ITCFactory {
	final private class NameNode {
		public NameNode(String name, String inClsName, String outClsName) {
			this.name = name;
			this.inClsName = inClsName;
			this.outClsName = outClsName;
		}
		
		/**
		 * @return the name
		 */
		@SuppressWarnings("unused")
		public String getName() {
			return name;
		}
		/**
		 * @return the inClsName
		 */
		public String getInClsName() {
			return inClsName;
		}
		/**
		 * @return the outClsName
		 */
		public String getOutClsName() {
			return outClsName;
		}
		private String name;
		private String inClsName;
		private String outClsName;
	}
	
	public TCFactoryImpl(ApplicationContext ctx) {
		this.ctx = ctx;
		map = new HashMap<String, NameNode>();
		// Load factory table
		TConvOption opt = new TConvOption();
		opt.parseCommandLine(new String[]{"-f", ":"});
		Class<?> cls;
		try {
			cls = Class.forName("com.bbxyard.tconv.impl.in.CsvInput");
			ITConvInput in = (ITConvInput) ctx.getBean(cls);
			ITConvDocument doc = in.parseFile(opt.getFactoryTable(), opt);
			TConvRow row = null;
			while ( (row = doc.getNextRow()) != null ) {
				String[] items = row.getItems();
				if (items.length < 3)
					continue;
				map.put(items[0], new NameNode(items[0], items[1], items[2]));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ITConvInput createInput(String type) {
		ITConvInput in = null;
		NameNode node = map.get(type);
		if (node != null) {
			String clsname = node.getInClsName();
			Class<?> cls;
			try {
				cls = Class.forName(clsname);
				in = (ITConvInput) ctx.getBean(cls);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}
		return in;
	}

	public ITConvOutput createOutput(String type) {
		ITConvOutput out = null;
		NameNode node = map.get(type);
		if (node != null) {
			String clsname = node.getOutClsName();
			Class<?> cls;
			try {
				cls = Class.forName(clsname);
				out = (ITConvOutput) ctx.getBean(cls);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}
		return out;
	}

	private ApplicationContext ctx;
	private HashMap<String, NameNode> map;
}

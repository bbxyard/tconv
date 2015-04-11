package com.bbxyard.tconv.impl.out;

import com.bbxyard.tconv.ITConvDocument;
import com.bbxyard.tconv.ITConvDocument.TConvRow;
import com.bbxyard.tconv.TConvOption;
import com.bbxyard.tconv.impl.TConvTextOutput;

public class CsvOutput extends TConvTextOutput {

	@Override
	public int saveContent(ITConvDocument doc, StringBuffer sb, TConvOption opt) {		
		TConvRow row;
		while ((row = doc.getNextRow()) != null) {
			String[] items = row.getItems();
			for (String item : items) {
				sb.append(item);
				sb.append(opt.getOutputFieldMark());
			}
			sb.append('\n');
		}
		return 0;
	}

}

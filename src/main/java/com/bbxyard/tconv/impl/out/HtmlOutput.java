package com.bbxyard.tconv.impl.out;

import org.springframework.stereotype.Component;

import com.bbxyard.tconv.ITConvDocument;
import com.bbxyard.tconv.ITConvDocument.TConvRow;
import com.bbxyard.tconv.TConvOption;
import com.bbxyard.tconv.impl.TConvTextOutput;
import com.bbxyard.util.html.HtmlTableWriter;
import com.bbxyard.util.html.HtmlTableWriter.DataIterable;

@Component
public class HtmlOutput extends TConvTextOutput {
	
	class DataIterator implements DataIterable {
		public DataIterator(ITConvDocument doc) {
			this.document = doc;
		}
		public String[] getNext() {
			TConvRow row = document.getNextRow();
			String[] col = (row != null)? row.getItems(): null;
			return col;
		}
		private ITConvDocument document;
	}
	
	public HtmlOutput() {
		System.out.println(this.getClass().getName());
	}

	@Override
	public int saveContent(ITConvDocument doc, StringBuffer sb, TConvOption opt) {
		HtmlTableWriter writer = new HtmlTableWriter();
		writer.write(sb, opt.getTableCaption(), opt.getTableHead(), new DataIterator(doc));
		return 0;
	}

}

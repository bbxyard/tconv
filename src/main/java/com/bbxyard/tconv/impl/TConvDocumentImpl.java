package com.bbxyard.tconv.impl;

import java.util.Vector;

import com.bbxyard.tconv.ITConvDocument;

public class TConvDocumentImpl implements ITConvDocument {
	public TConvDocumentImpl() {
		rows = new Vector<ITConvDocument.TConvRow>();
		pos  = 0;
	}
	
	public TConvRow getNextRow() {
		TConvRow row = null;
		if (pos < rows.size())
		{
			row = rows.get(pos++);
		}
		return row;
	}
	
	public void addRow(TConvRow row) {
		rows.addElement(row);
	}
	
	private Vector<TConvRow>    rows;
	private int					pos;
}

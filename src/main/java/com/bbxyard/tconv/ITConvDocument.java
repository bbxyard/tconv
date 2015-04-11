package com.bbxyard.tconv;

public interface ITConvDocument {
	
	public class TConvRow {
		public TConvRow(String[] items) {
			this.items = items;
		}
		
		public String[] getItems() {
			return items;
		}
		public void setItems(String[] items) {
			this.items = items;
		}
		
		private String[] items;
	}
	
	void 	 addRow(TConvRow row);
	TConvRow getNextRow();
}

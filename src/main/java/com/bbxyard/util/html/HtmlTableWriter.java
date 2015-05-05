package com.bbxyard.util.html;

public class HtmlTableWriter {
	
	public interface DataIterable {
		String[] getNext();
	}
	
	public void write(StringBuffer sb, String caption, String[] heads, String[][] data) {
		// #1 caption + title
		writeHead(sb, caption, heads);		
		// #2 write data
		for (String[] col : data) {
			writeData(sb, col);
		}
		// #3 table end
		writeTail(sb);
	}
	
	public void write(StringBuffer sb, String caption, String[] heads, DataIterable data) {
		// #1 caption + title
		writeHead(sb, caption, heads);		
		// #2 write data
		String[] col = null;
		while ( (col = data.getNext()) != null) {
			writeData(sb, col);
		}
		// #3 table end
		writeTail(sb);	
	}
	
	private void writeHead(StringBuffer sb, String caption, String[] heads) {
		sb.append("<table border=\"1\"><caption>" + caption + "</caption>\n");
		sb.append("<tr>\n");
		for (String s : heads) {
			sb.append("<th>" + s + "</th>\n");
		}
		sb.append("</tr>\n");
	}
	private void writeData(StringBuffer sb, String[] col) {
		sb.append("<tr>\n");
		for (String s : col) {
			sb.append("<td>" + s + "</td>\n");
		}
		sb.append("</tr>\n");
	}
	private void writeTail(StringBuffer sb) {
		sb.append("</table>");
	}

}

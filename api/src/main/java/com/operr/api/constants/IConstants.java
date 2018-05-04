package com.operr.api.constants;

public interface IConstants {
	
	/** 
	  Useful for {@link String} operations, which return an index of <tt>-1</tt> when 
	  an item is not found. 
	 */
	public static final int NOT_FOUND = -1;

	/** System property - <tt>line.separator</tt>*/
	public static final String NEW_LINE = System.getProperty("line.separator");
	/** System property - <tt>file.separator</tt>*/
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	/** System property - <tt>path.separator</tt>*/
	public static final String PATH_SEPARATOR = System.getProperty("path.separator");

	public static final String EMPTY_STRING = "";
	public static final String SPACE = " ";
	public static final String TAB = "\t";
	public static final String SINGLE_QUOTE = "'";
	public static final String PERIOD = ".";
	public static final String DOUBLE_QUOTE = "\"";

	public static final String API_BASE = "/api";
	public static final String API_URL = "http://localhost:8080/"+ API_BASE;
	
	public static final String API_HELLO = API_BASE + "/hello";
	
}
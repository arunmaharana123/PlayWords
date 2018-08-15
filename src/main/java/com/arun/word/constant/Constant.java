package com.arun.word.constant;

public interface Constant {
	public static final int PENDING = 1;
	public static final int INPROGRESS = 2;
	public static final int COMPLETED = 3;
	public static final String[] STATUS = { "", "Pending", "Inprogress", "Completed" };
	public static final String[] USER_ACCESS_URLS = { "/", "/home/*", "/search/*", "/login/*", "/na" };
	public static final String[] ADMIN_ACCESS_URLS = { "/word/*", "/paragraph/*", "/tag/*" };
}

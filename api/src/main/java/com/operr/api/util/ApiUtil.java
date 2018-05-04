package com.operr.api.util;

import javax.servlet.http.HttpServletRequest;

public final class ApiUtil {

	public static String getAppUrl(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}
}

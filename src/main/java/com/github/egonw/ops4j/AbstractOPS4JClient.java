package com.github.egonw.ops4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class AbstractOPS4JClient {

	protected String server;
	protected String appID;
	protected String appKey;

	protected String createRequest(String server, Map<String, String> params) throws UnsupportedEncodingException {
		StringBuffer requestURI = new StringBuffer();
		if (!params.isEmpty()) {
			requestURI.append(server).append('?');
			boolean beyondFirst = false;
			for (String key : params.keySet()) {
				if (beyondFirst) requestURI.append('&');
				requestURI.append(key).append('=').append(URLEncoder.encode(params.get(key), "UTF-8"));
				beyondFirst = true;
			}
		}
		return requestURI.toString();
	}

}

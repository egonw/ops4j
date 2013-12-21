/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * All we ask is that proper credit is given for our work, which includes
 * - but is not limited to - adding the above copyright notice to the beginning
 * of your source code files, and to any copyright notice that you may distribute
 * with programs based on this work.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package com.github.egonw.ops4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Mapping extends AbstractOPS4JClient {

	private Mapping(String server, String appID, String appKey) throws MalformedURLException {
		this.server = server;
		if (!this.server.endsWith("/")) this.server += "/";
		this.server += "mapUri";
		new URL(this.server); // validate the server URL
		System.out.println("Service: " + this.server);
		this.appID = appID;
		this.appKey = appKey;
	}

	public static Mapping getInstance(String server, String apiID, String appKey) throws MalformedURLException {
		return new Mapping(server, apiID, appKey);
	}

	public String mapUri(String uri, Object... objects) throws ClientProtocolException, IOException, HttpException {
		DefaultHttpClient httpclient = new DefaultHttpClient();

		Map<String,String> params = new HashMap<String,String>();
		params.put("app_id", appID);
		params.put("app_key", appKey);
		params.put("_format", "ttl");
		params.put("Uri", uri); 
		String requestUrl = createRequest(server, params);
		HttpGet httppost = new HttpGet(requestUrl);

		HttpResponse response = httpclient.execute(httppost);
		StatusLine statusLine = response.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		if (statusCode != 200) throw new HttpException(statusLine.getReasonPhrase());

		HttpEntity responseEntity = response.getEntity();
		InputStream in = responseEntity.getContent();
		StringWriter writer = new StringWriter();
		IOUtils.copy(in, writer, "UTF-8");
		in.close();
		return writer.toString();
	}

}

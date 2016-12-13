/* Copyright (C) 2015  Egon Willighagen <egonw@users.sf.net>
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

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class AssaysTest extends AbstractOPS4JTest {

	{ super.pickUpConfig(); }

	@Test
	public void info() throws ClientProtocolException, IOException, HttpException {
		Assays client = Assays.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.info("http://openinnovation.lilly.com/bioassay#29");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://openinnovation.lilly.com/bioassay#29"));
	}

	@Test
	public void getClassMembersCount() throws ClientProtocolException, IOException, HttpException {
		Assays client = Assays.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.getClassMembersCount("http://www.bioassayontology.org/bao#BAO_0000219");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("memberCount"));
		Assert.assertFalse(turtle.contains(": 0,"));
	}

	@Test
	public void getClassMembersList() throws ClientProtocolException, IOException, HttpException {
		Assays client = Assays.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.getClassMembersList(
			"http://www.bioassayontology.org/bao#BAO_0000219",
			1, 4
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://www.bioassayontology.org/bao#BAO_0000219"));
	}

}

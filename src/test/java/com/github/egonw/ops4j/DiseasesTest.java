/* Copyright (C) 2014  Egon Willighagen <egonw@users.sf.net>
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


public class DiseasesTest extends AbstractOPS4JTest {

	{ super.pickUpConfig(); }

	@Test
	public void forTargetCount() throws ClientProtocolException, IOException, HttpException {
		Diseases client = Diseases.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forTargetCount("http://purl.uniprot.org/uniprot/Q9Y5Y9");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("diseaseCount"));
		Assert.assertFalse(turtle.contains("\"0\""));
	}

	@Test
	public void forTargetList() throws ClientProtocolException, IOException, HttpException {
		Diseases client = Diseases.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forTargetList(
			"http://purl.uniprot.org/uniprot/Q9Y5Y9",
			1, 4
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("forGene"));
		Assert.assertTrue(turtle.contains("http://linkedlifedata.com/resource/umls"));
	}
}

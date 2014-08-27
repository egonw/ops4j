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

public class PathwaysTest extends AbstractOPS4JTest {

	{ super.pickUpConfig(); }

	@Test
	public void count() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.count();
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
	}

	@Test
	public void list() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.list(1, 5);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("<http://rdf.wikipathways.org/Pathway/WP"));
	}

	@Test
	public void info() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.info("http://identifiers.org/wikipathways/WP1019");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://identifiers.org/wikipathways/WP1019"));
	}

	@Test
	public void getCompounds() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.getCompounds("http://identifiers.org/wikipathways/WP1019");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://identifiers.org/hmdb/HMDB01429"));
	}

	@Test
	public void getTargets() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.getTargets("http://identifiers.org/wikipathways/WP1019");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://identifiers.org/ncbigene/493720"));
	}

	@Test
	public void getPublications() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.getPublications("http://identifiers.org/wikipathways/WP1019");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://identifiers.org/pubmed/10914538"));
	}

	@Test
	public void forCompoundCount() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forCompoundCount("http://www.conceptwiki.org/concept/83931753-9e3f-4e90-b104-e3bcd0b4d833");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("pathway_count"));
		Assert.assertFalse(turtle.contains("\"0\""));
	}

	@Test
	public void forCompoundList() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forCompoundList(
			"http://www.conceptwiki.org/concept/83931753-9e3f-4e90-b104-e3bcd0b4d833",
			1, 5
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://identifiers.org/wikipathways/WP"));
	}

	@Test
	public void forTargetCount() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forTargetCount("http://identifiers.org/ncbigene/282478");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("pathway_count"));
		Assert.assertFalse(turtle.contains("\"0\""));
	}

	@Test
	public void forTargetList() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forTargetList(
			"http://identifiers.org/ncbigene/282478",
			1, 5
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://identifiers.org/wikipathways/WP"));
	}

	@Test
	public void forPublicationCount() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forPublicationCount("http://identifiers.org/pubmed/9789062");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("pathway_count"));
		Assert.assertFalse(turtle.contains("\"0\""));
	}

	@Test
	public void forPublicationList() throws ClientProtocolException, IOException, HttpException {
		Pathways client = Pathways.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forPublicationList(
			"http://identifiers.org/pubmed/9789062",
			1, 5
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://identifiers.org/wikipathways/WP"));
	}
}

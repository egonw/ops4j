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
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class TissuesTest extends AbstractOPS4JTest {

	{ super.pickUpConfig(); }

	@Test
	public void info() throws ClientProtocolException, IOException, HttpException {
		Tissues client = Tissues.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.info("ftp://ftp.nextprot.org/pub/current_release/controlled_vocabularies/caloha.obo#TS-0171");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("ftp://ftp.nextprot.org/pub/current_release/controlled_vocabularies/caloha.obo#TS-0171"));
	}

	@Test
	public void infoBatch() throws ClientProtocolException, IOException, HttpException {
		Tissues client = Tissues.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		List<String> uris = new ArrayList<String>();
		uris.add("ftp://ftp.nextprot.org/pub/current_release/controlled_vocabularies/caloha.obo#TS-0171");
		uris.add("ftp://ftp.nextprot.org/pub/current_release/controlled_vocabularies/caloha.obo#TS-0173");
		String turtle = client.info(uris);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("ftp://ftp.nextprot.org/pub/current_release/controlled_vocabularies/caloha.obo#TS-0171"));
		Assert.assertTrue(turtle.contains("ftp://ftp.nextprot.org/pub/current_release/controlled_vocabularies/caloha.obo#TS-0173"));
	}

	@Test
	public void forProteinCount() throws ClientProtocolException, IOException, HttpException {
		Tissues client = Tissues.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forProteinCount("http://purl.uniprot.org/uniprot/P55795");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("tissueExpressionTotalResults"));
		Assert.assertFalse(turtle.contains(": 0,"));
	}

	@Test
	public void forProteinList() throws ClientProtocolException, IOException, HttpException {
		Tissues client = Tissues.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.forProteinList(
			"http://purl.uniprot.org/uniprot/P55795",
			1, 4
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://www.nextprot.org/db/search#NX_P55795"));
	}

	@Test
	public void getProteinCount() throws ClientProtocolException, IOException, HttpException {
		Tissues client = Tissues.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.getProteinCount("ftp://ftp.nextprot.org/pub/current_release/controlled_vocabularies/caloha.obo#TS-0016");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("tissueExpressionTotalResults"));
		Assert.assertFalse(turtle.contains(": 0,"));
	}

	@Test
	public void getProteinList() throws ClientProtocolException, IOException, HttpException {
		Tissues client = Tissues.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.getProteinList(
			"ftp://ftp.nextprot.org/pub/current_release/controlled_vocabularies/caloha.obo#TS-0016",
			1, 4
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("nextprot.org/"));
	}
}

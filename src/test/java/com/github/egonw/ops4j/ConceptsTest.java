/* Copyright (C) 2013-2017  Egon Willighagen <egonw@users.sf.net>
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
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Currently disabled because ConceptWiki is being replace in 2.2...")
public class ConceptsTest extends AbstractOPS4JTest {

	{ super.pickUpConfig(); }

	@Test
	public void freetext() throws ClientProtocolException, IOException, HttpException {
		Concepts client = Concepts.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.freetext("water");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("water"));
	}

	@Test
	public void byTag() throws ClientProtocolException, IOException, HttpException {
		Concepts client = Concepts.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.freetextByTag("water", ConceptType.CHEMICAL_VIEWED_STRUCTURALLY);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("water"));
	}

	@Test
	public void byTag_Protein() throws ClientProtocolException, IOException, HttpException {
		Concepts client = Concepts.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.freetextByTag("crambin", ConceptType.AMINO_ACID_PEPTIDE_OR_PROTEIN);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("crambin"));
	}

	@Test
	public void description() throws ClientProtocolException, IOException, HttpException {
		Concepts client = Concepts.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.description("8f7f8fe0-f7ad-4192-b57b-e00120d0beee");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("definition"));
	}
}

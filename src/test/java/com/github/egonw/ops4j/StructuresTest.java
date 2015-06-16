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

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class StructuresTest extends AbstractOPS4JTest {

	{ super.pickUpConfig(); }

	@Test
	public void smiles2uri() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.smiles2uri("CC(=O)Oc1ccccc1C(=O)O");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CC(=O)Oc1ccccc1C(=O)O"));
	}

	@Test
	public void inchi2uri() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.inchi2uri("InChI=1S/C9H8O4/c1-6(10)13-8-5-3-2-4-7(8)9(11)12/h2-5H,1H3,(H,11,12)");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("InChI=1S/C9H8O4/c1-6(10)13-8-5-3-2-4-7(8)9(11)12/h2-5H,1H3,(H,11,12)"));
	}

	@Test
	public void inchikey2uri() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.inchikey2uri("BSYNRYMUTXBXSQ-UHFFFAOYSA-N");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("BSYNRYMUTXBXSQ-UHFFFAOYSA-N"));
	}

	@Test
	public void tanimotoSimilarityFrom() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.tanimotoSimilarityFrom("CC(=O)Oc1ccccc1C(=O)O", 0.9f, 0, 5);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CC(=O)Oc1ccccc1C(=O)O"));
	}

	@Test
	public void tanimotoSimilarity() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.tanimotoSimilarity("CC(=O)Oc1ccccc1C(=O)O", 0.9f);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CC(=O)Oc1ccccc1C(=O)O"));
	}

	@Test
	public void similarity() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.similarity("CC(=O)Oc1ccccc1C(=O)O",
			new ParameterValue(new Parameter("searchOptions.Threshold"), "0.9")
			);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CC(=O)Oc1ccccc1C(=O)O"));
	}

	@Test
	public void substructure() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.substructure("CC(=O)Oc1ccccc1C(=O)O", 0, 5);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CC(=O)Oc1ccccc1C(=O)O"));
	}

	@Test
	public void exact() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.exact("CNC(=O)c1cc(ccn1)Oc2ccc(cc2)NC(=O)Nc3ccc(c(c3)C(F)(F)F)Cl");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CNC(=O)c1cc(ccn1)Oc2ccc(cc2)NC(=O)Nc3ccc(c(c3)C(F)(F)F)Cl"));
	}

	@Ignore
	public void allTautomers() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.allTautomers("CNC(=O)c1cc(ccn1)Oc2ccc(cc2)NC(=O)Nc3ccc(c(c3)C(F)(F)F)Cl");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CNC(=O)c1cc(ccn1)Oc2ccc(cc2)NC(=O)Nc3ccc(c(c3)C(F)(F)F)Cl"));
	}

	@Ignore
	public void sameSkeleton() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.sameSkeleton("CNC(=O)c1cc(ccn1)Oc2ccc(cc2)NC(=O)Nc3ccc(c(c3)C(F)(F)F)Cl");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CNC(=O)c1cc(ccn1)Oc2ccc(cc2)NC(=O)Nc3ccc(c(c3)C(F)(F)F)Cl"));
	}

	@Ignore
	public void smarts() throws ClientProtocolException, IOException, HttpException {
		Structures client = Structures.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.smarts("CC(=O)O[R]", 0, 5);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CC(=O)Oc1ccccc1C(=O)O"));
	}
}

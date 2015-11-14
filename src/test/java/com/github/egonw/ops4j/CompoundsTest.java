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
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class CompoundsTest extends AbstractOPS4JTest {

	{ super.pickUpConfig(); }

	@Test
	public void concatenate() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		String result = Compounds.concatenate(list, "|");
		Assert.assertEquals("A|B", result);
	}

	@Test
	public void info() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.info("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5"));
	}

	@Test
	public void infoBatch() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		List<String> uris = new ArrayList<String>();
		uris.add("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5");
		uris.add("http://www.conceptwiki.org/concept/dd758846-1dac-4f0d-a329-06af9a7fa413");
		String turtle = client.info(uris);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5"));
		Assert.assertTrue(turtle.contains("http://www.conceptwiki.org/concept/dd758846-1dac-4f0d-a329-06af9a7fa413"));
	}

	@Test
	public void classifications() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.classifications("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5"));
	}

	@Test
	public void pharmacologyCount() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.pharmacologyCount("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5"));
	}

	@Test
	public void pharmacologyList() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.pharmacologyList(
			"http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5",
			1, 5
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(
			turtle.contains("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5") || // 1.4 API
			turtle.contains("MLDQJTXFUGDVEO-UHFFFAOYSA-N") // should be present always
		);
	}

	@Test
	public void allPharmacology() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.allPharmacology(
			"http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5"
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(
			turtle.contains("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5") || // 1.4 API
			turtle.contains("MLDQJTXFUGDVEO-UHFFFAOYSA-N") // should be present always
		);
	}

	@Test
	public void compoundByClassCount() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.compoundByClassCount("http://purl.obolibrary.org/obo/CHEBI_24431");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://purl.obolibrary.org/obo/CHEBI_24431"));
	}

	@Test
	public void compoundByClassList() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.compoundByClassList(
			"http://purl.obolibrary.org/obo/CHEBI_24431",
			1, 5
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("CHEBI_24431"));
	}

	@Test
	public void classPharmacologyCount() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.classPharmacologyCount("http://purl.obolibrary.org/obo/CHEBI_100");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://purl.obolibrary.org/obo/CHEBI_100"));
		Assert.assertTrue(turtle.contains("compoundPharmacologyTotalResults"));
		Assert.assertFalse(turtle.contains("\"0\""));
	}

	@Test
	public void classPharmacologyList() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.classPharmacologyList(
			"http://purl.obolibrary.org/obo/CHEBI_100",
			1, 5
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("hasMolecule"));
	}

	@Test
	public void targetClassificationsFor() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.targetClassificationsFor("http://ops.rsc.org/OPS6958");
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://rdf.ebi.ac.uk/resource/chembl/protclass/CHEMBL_PC_156"));
	}

	@Test
	public void chemblClassificationsFor() throws ClientProtocolException, IOException, HttpException {
		Compounds client = Compounds.getInstance(super.server, super.appID, super.appKey);
		Assert.assertNotNull(client);
		String turtle = client.targetClassificationsFor(
			"http://ops.rsc.org/OPS6958",
			new ParameterValue(Compounds.TREE, "chembl")
		);
		Assert.assertNotNull(turtle);
		Assert.assertTrue(turtle.contains("prefix"));
		Assert.assertTrue(turtle.contains("http://rdf.ebi.ac.uk/resource/chembl/protclass/CHEMBL_PC_156"));
	}
}

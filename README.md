A Java client for Open PHACTS
=============================

This Java client is an incomplete client to the Open PHACTS 1.4 API.
The goal is a small client with few dependencies and no Scala in
particular. Dependencies are JUnit and Apache's HttpClient and Commons IO.

* License: LGPL v2.1 or later
* Authors: Egon Willighagen

Compiling and Testing
=====================

To compile and test this client, you need an Open PHACTS account and API key
which you can get at http://dev.openphacts.org/.

Compile and test with:

    mvn -Dserver=... -DappID=... -DappKey=... clean test install

The current beta test server can be tested against using:

    -Dserver=https://beta.openphacts.org/1.4/
    
The documentation for this Open PHACTS API server can be found at
https://dev.openphacts.org/docs/1.4

Example
=======

    Mapping client = Mapping.getInstance(server, appID, appKey);
	String turtle = client.mapUri("http://identifiers.org/ensembl/ENSG00000100030");

Methods return a String with the content in Turtle format. If you want another format,
use the ResponseFormat class:

    Mapping client = Mapping.getInstance(server, appID, appKey);
	String json = client.mapUri(
	  "http://identifiers.org/ensembl/ENSG00000100030",
	  ResponseFormat.JSON
	);

Other formats include HTML, RDF, RDFJSON, and TSV.

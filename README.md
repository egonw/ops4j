A Java client for Open PHACTS
=============================

This Java client is an incomplete client to the Open PHACTS 1.3 API.
The goal is a small client with few dependencies and no Scala in
particular. Dependencies are JUnit and Apache's HttpClient and Commons IO.

* License: LGPL v2.1 or later
* Authors: Egon Willighagen

Compiling and Testing
=====================

To compile and test this client, you need an Open PHACTS account and API key
which you can get at http://dev.openphacts.org/.

Compile and test with:

    mvn -Dserver=... -DapiID=... -DappKey=... clean test install


Example
=======

    Mapping client = Mapping.getInstance(server, appID, appKey);
	String turtle = client.mapUri("http://identifiers.org/ensembl/ENSG00000100030");

Methods return a String with the content in Turtle format.


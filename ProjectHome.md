CurrentCost (http://www.currentcost.com) monitors allow you to monitor your home electricity usage.

You can connect a serial cable to them to get the data out of them in an XML format.

This project contains Perl, Python, C# and Java code that will parse the data for you.


---

Note that data comes out of CurrentCost meters in the form of a relative description of your electricity usage.

E.g. you used this much electricity 2 hours ago

The code stored here not only reads the data from the meter, but also parses it and converts it into an absolute description of your electricity usage.

E.g. you used this much electricity at 1pm on 12th July

---

**Notes:**
  * The Python code now supports both the Classic and the CC128 CurrentCost monitors
  * The C# sample supports the CC128 CurrentCost monitors

---


The latest version of the code is all available using SVN from http://code.google.com/p/currentcost/source/browse/#svn/trunk


---

Note: The Perl CurrentCost code is different to the code provided for other languages. Unlike the Java, Python and C#, it does not parse the history data. Instead, it is intended to read the CurrentCost data and publish some of it to a messaging system on the Internet so it can be graphed and viewed. The messaging system is the IBM MQ Telemetry Transport, useful, for example, for projects using [Really Small Message Broker](http://www.alphaworks.ibm.com/tech/rsmb) for home automation.

---

A related project http://code.google.com/p/currentcostgui/ also draws graphs using the parsed CurrentCost data
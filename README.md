# About
This is an extension used to assist in the upgrade from 6.1 to 6.2 enterprise edition.  The extension extends the following files.
1. portal-ext.properties
2. VerifyProcessSuite.java
3. UpgradeProcess_6_2_0.java
4. UpgradeProcess

This extension serves two purposes.  Firstly, it adds custom logging to the upgrade process by printing a line to the log file before and after each
component is upgrade.  Additionally, it removes the verify process for the document library.  During our upgrade from Liferay 6.1 EE to Liferay 6.2 EE
we ran into an issue VerifyDocumentLibrary(). A query was executed during this process that ran for weeks without ending. After repeated attempts to utilize 
our Liferay platinum partners and our gold support through Liferay we were provided with no solution to our issue.  We have a 4 terabyte document library
that is based off the default system library backend.

# Deploying
First open your portals override properties file.  It can be any one of the following files.
1. include-and-override=portal-bundle.properties
2. include-and-override=${liferay.home}/portal-bundle.properties
3. include-and-override=portal-ext.properties
4. include-and-override=${liferay.home}/portal-ext.properties
5. include-and-override=portal-setup-wizard.properties
6. include-and-override=${liferay.home}/portal-setup-wizard.properties

Add the following line.

    verify.frequency = -1

Run the Ant target "all".  A war file will be created in your plugin sdk's dist folder.  Deploy that war file on your
Java application server or container and start the server.  Once the server has fully ran verify that the extension deployed successfully
in the log file.  Shut down the server and remove the verify.frequency property.  The next time you start your server for the upgrade the
extension will execute

# Files
### portal-ext.properties
This file points the following two properties to our CustomUpgradeProcess_6_2_0.java and CustomVerifyProcessSuite.java files respectively.

    upgrade.processes.master
    verify.processes
    
### VerifyProcessSuite
We extend VerifyProcessSuite with CustomVerifyProcessSuite.  This file removes the verification of the document library by commenting out
the following line.

### UpgradeProcess_6_2_0
We extend UpgradeProcess_6_2_0 with CustomUpgradeProcess_6_2_0.  In our custom file we add additional logging

    verify(new VerifyDocumentLibrary());
    
### UpgradeProcess
We extend UpgradeProcess with CustomUpgradeDocumentLibrary.  Additionally logging is added

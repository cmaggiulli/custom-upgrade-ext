## Background
This is a Liferay Extension used to bypass an uncaught exception during Liferay's Document Library Verification Step in the 6.1 to 6.2 EE Upgrade path.  This issue affected most Liferay 6.1 EE customers who were using Liferay's Simple File Storage System for their DocLib implementation.  If you are overriding `dl.store.impl` to use any other implementation than you are likely unaffected.

There are two changes introduced by this Extension:
- Firstly the extension outright bypasses the Document Library Post-upgrade verification step.  It does *not* bypass the Document Library upgrade.  It only bypasses the subsequent verification process
- It adds enhanced logging to the Document Library upgrade process in an effort to identify a root cause for the subsequent verification failures

The extension extends the following files:
- portal-ext.properties
- VerifyProcessSuite.java
- UpgradeProcess_6_2_0.java
- UpgradeProcess

Most noteably it removes the invocation of the `VerifyDocumentLibrary()` method by introducing a CustomVerifyProcessSuite class with a specially crafted fully qualified class name that overrides the VerifyProcessSuite class through a Liferay convention-over-configuration Extension pattern.  This pattern is loosely described [here](https://help.liferay.com/hc/en-us/articles/360018181211-Advanced-Customization-with-Ext-Plugins).

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

## Overview of Changes
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

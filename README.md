ChatterAntTask
==============

Description: Ant task for sending Chatter updates to a group

The following are dependencies to running the ChatterAntTask via your ANT builds:

1.  Make sure you have ANT set up.  This task was tested with ANT 1.9.2, but should work on earlier versions. (https://ant.apache.org/).  Optionally, you may install ANT on Mac OSX using Homebrew with brew install ant.

2.  ChatterAntTask utilizes the forcedotcom labs JavaChatterRESTapi (https://github.com/forcedotcom/JavaChatterRESTApi) and all of its dependencies.  The JavaChatterRESTApi jar file and its dependent jars may be found in the lib directory. Add each of these jar files to your ANT lib directory prior to running the ChatterAntTask.

3.  In your build.xml file for your ANT build, define the Chatter Task similar to below:

    <taskdef name="chatter" classname="com.salesforce.chatter.ant.ChatterTask" />

4.  The ChatterAntTask uses the "Username and Password" oauth authentication build into the JavaChatterRESTApi.  This means the chatter ant task needs to pass in a username, password, client key, and client secret in addition to the instanceUrl (e.g. https://na10.salesforce.com), groupId or Salesforce Id of the Chatter group to post to, and the message to display. 

5.  An example of calling the ChatterAntTask is below:

    ```
    <target name="chattermemaybe">
        <echo>User: ${sfsource.username}</echo>
        <echo>Uri: ${sfsource.serverUri}</echo>
        <echo>Clientkey: ${sfsource.clientKey}</echo>
        <echo>ClientSecret: ${sfsource.clientSecret}</echo>
        <echo>Deploy Root: ${source.dir}</echo>
        <echo>groupId: ${sfsource.chatterGroupId}</echo>
        <chatter username="${sfsource.username}" password="${sfsource.password}" clientKey="${sfsource.clientKey}" clientSecret="${sfsource.clientSecret}" instanceUrl="${sfsource.serverUri}" groupId="${sfsource.chatterGroupId}" message="Build completed!" />
    </target>
    ```


Macro_Empires
=============
Build instructions:
Install Git (I'm on version 1.9.4, turn on "Use Git from the Windows Command Prompt", commit Unix-style line endings)
git config --global user.email "your@email"
git config --global user.name "your name"
Install JDK (I'm on version 1.8.0_05)
Install Maven (I'm on version 3.2.2)
Configure environment variables as specified in Maven install instructions
download angularjs (I'm on version 1.2.18, just save the file somewhere)
Install IntelliJ (I'm on version 13.1.3, I do not have a precise list of which packages/plugins are required)

In IntelliJ
Configure plugins, click Install JetBrains plugin, select and install AngularJS plugin
Configure Project Defaults, Project Structure, Platform Settings, SDKs, click green plus button to add new SDK and pick JDK for the type, select JDK install folder
Configure Project Defaults, Project Structure, Global Libraries, click green plus button to add new library and pick JavaScript for the type, select angular.js file, leave library named angular
New project, Check out from Version Control, Checkout from GitHub, Vcs Repository URL is https://github.com/dougmill/Macro_Empires.git
Open the Maven Projects tab and Reimport until dependencies are resolved and there are no errors, in Maven or in Main.java (this will require prompted reload(s))
Open Main.java and run it.
visit http://localhost:8080/ to see main page
visit http://localhost:8080/myapp/myresource to see demo api call return value

If you want to use the database SQL console:
Open Database tab
Right-click on H2 - Macro Empires
Select Data Source Properties
See the "Driver files missing" notice at the bottom and click the link to download.

If you want to use the Hibernate console:
Build the project to resolve any class mappings.
Edit the "hibernate.connection.url" property in hibernate.cfg.xml.
Reloading the project may be required.
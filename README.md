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
Create account on github.com.
Create account on gerrithub.io and link it to github.
On gerrithub, go to your settings and generate an http password.

In IntelliJ
Configure plugins, click Install JetBrains plugin, select and install AngularJS plugin
Configure plugins, click Browse repositories, select and install Gerrit
Configure Project Defaults, Project Structure, Platform Settings, SDKs, click green plus button to add new SDK and pick JDK for the type, select JDK install folder
Configure Project Defaults, Project Structure, Global Libraries, click green plus button to add new library and pick JavaScript for the type, select angular.js file, leave library named angular
Check out project from Version Control, Checkout from Gerrit, Vcs Repository URL is https://review.gerrithub.io/dougmill/Macro_Empires
Open the project, and on the green maven popup click to import changes.
Open Main.java and run it.
visit http://localhost:8080/ to see main page
visit http://localhost:8080/api/starsystems to see demo api call return value

If you want to use the database SQL console:
Open Database tab
Right-click on H2 - Macro Empires
Select Data Source Properties
See the "Driver files missing" notice at the bottom and click the link to download.

If you want to use the Hibernate console:
Build the project to resolve any class mappings.
Edit the "hibernate.connection.url" property in hibernate.cfg.xml.
Reloading the project may be required.
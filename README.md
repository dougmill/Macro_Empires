Macro_Empires
=============
Build instructions:
Install Git (I'm on version 1.9.4, not sure if "Use Git from the Windows Command Prompt" option is needed)
Install JDK (version 1.8.0_05)
Install Maven (version 3.3.2)
Configure environment variables as specified in Maven install instructions
Install IntelliJ (version 13.1.3)

In IntelliJ
Configure plugins, click Install JetBrains plugin, select and install AngularJS plugin
Configure Project Defaults, Project Structure, Platform Settings, SDKs, click green plus button to add new SDK and pick JDK for the type, select JDK install folder

New project, Check out from Version Control, Checkout from GitHub, Vcs Repository URL is https://github.com/dougmill/Macro_Empires.git
Open the Maven Projects tab and Reimport until dependencies are resolved and Main.java has no errors
Build and run

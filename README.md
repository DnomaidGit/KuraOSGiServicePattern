***
# KuraHelloOsgiConfig
This is a simple example of an OSGI project for Eclipse Kura.
***
## Development Environment
* Eclipse Neon Version: 2019-09 R (4.13.0). An additional plugin, mToolkit, is needed to allow remote connectivity to an OSGi framework on a Kura-enabled target device. To install mToolkit into Eclipse, use the following steps: 
  + Open the Help | Install New Software… menu.
  + Add the following URL as an update site based on your version of Eclipse http://mtoolkit-neon.s3-website-us-east-1.amazonaws.com
  + Install the “mToolkit” feature (you need to uncheck the Group items by category checkbox in order to see the feature).
  + Restart Eclipse. In the menu Window | Show View | Other, there should be an mToolkit | Frameworks option. If so, the plugin has been installed correctly.
* Development platform Linux (Debian 10).
***
## System Requirements
* Eclipse Kura 4.1.0 is compatible with Java 8 and [OSGi R6](https://docs.osgi.org/specification/).
***
## Build sources
The only requisite to build from sources is an already  
installed [Eclipse Kura User Workspace](https://www.eclipse.org/kura/downloads.php).  
***  
## Tested
* Raspberry pi 3 and 4.
* Eclipse Kura 4.1.0.
***
## Binary package
The binary package ready for the installation can be
found in folder "**resources/dp**".
***
## How to create a OSGi project
***
1. Create Plug-in Project.
2. Add Dependencies to Manifest.
3. Create Java Class.
4. Create Component Class.
5. Create the Default Configuration.
6. Resolve Dependecies.
7. Import Package.
8. Build Configuration to Manifest.
9. Export the OSGi Bundle.
10. Create a Deployment Package.

Watch the video on youtube.

[![Watch the video](https://img.youtube.com/vi/KuZf8mGxevk/0.jpg)](https://www.youtube.com/watch?v=KuZf8mGxevk)
## How to run bundle OSGi
***
1. Deploying Bundles.
2. Kura logs.
3. Install/Upgrade Package.
4. OSGi console for managing bundles (Telnet).
5. Snapshots.
6. Complete package uninstallation.
7. Multiple instances of a component.

Watch the video on youtube.

[![Watch the video](https://img.youtube.com/vi/jg1X6iwS9No/0.jpg)](https://www.youtube.com/watch?v=jg1X6iwS9No)
## Links
Eclipse Kura Documentation:
* http://eclipse.github.io/kura/
* https://www.eclipse.org/kura/downloads.php
* https://download.eclipse.org/kura/docs/api/
* https://docs.osgi.org/specification/
***

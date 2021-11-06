***
# KuraOSGiServicePattern

***
## General Info
Basic example for modular applications following the typical OSGi service pattern for an Eclipse Kura project.


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
## Links
Documentation:
* https://docs.jboss.org/author/display/JBOSGI/Introduction.html
* http://www.liferaysavvy.com/2017/09/osgi-declarative-services-ds.html
* https://wiki.eclipse.org/Tutorial:_Building_your_first_OSGi_Remote_Service
* http://documentation.bosch-si.com/iot/SDK/v8.2/SDK_mBS/common_tasks/eclipse/develop_bundles/runtime_application_development.html
* https://techblog.smc.it/en/2020-07-31/cosa-sono-osgi-remote-services
***

![]("Image/OSGi Service Pattern.jpg" width="300")

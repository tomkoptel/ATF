# Installation
To make project you have to set up `ANDROID_HOME` as well as `JAVA_HOME` env variables.
You can do this either in `.profile` or `.bash_profile`.

The example of set up could be:

    export PATH=/opt/local/bin:/opt/local/sbin:$PATH

    export JAVA_HOME=/Library/Java/Home
    export ANDROID_HOME=/path/to/android-sdk-<OS>/
    export PATH=${PATH}:/path/to/android-sdk-<OS>/tools/
    export PATH=${PATH}:/path/to/android-sdk-<OS>/platform-tools

# Maven
Every setup of maven in idea can be easily done by mouse right clicking on the plugins window content.
Before you can do anything you should:
 1. Activate yours Maven plugins inside Idea.
 2. Setup settings.xml for you Maven. `Open settings.xml`

     <?xml version="1.0" encoding="UTF-8"?>
     <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
         <profiles>
             <profile>
                 <id>android</id>
                 <properties>
                     <android.sdk.path>
                         ${env.ANDROID_HOME}
                     </android.sdk.path>
                 </properties>
             </profile>
         </profiles>
         <activeProfiles>
             <!--make the profile active all the time -->
             <activeProfile>android</activeProfile>
         </activeProfiles>
     </settings>

 3. The last one will take some time 5-10 min. Run `Download sources and Documentation`

If you are facing crazy backtrace while building rerun `Generate sources and Update folders`.

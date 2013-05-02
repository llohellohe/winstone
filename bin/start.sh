#!/bin/bash

if [ -z $WINSTONE_HOME ];then
WINSTONE_HOME=/Users/yangqi/Dropbox/open-code/winstone
fi

echo "Winstone Home is $WINSTONE_HOME"

JAVA_DEBUG_OPT=" -server -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=1050,server=y,suspend=y "
java $JAVA_DEBUG_OPT -jar $WINSTONE_HOME/winstone-0.9.10.jar --webappsDir=webapp $*

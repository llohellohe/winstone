#!/bin/bash
mvn package

echo "START TO COPY"
cp target/o2-web.war /Users/yangqi/Dropbox/open-code/winstone/bin/webapp

#!/bin/bash
mvn package

echo "START TO COPY"
cp target/o2-web.war /usr/alibaba/install/jboss-as-7.1.1.Final/standalone/deployments
echo "DONE"

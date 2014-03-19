#!/bin/sh
cp -r src/main/webapp/* $CATALINA_HOME/webapps/webservlet/
cp -r target/classes $CATALINA_HOME/webapps/webservlet/WEB-INF/

mkdir -p $CATALINA_HOME/webapps/webservlet/WEB-INF/lib/ 
cp -r lib/mysql-connector-java-3.1.14-bin.jar $CATALINA_HOME/webapps/webservlet/WEB-INF/lib/


#!/bin/sh
mkdir -p target/classes/
javac -classpath lib/servlet-api.jar -d target/classes/ src/main/java/com/bodejidi/WebServlet.java


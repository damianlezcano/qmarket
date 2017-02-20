#!/bin/bash

#java
export JAVA_HOME=$PWD/jre
export PATH=$JAVA_HOME/bin:$PATH
#invoke
java -version
java -jar market-client.jar

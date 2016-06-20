#!/usr/bin/env bash

PORT=9090
JAVA_DEBUG_OPTS="-agentlib:jdwp=transport=dt_socket,address=8787,server=y,suspend=n"
JAVA_OPTS=" $JAVA_DEBUG_OPTS"

WAR_FILE="target/hojeehdiaderua.war"

clear

mvn clean install

export $DATABASE_URL
export $GOOGLE_MAPS_API_KEY
export $JOB_USER
export $JOB_PASSWORD

clear

java $JAVA_OPTS -jar target/dependency/jetty-runner.jar --port $PORT target/*.war
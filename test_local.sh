#!/usr/bin/env bash

PORT=9090
JAVA_DEBUG_OPTS="-agentlib:jdwp=transport=dt_socket,address=8787,server=y,suspend=n"
JAVA_OPTS=""

WAR_FILE="target/hojeehdiaderua.war"

DATABASE_URL=""
GOOGLE_MAPS_API_KEY=""
JOB_USER=""
JOB_PASSWORD=""

mvn clean install

export $DATABASE_URL
export $GOOGLE_MAPS_API_KEY
export $JOB_USER
export $JOB_PASSWORD

java $JAVA_OPTS -classpath target/dependency/jetty-runner.jar org.mortbay.jetty.runner.Runner --port $PORT $WAR_FILE
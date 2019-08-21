SPRING_APP_PORT=9090
SPRING_PROFILE=dev
DEBUG_PORT=8787
APP_FILE=target/hojeehdiaderua.jar


.PHONY: clean

clean:
	@mvn -q clean

compile:
	@mvn clean install

run: compile
	@java -Dserver.port=$(SPRING_APP_PORT) -Dspring.profiles.active=$(SPRING_PROFILE) -jar $(APP_FILE)

debug: compile
	@java -Dserver.port=$(SPRING_APP_PORT) -Dspring.profiles.active=$(SPRING_PROFILE) -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=$(DEBUG_PORT) -jar $(APP_FILE)
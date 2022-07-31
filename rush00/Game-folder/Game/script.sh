#!/bin/bash
cd ../ChaseLogic; mvn clean install; cd ../Game
mvn idea::idea
mvn package
unzip -q -c ./target/Game-1.0-SNAPSHOT.jar META-INF/MANIFEST.MF
java -jar target/Game-1.0-SNAPSHOT.jar -e=4 -w=10 -s=30 -p=production
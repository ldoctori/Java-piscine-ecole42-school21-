#!/bin/bash
mkdir target
javac -d ./target/ src/java/edu/school21/printer/*/*.java
jar cvfm target/images-to-chars-printer.jar src/manifest.txt -C target edu/ -C src resources/
cp -r src/resources target/.
echo "---Execute---"
unzip -q -c ./target/images-to-chars-printer.jar META-INF/MANIFEST.MF
java -jar target/images-to-chars-printer.jar . B

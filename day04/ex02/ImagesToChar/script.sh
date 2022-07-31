#!/bin/bash
mkdir target
javac -cp ".:./lib/jcommander-1.82.jar:./lib/JColor-5.5.1.jar" -d ./target/ src/java/edu/school21/printer/*/*.java
cd target
jar xf ../lib/jcommander-1.82.jar com
jar xf ../lib/JColor-5.5.1.jar com
cd ..
jar cvfm target/images-to-chars-printer.jar src/manifest.txt -C target .
cp -r src/resources target/.
unzip -q -c ./target/images-to-chars-printer.jar META-INF/MANIFEST.MF
java -jar target/images-to-chars-printer.jar --white=GREEN --black=YELLOW

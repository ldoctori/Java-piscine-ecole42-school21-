#!/bin/bash
mkdir target
javac -d ./target/ src/java/edu/school21/printer/*/*.java
java -cp ./target edu.school21.printer.app.Main . 0 ../it.bmp
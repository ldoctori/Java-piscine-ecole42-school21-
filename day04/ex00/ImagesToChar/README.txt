#To compile firstly create 'target' directory using:
-> mkdir target
#Then compile .class files using command:
-> javac -d ./target/ src/java/edu/school21/printer/*/*.java
#To run program type:
-> java -cp ./target edu.school21.printer.app.Main <white-char> <black-char> <path-to-image>
#And remember, that:
	#<white-char> and <black-char> should be chars, not strings
	#<path-to-image> should be path to exist image

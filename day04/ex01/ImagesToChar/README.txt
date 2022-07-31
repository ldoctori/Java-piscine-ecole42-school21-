# To compile firstly create 'target' directory using:
-> mkdir target
# Then compile '.class' files and put them into 'target' directory using command:
-> javac -d ./target/ src/java/edu/school21/printer/*/*.java

# To create 'images-to-chars-printer.jar' file in 'target' directory type:
-> jar cvfm target/images-to-chars-printer.jar src/manifest.txt -C target edu/ -C src resources/
# where options:
    # -c - Creates a new archive
    # -v - Generates verbose output to standard output
    # -f - Specifies the file 'jarfileName' to be do some with
    # -m - Reads the manifest file
    # -C - Gets in the specific directory

# To copy resources files into 'target' folder type:
-> cp -r src/resources target/.

# To run 'images-to-chars-printer.jar':
-> java -jar target/images-to-chars-printer.jar <white-char> <black-char>
# And remember, that:
    # <white-char> and <black-char> should be chars, not strings

# To print 'manifest.txt' content type:
-> unzip -q -c ./target/images-to-chars-printer.jar META-INF/MANIFEST.MF
    
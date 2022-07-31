# To compile firstly create 'target' directory using:
-> mkdir target
# Then compile '.class' files and put them into 'target' directory using command:
-> javac -cp ".:./lib/jcommander-1.82.jar:./lib/JColor-5.5.1.jar" -d ./target/ src/java/edu/school21/printer/*/*.java

# To create 'images-to-chars-printer.jar' file in 'target' directory you should firstly to extract
'*.class' files from 'lib/*.jar' archives using:
-> cd target
-> jar xf ../lib/jcommander-1.82.jar com
-> jar xf ../lib/JColor-5.5.1.jar com
-> cd ..

# Then you can create 'images-to-chars-printer.jar':
->jar cvfm target/images-to-chars-printer.jar src/manifest.txt -C target .
# where options:
    # -c - Creates a new archive
    # -v - Generates verbose output to standard output
    # -f - Specifies the file 'jarfileName' to be do some with
    # -m - Reads the manifest file
    # -C - Gets in the specific directory

# To copy resources files into 'target' folder type:
-> cp -r src/resources target/.

# To run 'images-to-chars-printer.jar':
-> ava -jar target/images-to-chars-printer.jar --white=<someColor> --black=<someColor>
# And remember, that:
    # <someColor> should be typed in upper case string, as RED or BRIGHT_RED
    # flags can be can be written in abbreviated form as --white -> -w and --black -> -b

# To print 'manifest.txt' content type:
-> unzip -q -c ./target/images-to-chars-printer.jar META-INF/MANIFEST.MF
    
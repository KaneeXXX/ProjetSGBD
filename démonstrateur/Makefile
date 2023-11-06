


all : run

compile :
	javac -d ./bin/ -sourcepath ./src/:./lib/ojdbc11.jar ./src/Main.java

run : compile 
	java -cp ./bin:./lib/ojdbc11.jar Main


clean :
	rm -r ./bin/*
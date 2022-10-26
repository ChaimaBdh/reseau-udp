all : classes


classes:
	javac -cp src src/udp/*.java -d classes
	javac -cp src src/multicast/*.java -d classes

receive:
	java -cp classes udp.ReceiveUDP 1500

send:
	java -cp classes udp.SendUDP a15p5 1500 "Hello world"

clean:
	rm -r classes

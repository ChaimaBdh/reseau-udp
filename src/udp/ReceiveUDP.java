package udp;

import java.net.*;
import java.lang.String;
import java.io.IOException;

/** class representing the server */
public class ReceiveUDP {

  // initializes the buffer size
  public final static int size = 256;

  public static void main(String[] args) throws IOException {
    if(args.length != 1) {
      System.out.println("Please write the port argument \n");
    }
    // gets the port from the first argument
    int port = Integer.parseInt(args[0]);

    // constructs a datagram socket and binds it to the specified port on the local host machine
    DatagramSocket socket = new DatagramSocket(port);
    byte[] buffer = new byte[size];

    while(true) {
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      socket.receive(packet);

      String data = new String(packet.getData());
      System.out.println("Message from client : " + data);
    }
  }
}

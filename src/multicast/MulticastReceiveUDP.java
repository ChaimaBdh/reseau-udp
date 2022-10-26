package multicast;

import java.net.*;
import java.lang.*;
import java.io.IOException;

public class MulticastReceiveUDP {

  // initializes the buffer size
  public final static int size = 256;

  public static void main(String[] args) throws IOException {
    // gets the port from the first argument
    int port = 7654;
    byte[] buffer = new byte[size];

    // constructs a datagram socket and binds it to the specified port on the local host machine
    MulticastSocket socket = new MulticastSocket(port);
    InetAddress group = InetAddress.getByName("224.0.0.1");
    socket.joinGroup(group);

    while(true) {
      DatagramPacket packet = new DatagramPacket(buffer, size);
      socket.receive(packet);

      String data = new String(packet.getData());
      System.out.println("Message from client : " + data);
    }
  }
}

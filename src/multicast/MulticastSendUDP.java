package multicast;

import java.net.*;
import java.lang.*;
import java.io.IOException;

public class MulticastSendUDP {

  public static void main(String[] args) throws IOException {
    if(args.length != 1) {
      System.out.println("Please write the message to send \n");
    }

    int port = 7654;
    MulticastSocket socket = new MulticastSocket();
    byte[] message = args[0].getBytes();
    InetAddress add = InetAddress.getByName("224.0.0.1");

    DatagramPacket packet = new DatagramPacket(message, message.length, add, port);

    socket.send(packet);
    socket.close();
  }
}

package udp;

import java.net.*;
import java.lang.*;
import java.io.IOException;

/** class representing the client */
public class SendUDP {

  public static void main(String[] args) throws IOException {
    if(args.length != 3) {
      System.out.println("Please write respectively the machine ip, port and message \n");
    }
    // création du point de connexion : depuis ce dernier on va envoyer un message
    DatagramSocket socket = new DatagramSocket();
    // encodes the String into a sequence of bytes using the named charset, storing the result into a new byte array
    byte[] message = args[2].getBytes();
    // gets the IP address of a host
    InetAddress add = InetAddress.getByName(args[0]);
    // gets the host's port
    int port = Integer.parseInt(args[1]);

    // creation of the datagram packet (bytes collection)
    DatagramPacket packet = new DatagramPacket(message, message.length, add, port);

    // sends the datagram packet
    socket.send(packet);
    socket.close();
  }
}

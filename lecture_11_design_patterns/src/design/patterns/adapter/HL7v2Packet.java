package design.patterns.adapter;

// Packet is our Adaptee

public class HL7v2Packet {
  final String packet;
  HL7v2Packet(String dataToSend) {
    packet = dataToSend;
  }

  public String getPacket() {
    // Assume the adaptee knows how to form a valid v2 packet. It uses Pipes & Hats |^
    // as delimiters For this example, we'll
    // just pass in the formatted v2 string, and the adaptee will pass it on
    return packet;
  }
}

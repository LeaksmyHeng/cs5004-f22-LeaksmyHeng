package design.patterns.adapter;

import java.util.HashMap;

// This adapter adapts HL7v2Packets to v3
public class HL7v2v3Adapter implements IHLxMessage {
  HL7v2Packet adaptee;
  String message;
  String transformedMessage;
  HashMap<String, String> packetParts = new HashMap<>();

  // Constructor to accept an adaptee
  HL7v2v3Adapter( HL7v2Packet packet ) {
    newPacket(packet);   // set our adaptee
  }

  @Override
  public void newPacket(HL7v2Packet packet ) {
    adaptee = packet;
  }

  private void unpackMessage() {
    final int ID = 0;
    final int NAME_TAG = 1;
    final int PHONE = 2;

    // Last name is mandatory for the packet
    // If malformed v2 packet, catch the exception. In a "real world" environment,
    // most likely log the event to a transmission log & possibly throw an exception
    // for the client to process
    try {
      String[] temp = message.split("\\|");
      String[] nameTemp = temp[NAME_TAG].split("\\^");
      packetParts.put("ID", temp[ID]);
      packetParts.put("LAST-NAME", nameTemp[0]);
      if(nameTemp.length > 1) {
        packetParts.put("FIRST-NAME", nameTemp[1]);
      }
      if (temp.length > 2 ) { // phone is optional
        packetParts.put("PHONE", temp[2]);
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid V2 packet: " + message );
    }
  }

  private void transformMessage() {
    // Note: This example uses hashmap to partially "fixup" malformed messages. In practice,
    // may wish to take a different approach. Perhaps throw an exception, or log
    // error to transmit log or SKIP the transmission of the error packet all together.

    StringBuilder xml = new StringBuilder();
    xml.append("<patient>\n");
    xml.append("\t<id " +
            packetParts.getOrDefault("ID", "UNKNOWN") + "/>\n");
    xml.append("\t<name last = \"" +
            packetParts.getOrDefault("LAST-NAME", "ERROR: MISSING NAME") + "\"");
    xml.append(" first = \"" +
            packetParts.getOrDefault("FIRST-NAME", "") + "\"/>\n");
    xml.append("\t<phone " +
            packetParts.getOrDefault("PHONE", "") + "/>\n");
    xml.append("</patient>");
    transformedMessage = xml.toString();
  }

  @Override
  public String transmitMessage() {
    message =  adaptee.getPacket(); // save original ... audit?
    unpackMessage();
    transformMessage();
    packetParts.clear(); // clear our mappings to prepare for the next packet
    return transformedMessage;
  }

}


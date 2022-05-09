package design.patterns.adapter;

public class HL7v2Client {
  // Our ficticious client, which is still on V2 will transmit to their V3
  // partners using the required adapter
  public static void main(String [] args) {

    String hl7v2Msg = "23|DOE^JENNY|8675309";
    String missingInfo = "23|JOHNSON^|";
    String malformedMissingAll =  "|^|";

    IHLxMessage v2v3Adapter =  new HL7v2v3Adapter(new HL7v2Packet(hl7v2Msg));

    System.out.println("Original HL7 v2 msg: " + hl7v2Msg);
    System.out.println("Transmit to our partner using v3 scheme:\n" +
            v2v3Adapter.transmitMessage());

    v2v3Adapter.newPacket(new HL7v2Packet(missingInfo));
    System.out.println("Original HL7 v2 msg: " + missingInfo);
    System.out.println("Transmit to our partner using v3 scheme:\n" +
            v2v3Adapter.transmitMessage());

    v2v3Adapter.newPacket(new HL7v2Packet(malformedMissingAll));
    System.out.println("Original HL7 v2 msg - Malformed, missing all: " +
            malformedMissingAll);
    System.out.println("Transmit to our partner using v3 scheme:\n" +
            v2v3Adapter.transmitMessage());
  }
}


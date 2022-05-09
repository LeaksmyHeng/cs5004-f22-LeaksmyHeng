package design.patterns.adapter;

public interface IHLxMessage {
  String transmitMessage();
  void newPacket(HL7v2Packet packet );
}

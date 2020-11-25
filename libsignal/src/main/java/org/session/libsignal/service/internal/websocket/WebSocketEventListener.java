package org.session.libsignal.service.internal.websocket;

public interface WebSocketEventListener {

  public void onMessage(byte[] payload);
  public void onClose();
  public void onConnected();

}

package org.session.libsignal.service.internal.push;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDiscoveryFailureReason {

  @JsonProperty
  private final String reason;

  public ContactDiscoveryFailureReason(String reason) {
    this.reason = reason == null ? "" : reason;
  }
}

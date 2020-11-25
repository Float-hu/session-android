/**
 * Copyright (C) 2016 Open Whisper Systems
 *
 * Licensed according to the LICENSE file in this repository.
 */
package org.session.libsignal.libsignal.fingerprint;

public class FingerprintParsingException extends Exception {

  public FingerprintParsingException(Exception nested) {
    super(nested);
  }

}

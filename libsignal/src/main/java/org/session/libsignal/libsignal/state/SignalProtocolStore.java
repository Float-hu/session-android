/**
 * Copyright (C) 2014-2016 Open Whisper Systems
 *
 * Licensed according to the LICENSE file in this repository.
 */
package org.session.libsignal.libsignal.state;

public interface SignalProtocolStore
    extends IdentityKeyStore, PreKeyStore, SessionStore, SignedPreKeyStore
{
}

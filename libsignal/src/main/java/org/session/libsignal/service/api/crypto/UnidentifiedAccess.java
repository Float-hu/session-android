package org.session.libsignal.service.api.crypto;


import org.session.libsignal.metadata.certificate.InvalidCertificateException;
import org.session.libsignal.metadata.certificate.SenderCertificate;
import org.session.libsignal.libsignal.util.ByteUtil;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class UnidentifiedAccess {

  private final byte[]            unidentifiedAccessKey;
  private final SenderCertificate unidentifiedCertificate;

  public UnidentifiedAccess(byte[] unidentifiedAccessKey, byte[] unidentifiedCertificate)
      throws InvalidCertificateException
  {
    this.unidentifiedAccessKey   = unidentifiedAccessKey;
    this.unidentifiedCertificate = new SenderCertificate(unidentifiedCertificate);
  }

  public byte[] getUnidentifiedAccessKey() {
    return unidentifiedAccessKey;
  }

  public SenderCertificate getUnidentifiedCertificate() {
    return unidentifiedCertificate;
  }

  public static byte[] deriveAccessKeyFrom(byte[] profileKey) {
    try {
      byte[]         nonce  = new byte[12];
      byte[]         input  = new byte[16];

      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(profileKey, "AES"), new GCMParameterSpec(128, nonce));

      byte[] ciphertext = cipher.doFinal(input);

      return ByteUtil.trim(ciphertext, 16);
    } catch (NoSuchAlgorithmException e) {
      throw new AssertionError(e);
    } catch (InvalidKeyException e) {
      throw new AssertionError(e);
    } catch (NoSuchPaddingException e) {
      throw new AssertionError(e);
    } catch (InvalidAlgorithmParameterException e) {
      throw new AssertionError(e);
    } catch (BadPaddingException e) {
      throw new AssertionError(e);
    } catch (IllegalBlockSizeException e) {
      throw new AssertionError(e);
    }
  }
}

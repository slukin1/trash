package org.jmrtd.protocol;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import org.jmrtd.APDULevelBACCapable;
import org.jmrtd.CardServiceProtocolException;
import org.jmrtd.Util;

public class BACAPDUSender implements APDULevelBACCapable {
    private static final Provider BC_PROVIDER = Util.getBouncyCastleProvider();
    private static final IvParameterSpec ZERO_IV_PARAM_SPEC = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
    private Cipher cipher;
    private Mac mac;
    private CardService service;

    public BACAPDUSender(CardService cardService) {
        this.service = cardService;
        try {
            this.mac = Mac.getInstance("ISO9797Alg3Mac", BC_PROVIDER);
            this.cipher = Util.getCipher("DESede/CBC/NoPadding");
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException("Unexpected security exception during initialization", e11);
        }
    }

    public synchronized byte[] sendGetChallenge() throws CardServiceException {
        return sendGetChallenge((APDUWrapper) null);
    }

    public synchronized byte[] sendMutualAuth(byte[] bArr, byte[] bArr2, byte[] bArr3, SecretKey secretKey, SecretKey secretKey2) throws CardServiceException {
        byte[] doFinal;
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr2;
        byte[] bArr6 = bArr3;
        SecretKey secretKey3 = secretKey;
        SecretKey secretKey4 = secretKey2;
        synchronized (this) {
            if (bArr4 != null) {
                try {
                    if (bArr4.length == 8) {
                        if (bArr5 == null || bArr5.length != 8) {
                            bArr5 = new byte[8];
                        }
                        if (bArr6 == null || bArr6.length != 16) {
                            throw new IllegalArgumentException("kIFD wrong length");
                        } else if (secretKey3 == null) {
                            throw new IllegalArgumentException("kEnc == null");
                        } else if (secretKey4 != null) {
                            Cipher cipher2 = this.cipher;
                            IvParameterSpec ivParameterSpec = ZERO_IV_PARAM_SPEC;
                            cipher2.init(1, secretKey3, ivParameterSpec);
                            byte[] bArr7 = new byte[32];
                            System.arraycopy(bArr4, 0, bArr7, 0, 8);
                            System.arraycopy(bArr5, 0, bArr7, 8, 8);
                            System.arraycopy(bArr6, 0, bArr7, 16, 16);
                            byte[] doFinal2 = this.cipher.doFinal(bArr7);
                            if (doFinal2.length == 32) {
                                this.mac.init(secretKey4);
                                byte[] doFinal3 = this.mac.doFinal(Util.pad(doFinal2, 8));
                                if (doFinal3.length == 8) {
                                    byte[] bArr8 = new byte[40];
                                    System.arraycopy(doFinal2, 0, bArr8, 0, 32);
                                    System.arraycopy(doFinal3, 0, bArr8, 32, 8);
                                    ResponseAPDU transmit = this.service.transmit(new CommandAPDU(0, -126, 0, 0, bArr8, 40));
                                    if (transmit != null) {
                                        byte[] bytes = transmit.getBytes();
                                        short sw2 = (short) transmit.getSW();
                                        if (bytes != null) {
                                            if (sw2 != -28672) {
                                                ResponseAPDU transmit2 = this.service.transmit(new CommandAPDU(0, -126, 0, 0, bArr8, 0));
                                                bytes = transmit2.getBytes();
                                                sw2 = (short) transmit2.getSW();
                                            }
                                            if (bytes.length == 42) {
                                                this.cipher.init(2, secretKey3, ivParameterSpec);
                                                doFinal = this.cipher.doFinal(bytes, 0, (bytes.length - 8) - 2);
                                                if (doFinal.length != 32) {
                                                    throw new CardServiceException("Cryptogram wrong length, was expecting 32, found " + doFinal.length, (int) sw2);
                                                }
                                            } else {
                                                throw new CardServiceProtocolException("Mutual authentication failed: expected length: 40 + 2, actual length: " + bytes.length, 0, (int) sw2);
                                            }
                                        } else {
                                            throw new CardServiceException("Mutual authentication failed, received empty data in response APDU", (int) sw2);
                                        }
                                    } else {
                                        throw new CardServiceException("Mutual authentication failed, received null response APDU");
                                    }
                                } else {
                                    throw new IllegalStateException("MAC wrong length");
                                }
                            } else {
                                throw new IllegalStateException("Cryptogram wrong length " + doFinal2.length);
                            }
                        } else {
                            throw new IllegalArgumentException("kMac == null");
                        }
                    }
                } catch (GeneralSecurityException e11) {
                    throw new CardServiceException("Security exception during mutual auth", (Throwable) e11);
                }
            }
            throw new IllegalArgumentException("rndIFD wrong length");
        }
        return doFinal;
    }

    public synchronized byte[] sendGetChallenge(APDUWrapper aPDUWrapper) throws CardServiceException {
        byte[] data;
        ResponseAPDU transmit = this.service.transmit(new CommandAPDU(0, -124, 0, 0, 8));
        data = transmit.getData();
        if (data == null || data.length != 8) {
            throw new CardServiceException("Get challenge failed", transmit.getSW());
        }
        return data;
    }
}

package org.jmrtd.protocol;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.SecretKey;
import net.sf.scuba.smartcards.CardServiceException;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.jmrtd.APDULevelBACCapable;
import org.jmrtd.AccessKeySpec;
import org.jmrtd.BACKeySpec;
import org.jmrtd.CardServiceProtocolException;
import org.jmrtd.Util;

public class BACProtocol {
    private int maxTranceiveLength;
    private Random random = new SecureRandom();
    private APDULevelBACCapable service;
    private boolean shouldCheckMAC;

    public BACProtocol(APDULevelBACCapable aPDULevelBACCapable, int i11, boolean z11) {
        this.service = aPDULevelBACCapable;
        this.maxTranceiveLength = i11;
        this.shouldCheckMAC = z11;
    }

    public static byte[] computeKeySeedForBAC(BACKeySpec bACKeySpec) throws GeneralSecurityException {
        String documentNumber = bACKeySpec.getDocumentNumber();
        String dateOfBirth = bACKeySpec.getDateOfBirth();
        String dateOfExpiry = bACKeySpec.getDateOfExpiry();
        if (dateOfBirth == null || dateOfBirth.length() != 6) {
            throw new IllegalArgumentException("Wrong date format used for date of birth. Expected yyMMdd, found " + dateOfBirth);
        } else if (dateOfExpiry == null || dateOfExpiry.length() != 6) {
            throw new IllegalArgumentException("Wrong date format used for date of expiry. Expected yyMMdd, found " + dateOfExpiry);
        } else if (documentNumber != null) {
            return computeKeySeedForBAC(fixDocumentNumber(documentNumber), dateOfBirth, dateOfExpiry);
        } else {
            throw new IllegalArgumentException("Wrong document number. Found " + documentNumber);
        }
    }

    public static long computeSendSequenceCounter(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 8 || bArr2 == null || bArr2.length != 8) {
            throw new IllegalStateException("Wrong length input");
        }
        long j11 = 0;
        for (int i11 = 4; i11 < 8; i11++) {
            j11 = (j11 << 8) + ((long) (bArr[i11] & 255));
        }
        for (int i12 = 4; i12 < 8; i12++) {
            j11 = (j11 << 8) + ((long) (bArr2[i12] & 255));
        }
        return j11;
    }

    private SecureMessagingWrapper doBACStep(SecretKey secretKey, SecretKey secretKey2) throws CardServiceException, GeneralSecurityException {
        try {
            byte[] sendGetChallenge = this.service.sendGetChallenge();
            byte[] bArr = new byte[8];
            this.random.nextBytes(bArr);
            byte[] bArr2 = new byte[16];
            this.random.nextBytes(bArr2);
            try {
                byte[] bArr3 = new byte[16];
                System.arraycopy(this.service.sendMutualAuth(bArr, sendGetChallenge, bArr2, secretKey, secretKey2), 16, bArr3, 0, 16);
                byte[] bArr4 = new byte[16];
                for (int i11 = 0; i11 < 16; i11++) {
                    bArr4[i11] = (byte) ((bArr2[i11] & 255) ^ (bArr3[i11] & 255));
                }
                SecretKey deriveKey = Util.deriveKey(bArr4, 1);
                SecretKey deriveKey2 = Util.deriveKey(bArr4, 2);
                long computeSendSequenceCounter = computeSendSequenceCounter(sendGetChallenge, bArr);
                return new DESedeSecureMessagingWrapper(deriveKey, deriveKey2, this.maxTranceiveLength, this.shouldCheckMAC, computeSendSequenceCounter);
            } catch (Exception e11) {
                throw new CardServiceProtocolException("BAC failed in MUTUAL AUTH", 2, (Throwable) e11);
            }
        } catch (Exception e12) {
            throw new CardServiceProtocolException("BAC failed in GET CHALLENGE", 1, (Throwable) e12);
        }
    }

    private static String fixDocumentNumber(String str) {
        StringBuilder sb2 = new StringBuilder(str == null ? "" : str.replace('<', ' ').trim().replace(' ', '<'));
        while (sb2.length() < 9) {
            sb2.append('<');
        }
        return sb2.toString();
    }

    public BACResult doBAC(AccessKeySpec accessKeySpec) throws CardServiceException {
        try {
            byte[] key = accessKeySpec.getKey();
            return new BACResult(accessKeySpec, doBACStep(Util.deriveKey(key, 1), Util.deriveKey(key, 2)));
        } catch (GeneralSecurityException e11) {
            throw new CardServiceException("Error during BAC", (Throwable) e11);
        }
    }

    public BACResult doBAC(SecretKey secretKey, SecretKey secretKey2) throws CardServiceException, GeneralSecurityException {
        return new BACResult(doBACStep(secretKey, secretKey2));
    }

    private static byte[] computeKeySeedForBAC(String str, String str2, String str3) throws GeneralSecurityException {
        return Util.computeKeySeed(str, str2, str3, McElieceCCA2KeyGenParameterSpec.SHA1, true);
    }
}

package org.jmrtd.protocol;

import com.sumsub.sns.prooface.network.b;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.tlv.TLVUtil;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.jmrtd.APDULevelEACCACapable;
import org.jmrtd.CardServiceProtocolException;
import org.jmrtd.Util;
import org.jmrtd.lds.ChipAuthenticationInfo;
import org.jmrtd.lds.SecurityInfo;

public class EACCAProtocol {
    private static final Provider BC_PROVIDER = Util.getBouncyCastleProvider();
    private static final int COMMAND_CHAINING_CHUNK_SIZE = 223;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private int maxTranceiveLength;
    private APDULevelEACCACapable service;
    private boolean shouldCheckMAC;
    private SecureMessagingWrapper wrapper;

    public EACCAProtocol(APDULevelEACCACapable aPDULevelEACCACapable, SecureMessagingWrapper secureMessagingWrapper, int i11, boolean z11) {
        this.service = aPDULevelEACCACapable;
        this.wrapper = secureMessagingWrapper;
        this.maxTranceiveLength = i11;
        this.shouldCheckMAC = z11;
    }

    public static byte[] computeSharedSecret(String str, PublicKey publicKey, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyAgreement instance = KeyAgreement.getInstance(str, BC_PROVIDER);
        instance.init(privateKey);
        instance.doPhase(publicKey, true);
        return instance.generateSecret();
    }

    private static byte[] getKeyData(String str, PublicKey publicKey) {
        if ("DH".equals(str)) {
            return Util.i2os(((DHPublicKey) publicKey).getY());
        }
        if ("ECDH".equals(str)) {
            return ((ECPublicKey) publicKey).getQ().getEncoded(false);
        }
        throw new IllegalArgumentException("Unsupported agreement algorithm " + str);
    }

    public static byte[] getKeyHash(String str, PublicKey publicKey) throws NoSuchAlgorithmException {
        if ("DH".equals(str) || (publicKey instanceof DHPublicKey)) {
            return MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA1).digest(getKeyData(str, publicKey));
        }
        if ("ECDH".equals(str) || (publicKey instanceof java.security.interfaces.ECPublicKey)) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            return Util.alignKeyDataToSize(Util.i2os(eCPublicKey.getQ().getAffineXCoord().toBigInteger()), (int) Math.ceil(((double) eCPublicKey.getParameters().getCurve().getFieldSize()) / 8.0d));
        }
        throw new IllegalArgumentException("Unsupported agreement algorithm " + str);
    }

    private static String inferChipAuthenticationOIDfromPublicKeyOID(String str) {
        if (SecurityInfo.ID_PK_ECDH.equals(str)) {
            LOGGER.warning("Could not determine ChipAuthentication algorithm, defaulting to id-CA-ECDH-3DES-CBC-CBC");
            return SecurityInfo.ID_CA_ECDH_3DES_CBC_CBC;
        } else if (SecurityInfo.ID_PK_DH.equals(str)) {
            LOGGER.warning("Could not determine ChipAuthentication algorithm, defaulting to id-CA-DH-3DES-CBC-CBC");
            return SecurityInfo.ID_CA_DH_3DES_CBC_CBC;
        } else {
            Logger logger = LOGGER;
            logger.warning("No ChipAuthenticationInfo and unsupported ChipAuthenticationPublicKeyInfo public key OID " + str);
            return null;
        }
    }

    public static SecureMessagingWrapper restartSecureMessaging(String str, byte[] bArr, int i11, boolean z11) throws GeneralSecurityException {
        String cipherAlgorithm = ChipAuthenticationInfo.toCipherAlgorithm(str);
        int keyLength = ChipAuthenticationInfo.toKeyLength(str);
        SecretKey deriveKey = Util.deriveKey(bArr, cipherAlgorithm, keyLength, 1);
        SecretKey deriveKey2 = Util.deriveKey(bArr, cipherAlgorithm, keyLength, 2);
        if (cipherAlgorithm.startsWith("DESede")) {
            return new DESedeSecureMessagingWrapper(deriveKey, deriveKey2, i11, z11, 0);
        }
        if (cipherAlgorithm.startsWith(b.f40261d)) {
            return new AESSecureMessagingWrapper(deriveKey, deriveKey2, i11, z11, 0);
        }
        throw new IllegalStateException("Unsupported cipher algorithm " + cipherAlgorithm);
    }

    private static void sendGeneralAuthenticate(APDULevelEACCACapable aPDULevelEACCACapable, SecureMessagingWrapper secureMessagingWrapper, byte[] bArr) throws CardServiceException {
        try {
            aPDULevelEACCACapable.sendGeneralAuthenticate(secureMessagingWrapper, bArr, true);
        } catch (CardServiceException e11) {
            LOGGER.log(Level.WARNING, "Failed to send GENERAL AUTHENTICATE, falling back to command chaining", e11);
            List<byte[]> partition = Util.partition(223, bArr);
            int i11 = 0;
            for (byte[] sendGeneralAuthenticate : partition) {
                i11++;
                aPDULevelEACCACapable.sendGeneralAuthenticate(secureMessagingWrapper, sendGeneralAuthenticate, i11 >= partition.size());
            }
        }
    }

    public static void sendPublicKey(APDULevelEACCACapable aPDULevelEACCACapable, SecureMessagingWrapper secureMessagingWrapper, String str, BigInteger bigInteger, PublicKey publicKey) throws CardServiceException {
        String keyAgreementAlgorithm = ChipAuthenticationInfo.toKeyAgreementAlgorithm(str);
        String cipherAlgorithm = ChipAuthenticationInfo.toCipherAlgorithm(str);
        byte[] keyData = getKeyData(keyAgreementAlgorithm, publicKey);
        if (cipherAlgorithm.startsWith("DESede")) {
            byte[] bArr = null;
            if (bigInteger != null) {
                bArr = TLVUtil.wrapDO(132, Util.i2os(bigInteger));
            }
            try {
                aPDULevelEACCACapable.sendMSEKAT(secureMessagingWrapper, TLVUtil.wrapDO(145, keyData), bArr);
            } catch (Exception e11) {
                throw new CardServiceProtocolException("Exception during MSE KAT", 1, (Throwable) e11);
            }
        } else if (cipherAlgorithm.startsWith(b.f40261d)) {
            try {
                aPDULevelEACCACapable.sendMSESetATIntAuth(secureMessagingWrapper, str, bigInteger);
                try {
                    sendGeneralAuthenticate(aPDULevelEACCACapable, secureMessagingWrapper, TLVUtil.wrapDO(128, keyData));
                } catch (Exception e12) {
                    throw new CardServiceProtocolException("Exception during General Authenticate", 2, (Throwable) e12);
                }
            } catch (Exception e13) {
                throw new CardServiceProtocolException("Exception during MSE Set AT Int Auth", 1, (Throwable) e13);
            }
        } else {
            throw new IllegalStateException("Cannot set up secure channel with cipher " + cipherAlgorithm);
        }
    }

    public EACCAResult doCA(BigInteger bigInteger, String str, String str2, PublicKey publicKey) throws CardServiceException {
        if (publicKey != null) {
            String keyAgreementAlgorithm = ChipAuthenticationInfo.toKeyAgreementAlgorithm(str);
            if (keyAgreementAlgorithm == null) {
                throw new IllegalArgumentException("Unknown agreement algorithm");
            } else if ("ECDH".equals(keyAgreementAlgorithm) || "DH".equals(keyAgreementAlgorithm)) {
                if (str == null) {
                    str = inferChipAuthenticationOIDfromPublicKeyOID(str2);
                }
                AlgorithmParameterSpec algorithmParameterSpec = null;
                try {
                    if ("DH".equals(keyAgreementAlgorithm)) {
                        algorithmParameterSpec = ((DHPublicKey) publicKey).getParams();
                    } else if ("ECDH".equals(keyAgreementAlgorithm)) {
                        algorithmParameterSpec = ((java.security.interfaces.ECPublicKey) publicKey).getParams();
                    }
                    KeyPairGenerator instance = KeyPairGenerator.getInstance(keyAgreementAlgorithm, BC_PROVIDER);
                    instance.initialize(algorithmParameterSpec);
                    KeyPair generateKeyPair = instance.generateKeyPair();
                    PublicKey publicKey2 = generateKeyPair.getPublic();
                    PrivateKey privateKey = generateKeyPair.getPrivate();
                    sendPublicKey(this.service, this.wrapper, str, bigInteger, publicKey2);
                    byte[] keyHash = getKeyHash(keyAgreementAlgorithm, publicKey2);
                    SecureMessagingWrapper restartSecureMessaging = restartSecureMessaging(str, computeSharedSecret(keyAgreementAlgorithm, publicKey, privateKey), this.maxTranceiveLength, this.shouldCheckMAC);
                    this.wrapper = restartSecureMessaging;
                    return new EACCAResult(bigInteger, publicKey, keyHash, publicKey2, privateKey, restartSecureMessaging);
                } catch (GeneralSecurityException e11) {
                    throw new CardServiceException("Security exception during Chip Authentication", (Throwable) e11);
                }
            } else {
                throw new IllegalArgumentException("Unsupported agreement algorithm, expected ECDH or DH, found " + keyAgreementAlgorithm);
            }
        } else {
            throw new IllegalArgumentException("PICC public key is null");
        }
    }

    public SecureMessagingWrapper getWrapper() {
        return this.wrapper;
    }
}

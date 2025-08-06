package org.jmrtd.protocol;

import com.google.common.primitives.SignedBytes;
import com.huochat.community.util.FileTool;
import com.sumsub.sns.prooface.network.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import net.sf.scuba.tlv.TLVUtil;
import net.sf.scuba.util.Hex;
import okio.Utf8;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.jmrtd.APDULevelPACECapable;
import org.jmrtd.AccessKeySpec;
import org.jmrtd.BACKeySpec;
import org.jmrtd.CardServiceProtocolException;
import org.jmrtd.PACEKeySpec;
import org.jmrtd.PACESecretKeySpec;
import org.jmrtd.Util;
import org.jmrtd.lds.CVCAFile;
import org.jmrtd.lds.PACEInfo;

public class PACEProtocol {
    private static final Provider BC_PROVIDER = Util.getBouncyCastleProvider();
    private static final byte[] C0_LENGTH_128 = {-90, 104, -119, ISO7816.INS_PSO, 124, 65, -29, ISO7816.INS_GET_DATA, 115, -97, SignedBytes.MAX_POWER_OF_TWO, ISO7816.INS_READ_BINARY, 87, ISO7816.INS_LOAD_KEY_FILE, 89, 4};
    private static final byte[] C0_LENGTH_256 = {-44, 99, ISO7816.INS_UPDATE_BINARY, 82, ISO7816.INS_DECREASE_STAMPED, 18, 78, -9, -119, ISO7816.INS_MANAGE_CHANNEL, 84, -104, 109, ISO7816.INS_GET_DATA, 10, 23, 78, 40, -33, 117, ISOFileInfo.SECURITY_ATTR_COMPACT, -70, ISOFileInfo.A0, Utf8.REPLACEMENT_BYTE, ISO7816.INS_CHANGE_CHV, 6, 22, 65, 77, 90, 22, 118};
    private static final byte[] C1_LENGTH_128 = {-92, -31, 54, -84, 114, 95, 115, ISOFileInfo.SECURITY_ATTR_EXP, 1, -63, -10, 2, 23, -63, -120, -83};
    private static final byte[] C1_LENGTH_256 = {84, -67, 114, 85, -16, -86, -8, Framer.STDOUT_FRAME_PREFIX, -66, -61, CVCAFile.CAR_TAG, Utf8.REPLACEMENT_BYTE, -49, 57, ISO7816.INS_UPDATE_BINARY, -101, 108, -65, 6, 102, 119, ISO7816.INS_WRITE_BINARY, -6, -82, 90, -83, -39, -99, -8, -27, 53, 23};
    private static final byte[] IV_FOR_PACE_CAM_DECRYPTION = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private int maxTranceiveLengthForProtocol;
    private int maxTranceiveLengthForSecureMessaging;
    private Random random;
    private APDULevelPACECapable service;
    private boolean shouldCheckMAC;
    private SecureMessagingWrapper wrapper;

    /* renamed from: org.jmrtd.protocol.PACEProtocol$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jmrtd$lds$PACEInfo$MappingType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.jmrtd.lds.PACEInfo$MappingType[] r0 = org.jmrtd.lds.PACEInfo.MappingType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jmrtd$lds$PACEInfo$MappingType = r0
                org.jmrtd.lds.PACEInfo$MappingType r1 = org.jmrtd.lds.PACEInfo.MappingType.CAM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jmrtd$lds$PACEInfo$MappingType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jmrtd.lds.PACEInfo$MappingType r1 = org.jmrtd.lds.PACEInfo.MappingType.GM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jmrtd$lds$PACEInfo$MappingType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jmrtd.lds.PACEInfo$MappingType r1 = org.jmrtd.lds.PACEInfo.MappingType.IM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.protocol.PACEProtocol.AnonymousClass1.<clinit>():void");
        }
    }

    @Deprecated
    public PACEProtocol(APDULevelPACECapable aPDULevelPACECapable, SecureMessagingWrapper secureMessagingWrapper, int i11, boolean z11) {
        this(aPDULevelPACECapable, secureMessagingWrapper, 256, i11, z11);
    }

    private void checkConsistency(String str, String str2, String str3, int i11, AlgorithmParameterSpec algorithmParameterSpec) {
        if (str == null) {
            throw new IllegalArgumentException("Unknown agreement algorithm");
        } else if (!"ECDH".equalsIgnoreCase(str) && !"DH".equalsIgnoreCase(str)) {
            throw new IllegalArgumentException("Unsupported agreement algorithm, expected \"ECDH\" or \"DH\", found \"" + str + "\"");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Unknown cipher algorithm");
        } else if (!"DESede".equalsIgnoreCase(str2) && !b.f40261d.equalsIgnoreCase(str2)) {
            throw new IllegalArgumentException("Unsupported cipher algorithm, expected \"DESede\" or \"AES\", found \"" + str2 + "\"");
        } else if (!McElieceCCA2KeyGenParameterSpec.SHA1.equalsIgnoreCase(str3) && !FileTool.HASH_TYPE_SHA1.equalsIgnoreCase(str3) && !"SHA-256".equalsIgnoreCase(str3) && !"SHA256".equalsIgnoreCase(str3)) {
            throw new IllegalArgumentException("Unsupported cipher algorithm, expected \"SHA-1\" or \"SHA-256\", found \"" + str3 + "\"");
        } else if (i11 != 128 && i11 != 192 && i11 != 256) {
            throw new IllegalArgumentException("Unsupported key length, expected 128, 192, or 256, found " + i11);
        } else if ("ECDH".equalsIgnoreCase(str) && !(algorithmParameterSpec instanceof ECParameterSpec)) {
            throw new IllegalArgumentException("Expected ECParameterSpec for agreement algorithm \"" + str + "\", found " + algorithmParameterSpec.getClass().getCanonicalName());
        } else if ("DH".equalsIgnoreCase(str) && !(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new IllegalArgumentException("Expected DHParameterSpec for agreement algorithm \"" + str + "\", found " + algorithmParameterSpec.getClass().getCanonicalName());
        }
    }

    public static byte[] computeKeySeedForPACE(AccessKeySpec accessKeySpec) throws GeneralSecurityException {
        if (accessKeySpec == null) {
            throw new IllegalArgumentException("Access key cannot be null");
        } else if (accessKeySpec instanceof BACKeySpec) {
            BACKeySpec bACKeySpec = (BACKeySpec) accessKeySpec;
            String documentNumber = bACKeySpec.getDocumentNumber();
            String dateOfBirth = bACKeySpec.getDateOfBirth();
            String dateOfExpiry = bACKeySpec.getDateOfExpiry();
            if (dateOfBirth == null || dateOfBirth.length() != 6) {
                throw new IllegalArgumentException("Wrong date format used for date of birth. Expected yyMMdd, found " + dateOfBirth);
            } else if (dateOfExpiry == null || dateOfExpiry.length() != 6) {
                throw new IllegalArgumentException("Wrong date format used for date of expiry. Expected yyMMdd, found " + dateOfExpiry);
            } else if (documentNumber != null) {
                return computeKeySeedForPACE(fixDocumentNumber(documentNumber), dateOfBirth, dateOfExpiry);
            } else {
                throw new IllegalArgumentException("Wrong document number. Found " + documentNumber);
            }
        } else if (accessKeySpec instanceof PACEKeySpec) {
            return ((PACEKeySpec) accessKeySpec).getKey();
        } else {
            LOGGER.warning("JMRTD doesn't recognize this type of access key, best effort key derivation!");
            return accessKeySpec.getKey();
        }
    }

    public static PublicKey decodePublicKeyFromSmartCard(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec != null) {
            try {
                if (algorithmParameterSpec instanceof ECParameterSpec) {
                    return Util.getPublicKey("EC", new ECPublicKeySpec(Util.os2ECPoint(bArr), (ECParameterSpec) algorithmParameterSpec));
                }
                if (algorithmParameterSpec instanceof DHParameterSpec) {
                    DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                    return Util.getPublicKey("DH", new DHPublicKeySpec(Util.os2i(bArr), dHParameterSpec.getP(), dHParameterSpec.getG()));
                }
                throw new IllegalArgumentException("Expected ECParameterSpec or DHParameterSpec, found " + algorithmParameterSpec.getClass().getCanonicalName());
            } catch (GeneralSecurityException e11) {
                LOGGER.log(Level.WARNING, "Exception", e11);
                throw new IllegalArgumentException(e11);
            }
        } else {
            throw new IllegalArgumentException("Params cannot be null");
        }
    }

    public static SecretKey deriveStaticPACEKey(AccessKeySpec accessKeySpec, String str) throws GeneralSecurityException {
        return Util.deriveKey(computeKeySeedForPACE(accessKeySpec), PACEInfo.toCipherAlgorithm(str), PACEInfo.toKeyLength(str), (byte[]) null, 3, accessKeySpec instanceof PACEKeySpec ? ((PACEKeySpec) accessKeySpec).getKeyReference() : 0);
    }

    public static byte[] encodePublicKeyDataObject(String str, PublicKey publicKey) throws InvalidKeyException {
        return encodePublicKeyDataObject(str, publicKey, true);
    }

    public static byte[] encodePublicKeyForSmartCard(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey == null) {
            throw new IllegalArgumentException("Cannot encode null public key");
        } else if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(Util.ecPoint2OS(eCPublicKey.getW(), eCPublicKey.getParams().getCurve().getField().getFieldSize()));
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException e11) {
                throw new IllegalStateException("Internal error writing to memory", e11);
            }
        } else if (publicKey instanceof DHPublicKey) {
            return Util.i2os(((DHPublicKey) publicKey).getY());
        } else {
            throw new InvalidKeyException("Unsupported public key: " + publicKey.getClass().getCanonicalName());
        }
    }

    private static String fixDocumentNumber(String str) {
        StringBuilder sb2 = new StringBuilder(str.replace('<', ' ').trim().replace(' ', '<'));
        while (sb2.length() < 9) {
            sb2.append('<');
        }
        return sb2.toString();
    }

    public static byte[] generateAuthenticationToken(String str, SecretKey secretKey, PublicKey publicKey) throws GeneralSecurityException {
        return generateAuthenticationToken(str, Util.getMac(inferMACAlgorithmFromCipherAlgorithm(PACEInfo.toCipherAlgorithm(str)), secretKey), publicKey);
    }

    public static ECPoint icartPointEncode(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        BigInteger bigInteger2 = bigInteger;
        ECParameterSpec eCParameterSpec2 = eCParameterSpec;
        BigInteger prime = Util.getPrime(eCParameterSpec);
        if (BigInteger.valueOf(3).equals(prime.mod(BigInteger.valueOf(4)))) {
            int cofactor = eCParameterSpec.getCofactor();
            BigInteger a11 = eCParameterSpec.getCurve().getA();
            BigInteger b11 = eCParameterSpec.getCurve().getB();
            BigInteger mod = bigInteger2.modPow(BigInteger.valueOf(2), prime).negate().mod(prime);
            BigInteger mod2 = mod.add(mod.modPow(BigInteger.valueOf(2), prime)).mod(prime);
            BigInteger bigInteger3 = BigInteger.ONE;
            BigInteger mod3 = b11.negate().multiply(bigInteger3.add(mod2)).multiply(a11.multiply(mod2).modPow(prime.subtract(bigInteger3).subtract(bigInteger3), prime)).mod(prime);
            BigInteger mod4 = mod.multiply(mod3).mod(prime);
            BigInteger mod5 = mod3.modPow(BigInteger.valueOf(3), prime).add(a11.multiply(mod3)).add(b11).mod(prime);
            BigInteger mod6 = bigInteger2.modPow(BigInteger.valueOf(3), prime).multiply(mod5).mod(prime);
            BigInteger modPow = mod5.modPow(prime.subtract(bigInteger3).subtract(prime.add(bigInteger3).multiply(BigInteger.valueOf(4).modInverse(prime)).mod(prime)), prime);
            ECPoint eCPoint = modPow.modPow(BigInteger.valueOf(2), prime).multiply(mod5).mod(prime).equals(bigInteger3) ? new ECPoint(mod3, modPow.multiply(mod5).mod(prime)) : new ECPoint(mod4, modPow.multiply(mod6).mod(prime));
            if (cofactor == 1) {
                return Util.normalize(eCPoint, eCParameterSpec2);
            }
            org.bouncycastle.math.ec.ECPoint bouncyCastleECPoint = Util.toBouncyCastleECPoint(eCPoint, eCParameterSpec2);
            bouncyCastleECPoint.multiply(BigInteger.valueOf((long) cofactor));
            return Util.fromBouncyCastleECPoint(bouncyCastleECPoint);
        }
        throw new InvalidParameterException("Cannot encode point because p != 3 (mod 4)");
    }

    private static String inferMACAlgorithmFromCipherAlgorithm(String str) throws InvalidAlgorithmParameterException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot infer MAC algorithm from cipher algorithm null");
        } else if (str.startsWith("DESede")) {
            return "ISO9797ALG3WITHISO7816-4PADDING";
        } else {
            if (str.startsWith(b.f40261d)) {
                return "AESCMAC";
            }
            throw new InvalidAlgorithmParameterException("Cannot infer MAC algorithm from cipher algorithm \"" + str + "\"");
        }
    }

    public static DHParameterSpec mapNonceGMWithDH(byte[] bArr, BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        BigInteger p11 = dHParameterSpec.getP();
        return new DHParameterSpec(p11, dHParameterSpec.getG().modPow(Util.os2i(bArr), p11).multiply(bigInteger).mod(p11), dHParameterSpec.getL());
    }

    public static ECParameterSpec mapNonceGMWithECDH(byte[] bArr, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        ECPoint generator = eCParameterSpec.getGenerator();
        EllipticCurve curve = eCParameterSpec.getCurve();
        BigInteger a11 = curve.getA();
        BigInteger b11 = curve.getB();
        BigInteger p11 = ((ECFieldFp) curve.getField()).getP();
        BigInteger order = eCParameterSpec.getOrder();
        int cofactor = eCParameterSpec.getCofactor();
        ECPoint add = Util.add(Util.multiply(Util.os2i(bArr), generator, eCParameterSpec), eCPoint, eCParameterSpec);
        if (!Util.toBouncyCastleECPoint(add, eCParameterSpec).isValid()) {
            LOGGER.info("ephemeralGenerator is not a valid point");
        }
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(p11), a11, b11), add, order, cofactor);
    }

    public static AlgorithmParameterSpec mapNonceIMWithDH(byte[] bArr, byte[] bArr2, String str, DHParameterSpec dHParameterSpec) throws GeneralSecurityException {
        BigInteger g11 = dHParameterSpec.getG();
        if (g11 != null) {
            BigInteger bigInteger = BigInteger.ONE;
            if (!g11.equals(bigInteger)) {
                BigInteger p11 = dHParameterSpec.getP();
                return new DHParameterSpec(p11, Util.os2i(pseudoRandomFunction(bArr, bArr2, p11, str)).modPow(p11.subtract(bigInteger).divide(dHParameterSpec instanceof PACEInfo.DHCParameterSpec ? ((PACEInfo.DHCParameterSpec) dHParameterSpec).getQ() : bigInteger), p11), dHParameterSpec.getL());
            }
        }
        throw new IllegalArgumentException("Invalid generator: " + g11);
    }

    public static AlgorithmParameterSpec mapNonceIMWithECDH(byte[] bArr, byte[] bArr2, String str, ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        BigInteger prime = Util.getPrime(eCParameterSpec);
        BigInteger order = eCParameterSpec.getOrder();
        int cofactor = eCParameterSpec.getCofactor();
        BigInteger a11 = eCParameterSpec.getCurve().getA();
        BigInteger b11 = eCParameterSpec.getCurve().getB();
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(prime), a11, b11), icartPointEncode(Util.os2i(pseudoRandomFunction(bArr, bArr2, prime, str)), eCParameterSpec), order, cofactor);
    }

    public static byte[] pseudoRandomFunction(byte[] bArr, byte[] bArr2, BigInteger bigInteger, String str) throws GeneralSecurityException {
        byte[] bArr3;
        byte[] bArr4;
        if (bArr == null || bArr2 == null) {
            throw new IllegalArgumentException("Null nonce");
        }
        int length = bArr.length * 8;
        int length2 = bArr2.length * 8;
        if (length == 128) {
            bArr4 = C0_LENGTH_128;
            bArr3 = C1_LENGTH_128;
        } else if (length == 192 || length == 256) {
            bArr4 = C0_LENGTH_256;
            bArr3 = C1_LENGTH_256;
        } else {
            throw new IllegalArgumentException("Unknown length " + length + ", was expecting 128, 192, or 256");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str2 = "/CBC/NoPadding";
        if (str.endsWith(str2)) {
            str2 = "";
        }
        sb2.append(str2);
        Cipher instance = Cipher.getInstance(sb2.toString());
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[instance.getBlockSize()]);
        instance.init(1, new SecretKeySpec(bArr2, str), ivParameterSpec);
        byte[] doFinal = instance.doFinal(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        while (i11 * length < bigInteger.bitLength() + 64) {
            try {
                instance.init(1, new SecretKeySpec(doFinal, 0, length2 / 8, str), ivParameterSpec);
                doFinal = instance.doFinal(bArr4);
                byteArrayOutputStream.write(instance.doFinal(bArr3));
                i11++;
            } catch (Exception e11) {
                LOGGER.log(Level.WARNING, "Could not write to stream", e11);
                byte[] i2os = Util.i2os(Util.os2i(byteArrayOutputStream.toByteArray()).mod(bigInteger));
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e12) {
                    LOGGER.log(Level.FINE, "Could not close stream", e12);
                }
                return i2os;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e13) {
                    LOGGER.log(Level.FINE, "Could not close stream", e13);
                }
                throw th2;
            }
        }
        byte[] i2os2 = Util.i2os(Util.os2i(byteArrayOutputStream.toByteArray()).mod(bigInteger));
        try {
            byteArrayOutputStream.close();
        } catch (IOException e14) {
            LOGGER.log(Level.FINE, "Could not close stream", e14);
        }
        return i2os2;
    }

    public static PublicKey updateParameterSpec(PublicKey publicKey, PrivateKey privateKey) throws GeneralSecurityException {
        String algorithm = publicKey.getAlgorithm();
        String algorithm2 = privateKey.getAlgorithm();
        if ("EC".equals(algorithm) || "ECDH".equals(algorithm)) {
            if ("EC".equals(algorithm2) || "ECDH".equals(algorithm2)) {
                return KeyFactory.getInstance("EC", BC_PROVIDER).generatePublic(new ECPublicKeySpec(((ECPublicKey) publicKey).getW(), ((ECPrivateKey) privateKey).getParams()));
            }
            throw new NoSuchAlgorithmException("Unsupported key type public: " + algorithm + ", private: " + algorithm2);
        } else if (!"DH".equals(algorithm)) {
            throw new NoSuchAlgorithmException("Unsupported key type public: " + algorithm + ", private: " + algorithm2);
        } else if ("DH".equals(algorithm2)) {
            KeyFactory instance = KeyFactory.getInstance("DH");
            DHParameterSpec params = ((DHPrivateKey) privateKey).getParams();
            return instance.generatePublic(new DHPublicKeySpec(((DHPublicKey) publicKey).getY(), params.getP(), params.getG()));
        } else {
            throw new NoSuchAlgorithmException("Unsupported key type public: " + algorithm + ", private: " + algorithm2);
        }
    }

    public PACEResult doPACE(AccessKeySpec accessKeySpec, String str, AlgorithmParameterSpec algorithmParameterSpec, BigInteger bigInteger) throws CardServiceException {
        try {
            return doPACE(accessKeySpec, deriveStaticPACEKey(accessKeySpec, str), str, algorithmParameterSpec, bigInteger);
        } catch (GeneralSecurityException e11) {
            throw new CardServiceProtocolException("PCD side error in key derivation step", 0, (Throwable) e11);
        }
    }

    public byte[] doPACEStep1(SecretKey secretKey, Cipher cipher) throws CardServiceProtocolException {
        try {
            byte[] unwrapDO = TLVUtil.unwrapDO(128, this.service.sendGeneralAuthenticate(this.wrapper, new byte[0], 256, false));
            cipher.init(2, secretKey, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(unwrapDO);
        } catch (GeneralSecurityException e11) {
            throw new CardServiceProtocolException("PCD side exception in tranceiving nonce step", 1, (Throwable) e11);
        } catch (CardServiceException e12) {
            throw new CardServiceProtocolException("PICC side exception in tranceiving nonce step", 1, (Throwable) e12);
        }
    }

    public PACEMappingResult doPACEStep2(PACEInfo.MappingType mappingType, String str, AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, Cipher cipher) throws CardServiceProtocolException {
        int i11 = AnonymousClass1.$SwitchMap$org$jmrtd$lds$PACEInfo$MappingType[mappingType.ordinal()];
        if (i11 == 1 || i11 == 2) {
            return doPACEStep2GM(str, algorithmParameterSpec, bArr);
        }
        if (i11 == 3) {
            return doPACEStep2IM(str, algorithmParameterSpec, bArr, cipher);
        }
        throw new CardServiceProtocolException("Unsupported mapping type " + mappingType, 2);
    }

    public PACEGMMappingResult doPACEStep2GM(String str, AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr) throws CardServiceProtocolException {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(str, BC_PROVIDER);
            instance.initialize(algorithmParameterSpec);
            KeyPair generateKeyPair = instance.generateKeyPair();
            PublicKey publicKey = generateKeyPair.getPublic();
            PrivateKey privateKey = generateKeyPair.getPrivate();
            PublicKey decodePublicKeyFromSmartCard = decodePublicKeyFromSmartCard(TLVUtil.unwrapDO(130, this.service.sendGeneralAuthenticate(this.wrapper, TLVUtil.wrapDO(129, encodePublicKeyForSmartCard(publicKey)), this.maxTranceiveLengthForProtocol, false)), algorithmParameterSpec);
            if ("ECDH".equals(str)) {
                PACEGMWithECDHAgreement pACEGMWithECDHAgreement = new PACEGMWithECDHAgreement();
                pACEGMWithECDHAgreement.init(privateKey);
                ECPoint doPhase = pACEGMWithECDHAgreement.doPhase(decodePublicKeyFromSmartCard);
                return new PACEGMWithECDHMappingResult(algorithmParameterSpec, bArr, decodePublicKeyFromSmartCard, generateKeyPair, doPhase, mapNonceGMWithECDH(bArr, doPhase, (ECParameterSpec) algorithmParameterSpec));
            } else if ("DH".equals(str)) {
                KeyAgreement instance2 = KeyAgreement.getInstance(str);
                instance2.init(privateKey);
                instance2.doPhase(decodePublicKeyFromSmartCard, true);
                byte[] generateSecret = instance2.generateSecret();
                return new PACEGMWithDHMappingResult(algorithmParameterSpec, bArr, decodePublicKeyFromSmartCard, generateKeyPair, generateSecret, mapNonceGMWithDH(bArr, Util.os2i(generateSecret), (DHParameterSpec) algorithmParameterSpec));
            } else {
                throw new IllegalArgumentException("Unsupported parameters for mapping nonce, expected \"ECDH\" / ECParameterSpec or \"DH\" / DHParameterSpec, found \"" + str + "\" /" + algorithmParameterSpec.getClass().getCanonicalName());
            }
        } catch (CardServiceException e11) {
            throw new CardServiceProtocolException("PICC side exception in mapping nonce step", 2, (Throwable) e11);
        } catch (Exception e12) {
            throw new CardServiceProtocolException("PCD side error in mapping nonce step", 2, (Throwable) e12);
        }
    }

    public PACEIMMappingResult doPACEStep2IM(String str, AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, Cipher cipher) throws CardServiceProtocolException {
        try {
            byte[] bArr2 = new byte[bArr.length];
            this.random.nextBytes(bArr2);
            this.service.sendGeneralAuthenticate(this.wrapper, TLVUtil.wrapDO(129, bArr2), this.maxTranceiveLengthForProtocol, false);
            if ("ECDH".equals(str)) {
                return new PACEIMMappingResult(algorithmParameterSpec, bArr, bArr2, mapNonceIMWithECDH(bArr, bArr2, cipher.getAlgorithm(), (ECParameterSpec) algorithmParameterSpec));
            }
            if ("DH".equals(str)) {
                return new PACEIMMappingResult(algorithmParameterSpec, bArr, bArr2, mapNonceIMWithDH(bArr, bArr2, cipher.getAlgorithm(), (DHParameterSpec) algorithmParameterSpec));
            }
            throw new IllegalArgumentException("Unsupported parameters for mapping nonce, expected \"ECDH\" / ECParameterSpec or \"DH\" / DHParameterSpec, found \"" + str + "\" /" + algorithmParameterSpec.getClass().getCanonicalName());
        } catch (GeneralSecurityException e11) {
            throw new CardServiceProtocolException("PCD side error in mapping nonce step", 2, (Throwable) e11);
        } catch (CardServiceException e12) {
            throw new CardServiceProtocolException("PICC side exception in mapping nonce step", 2, (Throwable) e12);
        }
    }

    public PublicKey doPACEStep3ExchangePublicKeys(PublicKey publicKey, AlgorithmParameterSpec algorithmParameterSpec) throws CardServiceProtocolException {
        try {
            PublicKey decodePublicKeyFromSmartCard = decodePublicKeyFromSmartCard(TLVUtil.unwrapDO(132, this.service.sendGeneralAuthenticate(this.wrapper, TLVUtil.wrapDO(131, encodePublicKeyForSmartCard(publicKey)), this.maxTranceiveLengthForProtocol, false)), algorithmParameterSpec);
            if (!publicKey.equals(decodePublicKeyFromSmartCard)) {
                return decodePublicKeyFromSmartCard;
            }
            throw new CardServiceProtocolException("PCD's public key and PICC's public key are the same in key agreement step!", 3);
        } catch (CardServiceException e11) {
            throw new CardServiceProtocolException("PICC side exception in key agreement step", 3, (Throwable) e11);
        } catch (Exception e12) {
            throw new CardServiceProtocolException("PCD side exception in key agreement step", 3, (Throwable) e12);
        }
    }

    public KeyPair doPACEStep3GenerateKeyPair(String str, AlgorithmParameterSpec algorithmParameterSpec) throws CardServiceProtocolException {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(str, BC_PROVIDER);
            instance.initialize(algorithmParameterSpec);
            return instance.generateKeyPair();
        } catch (GeneralSecurityException e11) {
            throw new CardServiceProtocolException("PCD side error during generation of PCD key pair", 3, (Throwable) e11);
        }
    }

    public byte[] doPACEStep3KeyAgreement(String str, PrivateKey privateKey, PublicKey publicKey) throws CardServiceProtocolException {
        try {
            KeyAgreement instance = KeyAgreement.getInstance(str, BC_PROVIDER);
            instance.init(privateKey);
            instance.doPhase(updateParameterSpec(publicKey, privateKey), true);
            return instance.generateSecret();
        } catch (Exception e11) {
            throw new CardServiceProtocolException("PCD side error during key agreement", 3, (Throwable) e11);
        }
    }

    public byte[] doPACEStep4(String str, PACEInfo.MappingType mappingType, KeyPair keyPair, PublicKey publicKey, SecretKey secretKey) throws CardServiceException {
        TLVInputStream tLVInputStream;
        Logger logger;
        Level level;
        try {
            tLVInputStream = new TLVInputStream(new ByteArrayInputStream(this.service.sendGeneralAuthenticate(this.wrapper, TLVUtil.wrapDO(133, generateAuthenticationToken(str, secretKey, publicKey)), 256, true)));
            try {
                int readTag = tLVInputStream.readTag();
                if (readTag != 134) {
                    Logger logger2 = LOGGER;
                    logger2.warning("Was expecting tag 0x86, found: " + Integer.toHexString(readTag));
                }
                tLVInputStream.readLength();
                byte[] readValue = tLVInputStream.readValue();
                byte[] generateAuthenticationToken = generateAuthenticationToken(str, secretKey, keyPair.getPublic());
                if (!Arrays.equals(generateAuthenticationToken, readValue)) {
                    throw new GeneralSecurityException("PICC authentication token mismatch, expectedPICCToken = " + Hex.bytesToHexString(generateAuthenticationToken) + ", piccToken = " + Hex.bytesToHexString(readValue));
                } else if (mappingType == PACEInfo.MappingType.CAM) {
                    int readTag2 = tLVInputStream.readTag();
                    if (readTag2 != 138) {
                        Logger logger3 = LOGGER;
                        logger3.warning("Was expecting tag 0x8A, found: " + Integer.toHexString(readTag2));
                    }
                    tLVInputStream.readLength();
                    byte[] readValue2 = tLVInputStream.readValue();
                    try {
                        tLVInputStream.close();
                    } catch (IOException e11) {
                        LOGGER.log(Level.FINE, "Exception closing stream", e11);
                    }
                    return readValue2;
                } else {
                    try {
                        tLVInputStream.close();
                        return null;
                    } catch (IOException e12) {
                        e = e12;
                        logger = LOGGER;
                        level = Level.FINE;
                        logger.log(level, "Exception closing stream", e);
                        return null;
                    }
                }
            } catch (IOException e13) {
                LOGGER.log(Level.WARNING, "Could not parse step 4 response", e13);
                try {
                    tLVInputStream.close();
                    return null;
                } catch (IOException e14) {
                    e = e14;
                    logger = LOGGER;
                    level = Level.FINE;
                    logger.log(level, "Exception closing stream", e);
                    return null;
                }
            }
        } catch (Exception e15) {
            throw new CardServiceProtocolException("PCD side exception in authentication token generation step", 4, (Throwable) e15);
        } catch (Throwable th2) {
            try {
                tLVInputStream.close();
            } catch (IOException e16) {
                LOGGER.log(Level.FINE, "Exception closing stream", e16);
            }
            throw th2;
        }
    }

    public PACEProtocol(APDULevelPACECapable aPDULevelPACECapable, SecureMessagingWrapper secureMessagingWrapper, int i11, int i12, boolean z11) {
        this.service = aPDULevelPACECapable;
        this.wrapper = secureMessagingWrapper;
        this.maxTranceiveLengthForProtocol = i11;
        this.maxTranceiveLengthForSecureMessaging = i12;
        this.shouldCheckMAC = z11;
        this.random = new SecureRandom();
    }

    public static byte[] encodePublicKeyDataObject(String str, PublicKey publicKey, boolean z11) throws InvalidKeyException {
        String str2 = str;
        PublicKey publicKey2 = publicKey;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TLVOutputStream tLVOutputStream = new TLVOutputStream(byteArrayOutputStream);
        try {
            tLVOutputStream.writeTag(32585);
            if (publicKey2 instanceof DHPublicKey) {
                DHPublicKey dHPublicKey = (DHPublicKey) publicKey2;
                DHParameterSpec params = dHPublicKey.getParams();
                BigInteger p11 = params.getP();
                int l11 = params.getL();
                BigInteger g11 = params.getG();
                BigInteger y11 = dHPublicKey.getY();
                tLVOutputStream.write(new ASN1ObjectIdentifier(str2).getEncoded());
                if (!z11) {
                    tLVOutputStream.writeTag(129);
                    tLVOutputStream.writeValue(Util.i2os(p11));
                    tLVOutputStream.writeTag(130);
                    tLVOutputStream.writeValue(Util.i2os(BigInteger.valueOf((long) l11)));
                    tLVOutputStream.writeTag(131);
                    tLVOutputStream.writeValue(Util.i2os(g11));
                }
                tLVOutputStream.writeTag(132);
                tLVOutputStream.writeValue(Util.i2os(y11));
            } else if (publicKey2 instanceof ECPublicKey) {
                ECPublicKey eCPublicKey = (ECPublicKey) publicKey2;
                ECParameterSpec params2 = eCPublicKey.getParams();
                BigInteger prime = Util.getPrime(params2);
                EllipticCurve curve = params2.getCurve();
                BigInteger a11 = curve.getA();
                BigInteger b11 = curve.getB();
                ECPoint generator = params2.getGenerator();
                BigInteger order = params2.getOrder();
                int cofactor = params2.getCofactor();
                ECPoint w11 = eCPublicKey.getW();
                tLVOutputStream.write(new ASN1ObjectIdentifier(str2).getEncoded());
                if (!z11) {
                    tLVOutputStream.writeTag(129);
                    tLVOutputStream.writeValue(Util.i2os(prime));
                    tLVOutputStream.writeTag(130);
                    tLVOutputStream.writeValue(Util.i2os(a11));
                    tLVOutputStream.writeTag(131);
                    tLVOutputStream.writeValue(Util.i2os(b11));
                    BigInteger affineX = generator.getAffineX();
                    BigInteger affineY = generator.getAffineY();
                    tLVOutputStream.writeTag(132);
                    tLVOutputStream.write(Util.i2os(affineX));
                    tLVOutputStream.write(Util.i2os(affineY));
                    tLVOutputStream.writeValueEnd();
                    tLVOutputStream.writeTag(133);
                    tLVOutputStream.writeValue(Util.i2os(order));
                }
                tLVOutputStream.writeTag(134);
                tLVOutputStream.writeValue(Util.ecPoint2OS(w11, params2.getCurve().getField().getFieldSize()));
                if (!z11) {
                    tLVOutputStream.writeTag(135);
                    tLVOutputStream.writeValue(Util.i2os(BigInteger.valueOf((long) cofactor)));
                }
            } else {
                throw new InvalidKeyException("Unsupported public key: " + publicKey.getClass().getCanonicalName());
            }
            tLVOutputStream.writeValueEnd();
            tLVOutputStream.flush();
            try {
                tLVOutputStream.close();
            } catch (IOException e11) {
                LOGGER.log(Level.FINE, "Error closing stream", e11);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e12) {
            LOGGER.log(Level.WARNING, "Exception", e12);
            throw new IllegalStateException("Error in encoding public key");
        } catch (Throwable th2) {
            Throwable th3 = th2;
            try {
                tLVOutputStream.close();
            } catch (IOException e13) {
                LOGGER.log(Level.FINE, "Error closing stream", e13);
            }
            throw th3;
        }
    }

    private PACEResult doPACE(AccessKeySpec accessKeySpec, SecretKey secretKey, String str, AlgorithmParameterSpec algorithmParameterSpec, BigInteger bigInteger) throws CardServiceException {
        byte[] bArr;
        byte[] bArr2;
        SecretKey secretKey2 = secretKey;
        PACEInfo.MappingType mappingType = PACEInfo.toMappingType(str);
        String keyAgreementAlgorithm = PACEInfo.toKeyAgreementAlgorithm(str);
        String cipherAlgorithm = PACEInfo.toCipherAlgorithm(str);
        String digestAlgorithm = PACEInfo.toDigestAlgorithm(str);
        int keyLength = PACEInfo.toKeyLength(str);
        checkConsistency(keyAgreementAlgorithm, cipherAlgorithm, digestAlgorithm, keyLength, algorithmParameterSpec);
        try {
            Cipher instance = Cipher.getInstance(cipherAlgorithm + "/CBC/NoPadding");
            try {
                byte keyReference = secretKey2 instanceof PACESecretKeySpec ? ((PACESecretKeySpec) secretKey2).getKeyReference() : 1;
                if (bigInteger == null) {
                    bArr = null;
                } else {
                    bArr = Util.i2os(bigInteger);
                }
                this.service.sendMSESetATMutualAuth(this.wrapper, str, keyReference, bArr);
                PACEMappingResult doPACEStep2 = doPACEStep2(mappingType, keyAgreementAlgorithm, algorithmParameterSpec, doPACEStep1(secretKey2, instance), instance);
                AlgorithmParameterSpec ephemeralParameters = doPACEStep2.getEphemeralParameters();
                KeyPair doPACEStep3GenerateKeyPair = doPACEStep3GenerateKeyPair(keyAgreementAlgorithm, ephemeralParameters);
                PublicKey doPACEStep3ExchangePublicKeys = doPACEStep3ExchangePublicKeys(doPACEStep3GenerateKeyPair.getPublic(), ephemeralParameters);
                byte[] doPACEStep3KeyAgreement = doPACEStep3KeyAgreement(keyAgreementAlgorithm, doPACEStep3GenerateKeyPair.getPrivate(), doPACEStep3ExchangePublicKeys);
                try {
                    SecretKey deriveKey = Util.deriveKey(doPACEStep3KeyAgreement, cipherAlgorithm, keyLength, 1);
                    SecretKey deriveKey2 = Util.deriveKey(doPACEStep3KeyAgreement, cipherAlgorithm, keyLength, 2);
                    PublicKey publicKey = doPACEStep3ExchangePublicKeys;
                    byte[] doPACEStep4 = doPACEStep4(str, mappingType, doPACEStep3GenerateKeyPair, doPACEStep3ExchangePublicKeys, deriveKey2);
                    try {
                        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
                        long sendSequenceCounter = secureMessagingWrapper == null ? 0 : secureMessagingWrapper.getSendSequenceCounter();
                        if (cipherAlgorithm.startsWith("DESede")) {
                            this.wrapper = new DESedeSecureMessagingWrapper(deriveKey, deriveKey2, this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC, 0);
                        } else if (cipherAlgorithm.startsWith(b.f40261d)) {
                            this.wrapper = new AESSecureMessagingWrapper(deriveKey, deriveKey2, this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC, sendSequenceCounter);
                        } else {
                            LOGGER.warning("Unsupported cipher algorithm " + cipherAlgorithm);
                        }
                        if (PACEInfo.MappingType.CAM.equals(mappingType)) {
                            if (doPACEStep4 == null) {
                                LOGGER.warning("Encrypted Chip Authentication data is null");
                            }
                            try {
                                Cipher instance2 = Cipher.getInstance("AES/CBC/NoPadding");
                                instance2.init(2, deriveKey, new IvParameterSpec(IV_FOR_PACE_CAM_DECRYPTION));
                                bArr2 = Util.unpad(instance2.doFinal(doPACEStep4));
                            } catch (GeneralSecurityException e11) {
                                LOGGER.log(Level.WARNING, "Could not decrypt Chip Authentication data", e11);
                                bArr2 = null;
                            }
                            return new PACECAMResult(accessKeySpec, keyAgreementAlgorithm, cipherAlgorithm, digestAlgorithm, keyLength, doPACEStep2, doPACEStep3GenerateKeyPair, publicKey, doPACEStep4, bArr2, this.wrapper);
                        }
                        return new PACEResult(accessKeySpec, mappingType, keyAgreementAlgorithm, cipherAlgorithm, digestAlgorithm, keyLength, doPACEStep2, doPACEStep3GenerateKeyPair, publicKey, this.wrapper);
                    } catch (GeneralSecurityException e12) {
                        throw new CardServiceProtocolException("Security exception in secure messaging establishment", 4, (Throwable) e12);
                    }
                } catch (GeneralSecurityException e13) {
                    throw new CardServiceProtocolException("Security exception during secure messaging key derivation", 3, (Throwable) e13);
                }
            } catch (CardServiceException e14) {
                throw new CardServiceProtocolException("PICC side error in static PACE key derivation step", 0, (Throwable) e14);
            } catch (Exception e15) {
                throw new CardServiceProtocolException("PCD side error in static PACE key derivation step", 0, (Throwable) e15);
            }
        } catch (GeneralSecurityException e16) {
            throw new CardServiceProtocolException("PCD side error in static cipher construction during key derivation step", 0, (Throwable) e16);
        }
    }

    private static byte[] generateAuthenticationToken(String str, Mac mac, PublicKey publicKey) throws GeneralSecurityException {
        byte[] bArr = new byte[8];
        System.arraycopy(mac.doFinal(encodePublicKeyDataObject(str, publicKey)), 0, bArr, 0, 8);
        return bArr;
    }

    public static byte[] computeKeySeedForPACE(String str) throws GeneralSecurityException {
        return Util.computeKeySeed(str, McElieceCCA2KeyGenParameterSpec.SHA1, false);
    }

    private static byte[] computeKeySeedForPACE(String str, String str2, String str3) throws GeneralSecurityException {
        return Util.computeKeySeed(str, str2, str3, McElieceCCA2KeyGenParameterSpec.SHA1, false);
    }
}

package org.jmrtd.protocol;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.interfaces.DHPublicKey;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.tlv.TLVOutputStream;
import net.sf.scuba.tlv.TLVUtil;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.jmrtd.APDULevelEACTACapable;
import org.jmrtd.CardServiceProtocolException;
import org.jmrtd.Util;
import org.jmrtd.cert.CVCAuthorizationTemplate;
import org.jmrtd.cert.CVCPrincipal;
import org.jmrtd.cert.CardVerifiableCertificate;
import org.jmrtd.lds.icao.MRZInfo;

public class EACTAProtocol {
    private static final Provider BC_PROVIDER = Util.getBouncyCastleProvider();
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private static final int TAG_CVCERTIFICATE_SIGNATURE = 24375;
    private APDULevelEACTACapable service;
    private SecureMessagingWrapper wrapper;

    public EACTAProtocol(APDULevelEACTACapable aPDULevelEACTACapable, SecureMessagingWrapper secureMessagingWrapper) {
        this.service = aPDULevelEACTACapable;
        this.wrapper = secureMessagingWrapper;
    }

    public static byte[] deriveIdentifier(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[(length + 1)];
        try {
            System.arraycopy(str.getBytes("ISO-8859-1"), 0, bArr, 0, length);
            bArr[length] = (byte) MRZInfo.checkDigit(str);
            return bArr;
        } catch (UnsupportedEncodingException e11) {
            throw new IllegalStateException("Unsupported encoding", e11);
        }
    }

    public synchronized EACTAResult doEACTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, String str2) throws CardServiceException {
        return doTA(cVCPrincipal, list, privateKey, str, eACCAResult, deriveIdentifier(str2));
    }

    public synchronized EACTAResult doTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, PACEResult pACEResult) throws CardServiceException {
        try {
        } catch (NoSuchAlgorithmException e11) {
            throw new CardServiceException("No such algorithm", (Throwable) e11);
        }
        return doTA(cVCPrincipal, list, privateKey, str, eACCAResult, deriveIdentifier(pACEResult.getPICCPublicKey()));
    }

    public synchronized EACTAResult doTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, byte[] bArr) throws CardServiceException {
        CVCPrincipal cVCPrincipal2;
        byte[] sendGetChallenge;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    if (eACCAResult != null) {
                        byte[] keyHash = eACCAResult.getKeyHash();
                        if (keyHash != null) {
                            CardVerifiableCertificate cardVerifiableCertificate = list.get(0);
                            if (CVCAuthorizationTemplate.Role.CVCA.equals(cardVerifiableCertificate.getAuthorizationTemplate().getRole())) {
                                CVCPrincipal holderReference = cardVerifiableCertificate.getHolderReference();
                                if (cVCPrincipal != null) {
                                    if (!cVCPrincipal.equals(holderReference)) {
                                        throw new CardServiceException("First certificate holds wrong authority, found \"" + holderReference.getName() + "\", expected \"" + cVCPrincipal.getName() + "\"");
                                    }
                                }
                                if (cVCPrincipal == null) {
                                    cVCPrincipal = holderReference;
                                }
                                list.remove(0);
                            }
                            CVCPrincipal authorityReference = cardVerifiableCertificate.getAuthorityReference();
                            if (cVCPrincipal != null) {
                                if (!cVCPrincipal.equals(authorityReference)) {
                                    throw new CardServiceException("First certificate not signed by expected CA, found " + authorityReference.getName() + ", expected " + cVCPrincipal.getName());
                                }
                            }
                            cVCPrincipal2 = cVCPrincipal == null ? authorityReference : cVCPrincipal;
                            CardVerifiableCertificate cardVerifiableCertificate2 = list.get(list.size() - 1);
                            CVCAuthorizationTemplate.Role role = cardVerifiableCertificate2.getAuthorizationTemplate().getRole();
                            if (CVCAuthorizationTemplate.Role.IS.equals(role)) {
                                for (CardVerifiableCertificate next : list) {
                                    this.service.sendMSESetDST(this.wrapper, TLVUtil.wrapDO(131, next.getAuthorityReference().getName().getBytes("ISO-8859-1")));
                                    byte[] certBodyData = next.getCertBodyData();
                                    byte[] signature = next.getSignature();
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    TLVOutputStream tLVOutputStream = new TLVOutputStream(byteArrayOutputStream);
                                    tLVOutputStream.writeTag(TAG_CVCERTIFICATE_SIGNATURE);
                                    tLVOutputStream.writeValue(signature);
                                    tLVOutputStream.close();
                                    this.service.sendPSOExtendedLengthMode(this.wrapper, certBodyData, byteArrayOutputStream.toByteArray());
                                }
                                if (privateKey != null) {
                                    this.service.sendMSESetATExtAuth(this.wrapper, TLVUtil.wrapDO(131, cardVerifiableCertificate2.getHolderReference().getName().getBytes("ISO-8859-1")));
                                    sendGetChallenge = this.service.sendGetChallenge(this.wrapper);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    byteArrayOutputStream2.write(bArr);
                                    byteArrayOutputStream2.write(sendGetChallenge);
                                    byteArrayOutputStream2.write(keyHash);
                                    byteArrayOutputStream2.close();
                                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                    String sigAlgName = cardVerifiableCertificate2.getSigAlgName();
                                    if (sigAlgName != null) {
                                        Signature instance = Signature.getInstance(sigAlgName, BC_PROVIDER);
                                        instance.initSign(privateKey);
                                        instance.update(byteArray);
                                        byte[] sign = instance.sign();
                                        if (sigAlgName.toUpperCase().endsWith("ECDSA")) {
                                            sign = Util.getRawECDSASignature(sign, (int) Math.ceil(((double) ((ECPrivateKey) privateKey).getParameters().getCurve().getFieldSize()) / 8.0d));
                                        }
                                        this.service.sendMutualAuthenticate(this.wrapper, sign);
                                    } else {
                                        throw new IllegalStateException("Could not determine signature algorithm for terminal certificate " + cardVerifiableCertificate2.getHolderReference().getName());
                                    }
                                } else {
                                    throw new CardServiceException("No terminal key");
                                }
                            } else {
                                throw new CardServiceException("Last certificate in chain (" + cardVerifiableCertificate2.getHolderReference().getName() + ") does not have role IS, but has role " + role);
                            }
                        } else {
                            throw new IllegalArgumentException("Could nnot get EAC-CA key hash");
                        }
                    } else {
                        throw new IllegalArgumentException("Could not get EAC-CA key hash");
                    }
                }
            } catch (Exception e11) {
                throw new CardServiceProtocolException("Exception in MSE Set AT", 3, (Throwable) e11);
            } catch (Exception e12) {
                throw new CardServiceProtocolException("Exception in Get Challenge", 4, (Throwable) e12);
            } catch (Exception e13) {
                LOGGER.log(Level.WARNING, "Exception", e13);
                throw new CardServiceProtocolException("Exception in External Authenticate", 5, (Throwable) e13);
            } catch (Exception e14) {
                throw new CardServiceProtocolException("Exception in MSE:SetDST", 1, (Throwable) e14);
            } catch (Exception e15) {
                throw new CardServiceProtocolException("Exception", 2, (Throwable) e15);
            } catch (CardServiceException e16) {
                throw e16;
            } catch (Exception e17) {
                throw new CardServiceException("Unexpected exception", (Throwable) e17);
            }
        }
        throw new IllegalArgumentException("Need at least 1 certificate to perform TA, found: " + list);
        return new EACTAResult(eACCAResult, cVCPrincipal2, list, privateKey, (String) null, sendGetChallenge);
    }

    public static byte[] deriveIdentifier(PublicKey publicKey) throws NoSuchAlgorithmException {
        if (publicKey == null) {
            return null;
        }
        String algorithm = publicKey.getAlgorithm();
        if ("DH".equals(algorithm) || (publicKey instanceof DHPublicKey)) {
            return MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA1).digest(Util.i2os(((DHPublicKey) publicKey).getY()));
        }
        if ("ECDH".equals(algorithm) || (publicKey instanceof ECPublicKey)) {
            org.bouncycastle.jce.interfaces.ECPublicKey eCPublicKey = (org.bouncycastle.jce.interfaces.ECPublicKey) publicKey;
            return Util.alignKeyDataToSize(Util.i2os(eCPublicKey.getQ().getAffineXCoord().toBigInteger()), (int) Math.ceil(((double) eCPublicKey.getParameters().getCurve().getFieldSize()) / 8.0d));
        }
        throw new NoSuchAlgorithmException("Unsupported agreement algorithm " + algorithm);
    }
}

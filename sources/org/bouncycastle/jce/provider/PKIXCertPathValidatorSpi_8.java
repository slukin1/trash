package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi_8 extends CertPathValidatorSpi {
    private final JcaJceHelper helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathValidatorSpi_8() {
        this(false);
    }

    public PKIXCertPathValidatorSpi_8(boolean z11) {
        this.helper = new BCJcaJceHelper();
        this.isForCRLCheck = z11;
    }

    public static void checkCertificate(X509Certificate x509Certificate) throws AnnotatedException {
        if (x509Certificate instanceof BCX509Certificate) {
            RuntimeException runtimeException = null;
            try {
                if (((BCX509Certificate) x509Certificate).getTBSCertificateNative() != null) {
                    return;
                }
            } catch (RuntimeException e11) {
                runtimeException = e11;
            }
            throw new AnnotatedException("unable to process TBSCertificate", runtimeException);
        }
        try {
            TBSCertificate.getInstance(x509Certificate.getTBSCertificate());
        } catch (CertificateEncodingException e12) {
            throw new AnnotatedException("unable to process TBSCertificate", e12);
        } catch (IllegalArgumentException e13) {
            throw new AnnotatedException(e13.getMessage());
        }
    }

    public PKIXCertPathChecker engineGetRevocationChecker() {
        return new ProvRevocationChecker(this.helper);
    }

    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters pKIXExtendedParameters;
        List<? extends Certificate> list;
        int i11;
        PublicKey publicKey;
        X500Name x500Name;
        HashSet hashSet;
        ArrayList arrayList;
        int i12;
        int i13;
        HashSet hashSet2;
        CertPath certPath2 = certPath;
        CertPathParameters certPathParameters2 = certPathParameters;
        if (certPathParameters2 instanceof PKIXParameters) {
            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder((PKIXParameters) certPathParameters2);
            if (certPathParameters2 instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters2;
                builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                builder.setValidityModel(extendedPKIXParameters.getValidityModel());
            }
            pKIXExtendedParameters = builder.build();
        } else if (certPathParameters2 instanceof PKIXExtendedBuilderParameters) {
            pKIXExtendedParameters = ((PKIXExtendedBuilderParameters) certPathParameters2).getBaseParameters();
        } else if (certPathParameters2 instanceof PKIXExtendedParameters) {
            pKIXExtendedParameters = (PKIXExtendedParameters) certPathParameters2;
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
        }
        if (pKIXExtendedParameters.getTrustAnchors() != null) {
            List<? extends Certificate> certificates = certPath.getCertificates();
            int size = certificates.size();
            if (!certificates.isEmpty()) {
                Date validityDate = CertPathValidatorUtilities.getValidityDate(pKIXExtendedParameters, new Date());
                Set initialPolicies = pKIXExtendedParameters.getInitialPolicies();
                try {
                    TrustAnchor findTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), pKIXExtendedParameters.getTrustAnchors(), pKIXExtendedParameters.getSigProvider());
                    if (findTrustAnchor != null) {
                        checkCertificate(findTrustAnchor.getTrustedCert());
                        PKIXExtendedParameters build = new PKIXExtendedParameters.Builder(pKIXExtendedParameters).setTrustAnchor(findTrustAnchor).build();
                        ArrayList arrayList2 = new ArrayList();
                        PKIXCertRevocationChecker pKIXCertRevocationChecker = null;
                        for (PKIXCertPathChecker pKIXCertPathChecker : build.getCertPathCheckers()) {
                            pKIXCertPathChecker.init(false);
                            if (!(pKIXCertPathChecker instanceof PKIXRevocationChecker)) {
                                arrayList2.add(pKIXCertPathChecker);
                            } else if (pKIXCertRevocationChecker == null) {
                                pKIXCertRevocationChecker = pKIXCertPathChecker instanceof PKIXCertRevocationChecker ? (PKIXCertRevocationChecker) pKIXCertPathChecker : new WrappedRevocationChecker(pKIXCertPathChecker);
                            } else {
                                throw new CertPathValidatorException("only one PKIXRevocationChecker allowed");
                            }
                        }
                        if (build.isRevocationEnabled() && pKIXCertRevocationChecker == null) {
                            pKIXCertRevocationChecker = new ProvRevocationChecker(this.helper);
                        }
                        PKIXCertRevocationChecker pKIXCertRevocationChecker2 = pKIXCertRevocationChecker;
                        int i14 = size + 1;
                        ArrayList[] arrayListArr = new ArrayList[i14];
                        for (int i15 = 0; i15 < i14; i15++) {
                            arrayListArr[i15] = new ArrayList();
                        }
                        HashSet hashSet3 = new HashSet();
                        hashSet3.add("2.5.29.32.0");
                        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, (PolicyNode) null, new HashSet(), "2.5.29.32.0", false);
                        arrayListArr[0].add(pKIXPolicyNode);
                        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                        HashSet hashSet4 = new HashSet();
                        int i16 = build.isExplicitPolicyRequired() ? 0 : i14;
                        int i17 = build.isAnyPolicyInhibited() ? 0 : i14;
                        if (build.isPolicyMappingInhibited()) {
                            i14 = 0;
                        }
                        X509Certificate trustedCert = findTrustAnchor.getTrustedCert();
                        if (trustedCert != null) {
                            try {
                                x500Name = PrincipalUtils.getSubjectPrincipal(trustedCert);
                                publicKey = trustedCert.getPublicKey();
                            } catch (RuntimeException e11) {
                                throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e11, certPath2, -1);
                            }
                        } else {
                            x500Name = PrincipalUtils.getCA(findTrustAnchor);
                            publicKey = findTrustAnchor.getCAPublicKey();
                        }
                        try {
                            AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                            algorithmIdentifier.getAlgorithm();
                            algorithmIdentifier.getParameters();
                            if (build.getTargetConstraints() == null || build.getTargetConstraints().match((Certificate) (X509Certificate) certificates.get(0))) {
                                boolean z11 = true;
                                int size2 = certificates.size() - 1;
                                int i18 = size;
                                X509Certificate x509Certificate = null;
                                int i19 = i17;
                                int i21 = i14;
                                int i22 = i16;
                                PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                while (size2 >= 0) {
                                    int i23 = size - size2;
                                    int i24 = size;
                                    X509Certificate x509Certificate2 = (X509Certificate) certificates.get(size2);
                                    boolean z12 = size2 == certificates.size() + -1 ? z11 : false;
                                    try {
                                        checkCertificate(x509Certificate2);
                                        int i25 = size2;
                                        List<? extends Certificate> list2 = certificates;
                                        PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                                        Date date = validityDate;
                                        Date date2 = validityDate;
                                        ArrayList[] arrayListArr2 = arrayListArr;
                                        PKIXExtendedParameters pKIXExtendedParameters2 = build;
                                        int i26 = i22;
                                        ArrayList arrayList3 = arrayList2;
                                        boolean z13 = z12;
                                        TrustAnchor trustAnchor = findTrustAnchor;
                                        int i27 = i21;
                                        boolean z14 = z11;
                                        RFC3280CertPathUtilities.processCertA(certPath, build, date, pKIXCertRevocationChecker2, i25, publicKey, z13, x500Name, trustedCert);
                                        int i28 = i25;
                                        RFC3280CertPathUtilities.processCertBC(certPath2, i28, pKIXNameConstraintValidator2, this.isForCRLCheck);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath2, i28, RFC3280CertPathUtilities.processCertD(certPath, i28, hashSet4, pKIXPolicyNode2, arrayListArr2, i19, this.isForCRLCheck));
                                        RFC3280CertPathUtilities.processCertF(certPath2, i28, processCertE, i26);
                                        int i29 = i24;
                                        if (i23 != i29) {
                                            if (x509Certificate2 == null || x509Certificate2.getVersion() != z14) {
                                                RFC3280CertPathUtilities.prepareNextCertA(certPath2, i28);
                                                arrayListArr = arrayListArr2;
                                                int i30 = i27;
                                                PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath2, i28, arrayListArr, processCertE, i30);
                                                RFC3280CertPathUtilities.prepareNextCertG(certPath2, i28, pKIXNameConstraintValidator2);
                                                int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath2, i28, i26);
                                                int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath2, i28, i30);
                                                int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath2, i28, i19);
                                                i26 = RFC3280CertPathUtilities.prepareNextCertI1(certPath2, i28, prepareNextCertH1);
                                                i13 = RFC3280CertPathUtilities.prepareNextCertI2(certPath2, i28, prepareNextCertH2);
                                                i12 = RFC3280CertPathUtilities.prepareNextCertJ(certPath2, i28, prepareNextCertH3);
                                                RFC3280CertPathUtilities.prepareNextCertK(certPath2, i28);
                                                i18 = RFC3280CertPathUtilities.prepareNextCertM(certPath2, i28, RFC3280CertPathUtilities.prepareNextCertL(certPath2, i28, i18));
                                                RFC3280CertPathUtilities.prepareNextCertN(certPath2, i28);
                                                Set criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                                                if (criticalExtensionOIDs != null) {
                                                    hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                                    hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                                    hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                                    hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                                    hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                                    hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                                    hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                                } else {
                                                    hashSet2 = new HashSet();
                                                }
                                                arrayList = arrayList3;
                                                RFC3280CertPathUtilities.prepareNextCertO(certPath2, i28, hashSet2, arrayList);
                                                X500Name subjectPrincipal = PrincipalUtils.getSubjectPrincipal(x509Certificate2);
                                                try {
                                                    PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), i28, this.helper);
                                                    AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                                    algorithmIdentifier2.getAlgorithm();
                                                    algorithmIdentifier2.getParameters();
                                                    pKIXPolicyNode2 = prepareCertB;
                                                    x500Name = subjectPrincipal;
                                                    publicKey = nextWorkingKey;
                                                    trustedCert = x509Certificate2;
                                                    i22 = i26;
                                                    int i31 = i28 - 1;
                                                    i19 = i12;
                                                    arrayList2 = arrayList;
                                                    z11 = z14;
                                                    findTrustAnchor = trustAnchor;
                                                    validityDate = date2;
                                                    i21 = i13;
                                                    pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                                    x509Certificate = x509Certificate2;
                                                    certificates = list2;
                                                    size = i29;
                                                    size2 = i31;
                                                    build = pKIXExtendedParameters2;
                                                } catch (CertPathValidatorException e12) {
                                                    throw new CertPathValidatorException("Next working key could not be retrieved.", e12, certPath2, i28);
                                                }
                                            } else if (i23 != z14 || !x509Certificate2.equals(trustAnchor.getTrustedCert())) {
                                                throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", (Throwable) null, certPath2, i28);
                                            }
                                        }
                                        i12 = i19;
                                        arrayListArr = arrayListArr2;
                                        arrayList = arrayList3;
                                        i13 = i27;
                                        pKIXPolicyNode2 = processCertE;
                                        i18 = i18;
                                        i22 = i26;
                                        int i312 = i28 - 1;
                                        i19 = i12;
                                        arrayList2 = arrayList;
                                        z11 = z14;
                                        findTrustAnchor = trustAnchor;
                                        validityDate = date2;
                                        i21 = i13;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                        x509Certificate = x509Certificate2;
                                        certificates = list2;
                                        size = i29;
                                        size2 = i312;
                                        build = pKIXExtendedParameters2;
                                    } catch (AnnotatedException e13) {
                                        AnnotatedException annotatedException = e13;
                                        throw new CertPathValidatorException(annotatedException.getMessage(), annotatedException.getUnderlyingException(), certPath2, size2);
                                    }
                                }
                                PKIXExtendedParameters pKIXExtendedParameters3 = build;
                                ArrayList arrayList4 = arrayList2;
                                TrustAnchor trustAnchor2 = findTrustAnchor;
                                X509Certificate x509Certificate3 = x509Certificate;
                                int i32 = size2;
                                int i33 = i32 + 1;
                                int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath2, i33, RFC3280CertPathUtilities.wrapupCertA(i22, x509Certificate3));
                                Set criticalExtensionOIDs2 = x509Certificate3.getCriticalExtensionOIDs();
                                if (criticalExtensionOIDs2 != null) {
                                    hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                    hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                    hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                    hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                    hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                    hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                    hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                                    hashSet.remove(Extension.extendedKeyUsage.getId());
                                } else {
                                    hashSet = new HashSet();
                                }
                                RFC3280CertPathUtilities.wrapupCertF(certPath2, i33, arrayList4, hashSet);
                                PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, pKIXExtendedParameters3, initialPolicies, i33, arrayListArr, pKIXPolicyNode2, hashSet4);
                                if (wrapupCertB > 0 || wrapupCertG != null) {
                                    return new PKIXCertPathValidatorResult(trustAnchor2, wrapupCertG, x509Certificate3.getPublicKey());
                                }
                                throw new CertPathValidatorException("Path processing failed on policy.", (Throwable) null, certPath2, i32);
                            }
                            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", (Throwable) null, certPath2, 0);
                        } catch (CertPathValidatorException e14) {
                            throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e14, certPath2, -1);
                        }
                    } else {
                        i11 = 1;
                        list = certificates;
                        try {
                            throw new CertPathValidatorException("Trust anchor for certification path not found.", (Throwable) null, certPath2, -1);
                        } catch (AnnotatedException e15) {
                            e = e15;
                            throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, list.size() - i11);
                        }
                    }
                } catch (AnnotatedException e16) {
                    e = e16;
                    i11 = 1;
                    list = certificates;
                    throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, list.size() - i11);
                }
            } else {
                throw new CertPathValidatorException("Certification path is empty.", (Throwable) null, certPath2, -1);
            }
        } else {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
    }
}

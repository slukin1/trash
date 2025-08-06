package org.jmrtd.protocol;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.util.Hex;
import org.jmrtd.Util;
import org.jmrtd.cert.CVCPrincipal;
import org.jmrtd.cert.CardVerifiableCertificate;

public class EACTAResult implements Serializable {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -2926063872890928748L;
    private CVCPrincipal caReference;
    private byte[] cardChallenge;
    private EACCAResult chipAuthenticationResult;
    private String documentNumber;
    private List<CardVerifiableCertificate> terminalCertificates = new ArrayList();
    private PrivateKey terminalKey;

    public EACTAResult(EACCAResult eACCAResult, CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, byte[] bArr) {
        this.chipAuthenticationResult = eACCAResult;
        this.caReference = cVCPrincipal;
        for (CardVerifiableCertificate add : list) {
            this.terminalCertificates.add(add);
        }
        this.terminalKey = privateKey;
        this.documentNumber = str;
        this.cardChallenge = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EACTAResult eACTAResult = (EACTAResult) obj;
        CVCPrincipal cVCPrincipal = this.caReference;
        if (cVCPrincipal == null) {
            if (eACTAResult.caReference != null) {
                return false;
            }
        } else if (!cVCPrincipal.equals(eACTAResult.caReference)) {
            return false;
        }
        if (!Arrays.equals(this.cardChallenge, eACTAResult.cardChallenge)) {
            return false;
        }
        EACCAResult eACCAResult = this.chipAuthenticationResult;
        if (eACCAResult == null) {
            if (eACTAResult.chipAuthenticationResult != null) {
                return false;
            }
        } else if (!eACCAResult.equals(eACTAResult.chipAuthenticationResult)) {
            return false;
        }
        String str = this.documentNumber;
        if (str == null) {
            if (eACTAResult.documentNumber != null) {
                return false;
            }
        } else if (!str.equals(eACTAResult.documentNumber)) {
            return false;
        }
        List<CardVerifiableCertificate> list = this.terminalCertificates;
        if (list == null) {
            if (eACTAResult.terminalCertificates != null) {
                return false;
            }
        } else if (!list.equals(eACTAResult.terminalCertificates)) {
            return false;
        }
        PrivateKey privateKey = this.terminalKey;
        if (privateKey != null) {
            return privateKey.equals(eACTAResult.terminalKey);
        }
        if (eACTAResult.terminalKey == null) {
            return true;
        }
        return false;
    }

    public CVCPrincipal getCAReference() {
        return this.caReference;
    }

    public List<CardVerifiableCertificate> getCVCertificates() {
        return this.terminalCertificates;
    }

    public byte[] getCardChallenge() {
        return this.cardChallenge;
    }

    public EACCAResult getChipAuthenticationResult() {
        return this.chipAuthenticationResult;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public PrivateKey getTerminalKey() {
        return this.terminalKey;
    }

    public int hashCode() {
        CVCPrincipal cVCPrincipal = this.caReference;
        int i11 = 0;
        int hashCode = ((((cVCPrincipal == null ? 0 : cVCPrincipal.hashCode()) + 31) * 31) + Arrays.hashCode(this.cardChallenge)) * 31;
        EACCAResult eACCAResult = this.chipAuthenticationResult;
        int hashCode2 = (hashCode + (eACCAResult == null ? 0 : eACCAResult.hashCode())) * 31;
        String str = this.documentNumber;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<CardVerifiableCertificate> list = this.terminalCertificates;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        PrivateKey privateKey = this.terminalKey;
        if (privateKey != null) {
            i11 = privateKey.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TAResult [chipAuthenticationResult: " + this.chipAuthenticationResult);
        sb2.append(", ");
        sb2.append("caReference: " + this.caReference);
        sb2.append(", ");
        sb2.append("terminalCertificates: [");
        boolean z11 = true;
        for (CardVerifiableCertificate next : this.terminalCertificates) {
            if (z11) {
                z11 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(toString(next));
        }
        sb2.append("terminalKey = ");
        sb2.append(Util.getDetailedPrivateKeyAlgorithm(this.terminalKey));
        sb2.append(", ");
        sb2.append("documentNumber = ");
        sb2.append(this.documentNumber);
        sb2.append(", ");
        sb2.append("cardChallenge = ");
        sb2.append(Hex.bytesToHexString(this.cardChallenge));
        sb2.append(", ");
        sb2.append("]");
        return sb2.toString();
    }

    private Object toString(CardVerifiableCertificate cardVerifiableCertificate) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CardVerifiableCertificate [");
        try {
            CVCPrincipal holderReference = cardVerifiableCertificate.getHolderReference();
            if (!this.caReference.equals(holderReference)) {
                sb2.append("holderReference: " + holderReference);
            }
        } catch (CertificateException e11) {
            sb2.append("holderReference = ???");
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
        sb2.append("]");
        return sb2.toString();
    }
}
